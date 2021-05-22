package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum

enum class networks {
    Mainnet,
    Testnet
}

@ExperimentalUnsignedTypes
fun String.isValidBitcoinAddress(network: networks = networks.Mainnet): Boolean {
    if (this.isEmpty()) return false
    try {
        val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
        val byteArray = decodeBase58WithChecksum.toUByteArray()

        if (byteArray.size == 21) {
            if (byteArray.getBitcoinAddressType() != null) {
                if (network == networks.Mainnet && byteArray.getBitcoinAddressType() == networks.Mainnet) {
                    return true
                }
                if (network == networks.Testnet && byteArray.getBitcoinAddressType() == networks.Testnet) {
                    return true
                }
            }
        }
        return false
    } catch (e: Exception) {
        return false
    }
}

/**
 * Check first byte of result to define bitcoin network
 * More info available in https://en.bitcoin.it/wiki/List_of_address_prefixes
 */
@ExperimentalUnsignedTypes
fun UByteArray.getBitcoinAddressType(): networks? {
    if (this[0] == 0.toUByte() ||
        this[0] == 5.toUByte()
    ) {
        return networks.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte()
    ) {
        return networks.Testnet
    }

    return null
}