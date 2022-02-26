package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class TetherValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        address.isValidTetherAddress(network ?: TetherNetwork.Mainnet, chainType as TetherChainType?)
}

enum class TetherNetwork : Network {
    Mainnet,
    Testnet
}

enum class TetherChainType : ChainType {
    DEFAULT,
    ERC20,
    BEP20,
    TRC20
}

@ExperimentalUnsignedTypes
fun String.isValidTetherAddress(
    network: Network,
    chainType: TetherChainType? = TetherChainType.DEFAULT
): Boolean {
    return when (chainType) {
        TetherChainType.ERC20 -> {
            isValidEthereumAddress(network)
        }
        TetherChainType.BEP20, TetherChainType.TRC20 -> {
            isValidBitcoinAddress(network)
        }
        else -> checkBothValidators(network)
    }

}

private fun String.checkBothValidators(
    network: Network
): Boolean {
    return isValidEthereumAddress(network) || isValidBitcoinAddress(network) || isValidBitcoinAddress(network)
}

@ExperimentalUnsignedTypes
fun UByteArray.getTetherAddressType(): TetherNetwork? {
    if (this[0] == 0.toUByte() ||
        this[0] == 5.toUByte()
    ) {
        return TetherNetwork.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte()
    ) {
        return TetherNetwork.Testnet
    }

    return null
}
