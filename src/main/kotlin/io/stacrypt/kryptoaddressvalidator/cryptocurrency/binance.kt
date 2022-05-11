package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32
import io.stacrypt.kryptoaddressvalidator.utils.Utils.convertBits

class BinanceValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.BSC -> address.isValidEthereumAddress()
            ChainType.BNB -> address.isValidBinanceChainAddress(network ?: Network.Mainnet)
            ChainType.DEFAULT -> address.checkAllChains(network ?: Network.Mainnet)
            else -> throw ChainNotSupportException()
        }

    private fun String.checkAllChains(network: Network) =
        isValidEthereumAddress()|| isValidBinanceChainAddress(network)

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
                Network.Mainnet ->
                    if (decodedAddress.humanReadablePart.startsWith("bnb")) return true
                Network.Testnet ->
                    if (decodedAddress.humanReadablePart.startsWith("tbnb")) return true
            }
            return false
        } catch (e: Exception) {
            return false
        }
    }
}



