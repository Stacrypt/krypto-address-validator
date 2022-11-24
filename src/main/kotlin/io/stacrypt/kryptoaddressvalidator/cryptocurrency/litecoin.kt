package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum

class LiteCoinValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when(chainType) {
            ChainType.LTC -> address.isValidLiteCoinAddress(network)
            ChainType.BSC -> address.isValidEthereumAddress()
            ChainType.DEFAULT -> address.isValidLiteCoinAddress(network) || address.isValidEthereumAddress()
            else -> throw ChainNotSupportException()
        }

}

fun String.isValidLiteCoinAddress(network: Network?): Boolean {
    if (this.isEmpty()) return false
    try {
        val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
        val byteArray = decodeBase58WithChecksum.toUByteArray()

        if (byteArray.size == 21) {
            if (byteArray.getLitecoinAddressType() == network) return true
        }
        return false
    } catch (e: Exception) {
        return isValidSegwitAddress(this, network)
    }
}

private fun isValidSegwitAddress(address: String, network: Network?): Boolean {
    try {
        val decodedAddress = address.decodeBech32()
        val data = decodedAddress.data

        if (data.isEmpty() || data[0] > 16.toByte()) return false

        val dataWithNoVersion = ByteArray(data.size - 1)
        System.arraycopy(data, 1, dataWithNoVersion, 0, dataWithNoVersion.size)
        val res = convertBits(dataWithNoVersion, 5, 8, false)

        if (res != null) {
            if (res.size < 2 || res.size > 40) return false
            if (data[0] == 0.toByte() && res.size != 20 && res.size != 32) return false
        }

        if (data[0] == 0.toByte()) {
            when (network) {
                Network.Mainnet ->
                    if (decodedAddress.humanReadablePart.startsWith("ltc")) return true
                Network.Testnet ->
                    if (decodedAddress.humanReadablePart.startsWith("tltc")) return true
            }
        }
        return false
    } catch (e: Exception) {
        return false
    }
}

@ExperimentalUnsignedTypes
fun UByteArray.getLitecoinAddressType(): Network? {
    if (this[0] == 48.toUByte() ||
        this[0] == 5.toUByte() ||
        this[0] == 50.toUByte()
    ) {
        return Network.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte() ||
        this[0] == 58.toUByte()
    ) {
        return Network.Testnet
    }

    return null
}