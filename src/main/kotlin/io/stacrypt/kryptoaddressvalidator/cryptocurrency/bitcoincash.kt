package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.verifyChecksum
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum
import org.apache.commons.codec.binary.Base32
import java.util.*

class BitcoinCashValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        address.isValidBitcoinCashAddress(chainType, network)
}

@OptIn(ExperimentalUnsignedTypes::class)
fun String.isValidBitcoinCashAddress(chainType: ChainType?, network: Network?): Boolean {
    return when (chainType) {
        ChainType.BCH -> isValidBitcoinCash(network) || isValidBitcoinAddress(network)
        ChainType.BSC -> isValidEthereumAddress()
        ChainType.DEFAULT -> isValidBitcoinCash(network) || isValidBitcoinAddress(network) || isValidEthereumAddress()
        else -> throw ChainNotSupportException()
    }
}

private fun String.isValidBitcoinCash(network: Network?): Boolean {
    if (this.isEmpty()) return false
    val mainnetPrefix = "bitcoincash"
    val testnetPrefix = "bchtest"
    var bitcoinCashAddress = this
    val prefix: String
    if (this.contains(":")) {
        val splits = this.split(":")
        if (splits.size != 2) {
            return false
        }
        prefix = splits[0]
        bitcoinCashAddress = splits[1]
        when (network) {
            Network.Mainnet -> {
                if (mainnetPrefix != prefix.lowercase(Locale.getDefault())) return false
            }
            Network.Testnet -> {
                if (testnetPrefix != prefix.lowercase(Locale.getDefault())) return false
            }
            else -> return false
        }
        if (!isSingleCase(prefix)) return false

    } else {
        prefix = if (network == Network.Mainnet) mainnetPrefix else testnetPrefix
    }

    if (!isSingleCase(bitcoinCashAddress)) return false

    bitcoinCashAddress = bitcoinCashAddress.lowercase(Locale.getDefault())

    val decoded = Base32().encode(bitcoinCashAddress.toByteArray())
    try {
        if (verifyChecksum(prefix, decoded))
            return false
    } catch (e: Exception) {
        return false
    }
    return true
}

@OptIn(ExperimentalUnsignedTypes::class)
private fun String.isValidBep20(network: Network?): Boolean {
    if (this.isEmpty()) return false
    try {
        val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
        val byteArray = decodeBase58WithChecksum.toUByteArray()

        if (byteArray.size == 21) {
            if (byteArray.getBitcoinCashAddressType() == network) return true
        }
        return false
    } catch (e: Exception) {
        return false
    }
}

fun isSingleCase(bitcoinCashAddress: String): Boolean {
    if (bitcoinCashAddress == bitcoinCashAddress.lowercase(Locale.getDefault())) return true
    if (bitcoinCashAddress == bitcoinCashAddress.uppercase(Locale.getDefault())) return true
    return false
}

@ExperimentalUnsignedTypes
fun UByteArray.getBitcoinCashAddressType(): Network? {
    if (this[0] == 0.toUByte() ||
        this[0] == 5.toUByte()
    ) {
        return Network.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte()
    ) {
        return Network.Testnet
    }

    return null
}