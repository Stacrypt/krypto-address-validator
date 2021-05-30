package io.stacrypt.kryptoaddressvalidator.cryptocurrency

enum class LitecoinNetwork : Network {
    Mainnet,
    Testnet
}

@ExperimentalUnsignedTypes
fun UByteArray.getLitecoinAddressType(): LitecoinNetwork? {
    if (this[0] == 48.toUByte() ||
        this[0] == 5.toUByte() ||
        this[0] == 50.toUByte()
    ) {
        return LitecoinNetwork.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte() ||
        this[0] == 58.toUByte()
    ) {
        return LitecoinNetwork.Testnet
    }

    return null
}