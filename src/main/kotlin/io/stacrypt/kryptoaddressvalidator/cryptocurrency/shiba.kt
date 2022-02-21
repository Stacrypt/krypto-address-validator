package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class ShibaValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = when (chainType) {
            ShibChainType.BEP20 -> address.isValidBitcoinAddress(network ?: ShibNetwork.Mainnet)
            ShibChainType.ERC20 -> address.isValidEthereumAddress(network ?: ShibNetwork.Mainnet)
            ShibChainType.DEFAULT -> address.checkAllChains(network ?: ShibNetwork.Mainnet)
            else -> address.checkAllChains(network ?: ShibNetwork.Mainnet)
        }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidEthereumAddress(network)
}

enum class ShibNetwork : Network {
    Mainnet,
    Testnet
}

enum class ShibChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20
}