package io.stacrypt.kryptoaddressvalidator.cryptocurrency

enum class DogeCoinNetwork : Network {
    Mainnet,
    Testnet
}

@ExperimentalUnsignedTypes
fun UByteArray.getDogeCoinAddressType(): DogeCoinNetwork? {
    if (this[0] == 30.toUByte() || this[0] == 22.toUByte()) return DogeCoinNetwork.Mainnet
    if (this[0] == 113.toUByte() || this[0] == 196.toUByte()) return DogeCoinNetwork.Testnet
    return null
}
