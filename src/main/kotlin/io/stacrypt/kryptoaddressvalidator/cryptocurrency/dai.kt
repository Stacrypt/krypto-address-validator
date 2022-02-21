package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class DaiValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            DaiChainType.BEP20 -> address.isValidBitcoinAddress(network ?: DaiNetwork.Mainnet)
            DaiChainType.ERC20 -> address.isValidEthereumAddress(network ?: DaiNetwork.Mainnet)
            DaiChainType.DEFAULT -> address.checkAllChains(network ?: DaiNetwork.Mainnet)
            else -> address.checkAllChains(network ?: DaiNetwork.Mainnet)
        }
    }

    private fun String.checkAllChains(network: Network) =
        isValidBitcoinAddress(network) || isValidEthereumAddress(network)
}

enum class DaiNetwork : Network {
    Mainnet,
    Testnet
}

enum class DaiChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20
}