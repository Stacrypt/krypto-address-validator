package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.blake2b512Hash
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58
import io.stacrypt.kryptoaddressvalidator.cryptography.encodeToBase58String
import org.komputing.khex.extensions.hexToByteArray
import org.komputing.khex.extensions.toHexString

class PolkadotValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = when (chainType) {
        ChainType.DOT ->  address.isValidPolkadotAddress(network ?: Network.Mainnet)
        ChainType.BSC -> address.isValidEthereumAddress()
        ChainType.DEFAULT -> address.checkAllChains(network ?: Network.Mainnet)
        else -> throw ChainNotSupportException()
    }

    private fun String.checkAllChains(network: Network) =
        isValidPolkadotAddress(network) || isValidEthereumAddress()
}

fun String.isValidPolkadotAddress(network: Network): Boolean {
    if (this.isEmpty()) return false
    val prefix = when {
        // Polkadot addresses
        this.first() == '1' -> 0.toByte()
        // Kusama addresses
        this.first().isUpperCase() -> 2.toByte()
        // Generic Substrate addresses
        this.first() == '5' -> 42.toByte()
        else -> 0.toByte()
    }
    return try {
        validatePolkadotAddress(prefix)
        true
    } catch (e: Exception) {
        false
    }
}

private fun String.validatePolkadotAddress(prefixByte: Byte = 0x00.toByte()): ByteArray {
    return this
        .decodeBase58()
        .apply {
            if (this@apply.size != 35) throw Exception("Bad address size.")
        }.apply { if (this@apply.first() != prefixByte) throw Exception("Bad address prefix") }
        .apply {
            val currentChecksum = this@apply.takeLast(2).toByteArray()
            val expectedChecksum = this@apply.dropLast(2).toByteArray().getBlake2Checksum(2)
            if (!currentChecksum.contentEquals(expectedChecksum))
                throw Exception(
                    "Bad address checksum for ${this@validatePolkadotAddress}. " +
                            "${currentChecksum.toHexString()} != ${expectedChecksum.toHexString()}"
                )
        }.drop(1).dropLast(2).toByteArray()
}

private fun ByteArray.encodeToBase58WithBlake2Checksum(length: Int): String =
    byteArrayOf(*this, *getBlake2Checksum(length)).encodeToBase58String()

private fun ByteArray.getBlake2Checksum(length: Int): ByteArray {
    val checksumPrefix = "0x53533538505245".hexToByteArray() // SS58PRE
    return byteArrayOf(*checksumPrefix, *this).blake2b512Hash().take(length).toByteArray()
}