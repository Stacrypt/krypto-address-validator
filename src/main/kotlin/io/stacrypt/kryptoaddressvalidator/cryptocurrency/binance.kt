package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32
import io.stacrypt.kryptoaddressvalidator.utils.Utils.convertBits

class BinanceValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            BinanceChainType.BEP20 -> address.isValidBitcoinAddress(network ?: BinanceChainNetwork.Mainnet)
            BinanceChainType.BEP2 -> address.isValidBinanceChainAddress(network ?: BinanceChainNetwork.Mainnet)
            BinanceChainType.DEFAULT -> address.checkAllChains(network ?: BinanceChainNetwork.Mainnet)
            else -> address.checkAllChains(network ?: BinanceChainNetwork.Mainnet)
        }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidBinanceChainAddress(network)

    private fun String.isValidBinanceChainAddress(network: Network): Boolean {
        try {
            val decodedAddress = decodeBech32()
            val data = decodedAddress.data

            if (data.isEmpty()) return false

            val dataWithNoVersion = ByteArray(data.size - 1)
            System.arraycopy(data, 1, dataWithNoVersion, 0, dataWithNoVersion.size)
            val res = convertBits(dataWithNoVersion, 5, 8, false)

            if (res != null) {
                if (res.size < 2 || res.size > 40) return false
                if (res.size != 19) return false
            }

            when (network) {
                BinanceChainNetwork.Mainnet ->
                    if (decodedAddress.humanReadablePart.startsWith("bnb")) return true
                BinanceChainNetwork.Testnet ->
                    if (decodedAddress.humanReadablePart.startsWith("tbnb")) return true
            }
            return false
        } catch (e: Exception) {
            return false
        }
    }
}

enum class BinanceChainNetwork : Network {
    Mainnet,
    Testnet
}

enum class BinanceChainType : ChainType {
    DEFAULT,
    BEP20,
    BEP2
}



