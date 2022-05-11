package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum

class TetherValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.ETH -> address.isValidEthereumAddress()
            ChainType.BSC -> address.isValidEthereumAddress()
            ChainType.TRX -> address.isValidTronAddress(network)
            ChainType.DEFAULT -> address.checkBothValidators(network)
            else -> throw ChainNotSupportException()
        }
}

private fun String.isvalidBep20(network: Network?): Boolean {
    if (this.isEmpty()) return false
    try {
        val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
        val byteArray = decodeBase58WithChecksum.toUByteArray()

        if (byteArray.size == 21) {
            if (byteArray.getTetherAddressType() == network) return true
        }
        return false
    } catch (e: Exception) {
        return false
    }
}

private fun String.checkBothValidators(
    network: Network?
): Boolean {
    return isValidEthereumAddress() || isvalidBep20(network)
}

@ExperimentalUnsignedTypes
fun UByteArray.getTetherAddressType(): Network? {
    if (this[0] == 0.toUByte() ||
        this[0] == 5.toUByte()
    ) {
        return Network.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte()
    ) {
        return Network.Testnet
    }

    return null
}
