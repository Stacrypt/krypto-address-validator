package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class UniValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            UniChainType.BEP20 -> address.isValidBitcoinAddress(network ?: UniNetwork.Mainnet)
            UniChainType.ERC20 -> address.isValidEthereumAddress(network ?: UniNetwork.Mainnet)
            UniChainType.DEFAULT -> address.checkAllChains(network ?: UniNetwork.Mainnet)
            else -> address.checkAllChains(network ?: UniNetwork.Mainnet)
        }
    }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidEthereumAddress(network)
}

enum class UniNetwork : Network {
    Mainnet,
    Testnet
}

enum class UniChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20
}