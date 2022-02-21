package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class ChainLinkValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            LinkChainType.BEP20 -> address.isValidBitcoinAddress(network ?: LinkNetwork.Mainnet)
            LinkChainType.ERC20 -> address.isValidEthereumAddress(network ?: LinkNetwork.Mainnet)
            LinkChainType.DEFAULT -> address.checkAllChains(network ?: LinkNetwork.Mainnet)
            else -> address.checkAllChains(network ?: LinkNetwork.Mainnet)
        }
    }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidEthereumAddress(network)
}

enum class LinkNetwork : Network {
    Mainnet,
    Testnet
}

enum class LinkChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20
}