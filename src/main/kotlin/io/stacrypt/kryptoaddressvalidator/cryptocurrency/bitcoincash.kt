package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.verifyChecksum
import org.apache.commons.codec.binary.Base32

class BitcoinCashValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = when(chainType) {
        BitcoinCashChainType.BITCOINCASH -> address.isValidBitcoinCashAddress(network ?: BitcoinCashNetwork.Mainnet)
        BitcoinCashChainType.BEP20 -> address.isValidBitcoinAddress(network ?: BitcoinCashNetwork.Mainnet)
        BitcoinCashChainType.DEFAULT -> address.checkAllChains(network ?: BitcoinCashNetwork.Mainnet)
        else -> address.checkAllChains(network ?: BitcoinCashNetwork.Mainnet)
    }
}

@ExperimentalUnsignedTypes
private fun String.checkAllChains(network: Network): Boolean {
    return isValidBitcoinCashAddress(network) || isValidBitcoinAddress(network)
}

@JvmName("isValidBitcoinCashAddress1")
fun String.isValidBitcoinCashAddress(network: Network): Boolean {
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
            BitcoinCashNetwork.Mainnet -> {
                if (mainnetPrefix != prefix.toLowerCase()) return false
            }
            BitcoinCashNetwork.Testnet -> {
                if (testnetPrefix != prefix.toLowerCase()) return false
            }
            else -> return false
        }
        if (!isSingleCase(prefix)) return false

    } else {
        prefix = if (network === BitcoinCashNetwork.Mainnet) mainnetPrefix else testnetPrefix
    }

    if (!isSingleCase(bitcoinCashAddress)) return false

    bitcoinCashAddress = bitcoinCashAddress.toLowerCase()

    val decoded = Base32().encode(bitcoinCashAddress.toByteArray())
    try {
        if (verifyChecksum(prefix, decoded)) return false
    } catch (e: Exception) {
        return false
    }
    return true
}

fun isSingleCase(bitcoinCashAddress: String): Boolean {
    if (bitcoinCashAddress == bitcoinCashAddress.toLowerCase()) return true
    if (bitcoinCashAddress == bitcoinCashAddress.toUpperCase()) return true
    return false
}

@ExperimentalUnsignedTypes
fun UByteArray.getBitcoinCashAddressType(): BitcoinCashNetwork? {
    if (this[0] == 0.toUByte() ||
        this[0] == 5.toUByte()
    ) {
        return BitcoinCashNetwork.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte()
    ) {
        return BitcoinCashNetwork.Testnet
    }

    return null
}

enum class BitcoinCashChainType: ChainType {
    DEFAULT,
    BITCOINCASH,
    BEP20
}

enum class BitcoinCashNetwork : Network {
    Mainnet,
    Testnet
}