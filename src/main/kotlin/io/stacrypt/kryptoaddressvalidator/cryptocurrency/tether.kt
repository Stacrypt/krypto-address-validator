package io.stacrypt.kryptoaddressvalidator.cryptocurrency

enum class TetherNetwork : Network {
    Mainnet,
    Testnet
}

enum class TetherChainType : ChainType {
    DEFAULT,
    ERC20,
    OMNI
}

@ExperimentalUnsignedTypes
fun String.isValidTetherAddress(
    network: Network, cryptoCurrency: CryptoCurrency,
    chainType: TetherChainType = TetherChainType.DEFAULT
): Boolean {
    if (chainType == TetherChainType.ERC20) {
        return isValidEthereumAddress()
    } else if (chainType == TetherChainType.OMNI) {
        return isValidBitcoinAddress(network, cryptoCurrency)
    }

    return checkBothValidators(network, cryptoCurrency)
}

private fun String.checkBothValidators(
    network: Network,
    cryptoCurrency: CryptoCurrency
): Boolean {
    return isValidEthereumAddress() || isValidBitcoinAddress(
        network,
        cryptoCurrency
    )
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
