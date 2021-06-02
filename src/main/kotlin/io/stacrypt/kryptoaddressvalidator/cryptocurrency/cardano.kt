package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32MaxLength
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58

enum class CardanoNetwork : Network {
    Mainnet,
    Testnet
}

fun String.isValidCardanoAddress(network: Network, currency: CryptoCurrency): Boolean {
    return isValidAddressV1() || isValidAddressShelley()
}


// Byron addresses
private fun String.isValidAddressV1(): Boolean {
    try {
        val decodedAddress = this.decodeBase58()
        // Icarus-style
        if (startsWith("Ae2"))
            return true
        // Daedalus-style
        if (startsWith("DdzFF"))
            return true

        return false
    } catch (e: Exception) {
        return false
    }

}

// Shelley addresses
private fun String.isValidAddressShelley(): Boolean {
    try {
        val decodedAddress = decodeBech32MaxLength()
        if (decodedAddress.humanReadablePart == "addr") return true
        return false
    } catch (e: Exception) {
        return false
    }
}

