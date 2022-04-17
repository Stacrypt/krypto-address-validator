package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class MaticValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            MaticChainType.BEP20 -> address.isValidBitcoinAddress(network ?: MaticNetwork.Mainnet)
            MaticChainType.ERC20 -> address.isValidEthereumAddress(network ?: MaticNetwork.Mainnet)
            MaticChainType.MATIC -> address.isValidEthereumAddress(network ?: MaticNetwork.Mainnet)
            MaticChainType.DEFAULT -> address.checkAllChains(network ?: MaticNetwork.Mainnet)
            else -> address.checkAllChains(network ?: MaticNetwork.Mainnet)
        }
    }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidEthereumAddress(network)
}

enum class MaticNetwork : Network {
    Mainnet,
    Testnet
}

enum class MaticChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20,
    MATIC
}