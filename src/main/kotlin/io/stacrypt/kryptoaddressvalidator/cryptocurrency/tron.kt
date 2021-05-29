package io.stacrypt.kryptoaddressvalidator.cryptocurrency

enum class TronNetwork : Network {
    Mainnet,
    Testnet
}

@ExperimentalUnsignedTypes
fun UByteArray.getTronAddressType(): TronNetwork? {
    if (this[0] == 65.toUByte()) return TronNetwork.Mainnet
    if (this[0] == 160.toUByte()) return TronNetwork.Testnet
    return null
}
