package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.verifyChecksum
import org.apache.commons.codec.binary.Base32


enum class BitcoinCashNetwork : Network {
    Mainnet,
    Testnet
}

@ExperimentalUnsignedTypes
fun String.isValidBitcoinCashAddress(network: Network, cryptoCurrency: CryptoCurrency): Boolean {
    return isValidBitcoinCashAddress(this, network) || isValidBitcoinAddress(
        network,
        cryptoCurrency
    )
}

@JvmName("isValidBitcoinCashAddress1")
private fun isValidBitcoinCashAddress(address: String, network: Network): Boolean {
    if (address.isEmpty()) return false
    val mainnetPrefix = "bitcoincash"
    val testnetPrefix = "bchtest"
    var bitcoinCashAddress = address
    val prefix: String
    if (address.contains(":")) {
        val splits = address.split(":")
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

private fun isSingleCase(bitcoinCashAddress: String): Boolean {
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