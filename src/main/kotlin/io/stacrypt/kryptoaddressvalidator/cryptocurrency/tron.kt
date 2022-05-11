package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum


class TronValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.TRX, ChainType.DEFAULT -> address.isValidTronAddress(network)
            else -> throw ChainNotSupportException()
        }
}

@OptIn(ExperimentalUnsignedTypes::class)
fun String.isValidTronAddress(network: Network?): Boolean {
    if (this.isEmpty()) return false
    try {
        val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
        val byteArray = decodeBase58WithChecksum.toUByteArray()

        if (byteArray.size == 21) {
            if (byteArray.getTronAddressType() == network) return true
        }
        return false
    } catch (e: Exception) {
        return false
    }
}

@ExperimentalUnsignedTypes
fun UByteArray.getTronAddressType(): Network? {
    if (this[0] == 65.toUByte()) return Network.Mainnet
    if (this[0] == 160.toUByte()) return Network.Testnet
    return null
}
