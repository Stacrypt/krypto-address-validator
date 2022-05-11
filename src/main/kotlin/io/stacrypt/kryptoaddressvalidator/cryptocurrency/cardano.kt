package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32MaxLength
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58

class CardanoValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = when (chainType) {
        ChainType.ADA ->  address.isValidAddressV1() || address.isValidAddressShelley()
        ChainType.BSC -> address.isValidEthereumAddress()
        ChainType.DEFAULT -> address.checkAllChains()
        else -> throw ChainNotSupportException()
    }

    private fun String.checkAllChains(): Boolean {
        return isValidAddressV1() || isValidAddressShelley() || isValidEthereumAddress()
    }
}



// Byron addresses
private fun String.isValidAddressV1(): Boolean {
    try {
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
