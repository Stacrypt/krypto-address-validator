package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum

class DogeCoinValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.DOGE -> address.isValidDogeCoinAddress(network)
            ChainType.BSC -> address.isValidEthereumAddress()
            ChainType.DEFAULT -> address.isValidDogeCoinAddress(network) || address.isValidEthereumAddress()
            else -> throw ChainNotSupportException()
        }



    fun String.isValidDogeCoinAddress(network: Network?): Boolean {
        if (this.isEmpty()) return false
        try {
            val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
            val byteArray = decodeBase58WithChecksum.toUByteArray()

            if (byteArray.size == 21) {
                if (byteArray.getDogeCoinAddressType() == network) return true
            }
            return false
        } catch (e: Exception) {
            return false
        }
    }
}

@ExperimentalUnsignedTypes
fun UByteArray.getDogeCoinAddressType(): Network? {
    if (this[0] == 30.toUByte() || this[0] == 22.toUByte()) return Network.Mainnet
    if (this[0] == 113.toUByte() || this[0] == 196.toUByte()) return Network.Testnet
    return null
}
