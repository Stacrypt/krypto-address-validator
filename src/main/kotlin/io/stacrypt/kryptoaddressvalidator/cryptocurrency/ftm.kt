package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class FantomValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            FantomChainType.BEP20 -> address.isValidBitcoinAddress(network ?: FantomNetwork.Mainnet)
            FantomChainType.ERC20 -> address.isValidEthereumAddress(network ?: FantomNetwork.Mainnet)
            FantomChainType.FTM -> address.isValidEthereumAddress(network ?: FantomNetwork.Mainnet)
            FantomChainType.DEFAULT -> address.checkAllChains(network ?: FantomNetwork.Mainnet)
            else -> address.checkAllChains(network ?: FantomNetwork.Mainnet)
        }
    }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidEthereumAddress(network)
}

enum class FantomNetwork : Network {
    Mainnet,
    Testnet
}

enum class FantomChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20,
    FTM
}