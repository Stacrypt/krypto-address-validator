package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class ManaValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            ManaChainType.ERC20 -> address.isValidEthereumAddress(network ?: ManaNetwork.Mainnet)
            else -> false
        }
    }
}

enum class ManaNetwork : Network {
    Mainnet,
    Testnet
}

enum class ManaChainType : ChainType {
    ERC20
}