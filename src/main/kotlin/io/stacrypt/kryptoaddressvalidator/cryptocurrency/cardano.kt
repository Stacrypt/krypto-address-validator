package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32MaxLength
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58

class CardanoValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = when (chainType) {
        CardanoChainType.CARDANO ->  address.isValidAddressV1() || address.isValidAddressShelley()
        CardanoChainType.BEP20 -> address.isValidBitcoinAddress(network ?: CardanoNetwork.Mainnet)
        CardanoChainType.DEFAULT -> address.checkAllChains(network ?: CardanoNetwork.Mainnet)
        else -> address.checkAllChains(network ?: CardanoNetwork.Mainnet)
    }

    private fun String.checkAllChains(network: Network): Boolean {
        return isValidAddressV1() || isValidAddressShelley() || isValidBitcoinAddress(network)
    }
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

enum class CardanoNetwork : Network {
    Mainnet,
    Testnet
}

enum class CardanoChainType: ChainType {
    CARDANO,
    BEP20,
    DEFAULT
}

