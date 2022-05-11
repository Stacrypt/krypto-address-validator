package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.keccak256Hash
import org.komputing.khex.extensions.toNoPrefixHexString

class EthereumValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean {
        return when (chainType) {
            ChainType.BSC, ChainType.ETH, ChainType.FTM, ChainType.MATIC, ChainType.DEFAULT -> address.isValidEthereumAddress()
            else -> throw ChainNotSupportException()
        }
    }
}

fun String.isValidEthereumAddress(): Boolean {
    // Check if it has the basic requirements of an address
    if (!this.matches("^0x[0-9a-fA-F]{40}$".toRegex())) return false

    // If it's all small caps or all all caps, return true
    if (this.matches("^0x[0-9a-f]{40}$".toRegex()) || this.matches("^0x[0-9A-F]{40}$".toRegex()))
        return true

    // Otherwise check each case
    return verifyChecksum()
}

private fun String.verifyChecksum(): Boolean {
    // Check each case
    val addressWithoutPrefix = this.removePrefix("0x")

    val hashedAddress =
        addressWithoutPrefix.toLowerCase().toByteArray().keccak256Hash().toNoPrefixHexString()

    for (i in 0 until 40) {
        // The nth letter should be uppercase if the nth digit of casemap is 1
        if (
            (Integer.parseInt(
                hashedAddress[i].toString(),
                16
            ) > 7 && addressWithoutPrefix[i].toString()
                .toUpperCase() != addressWithoutPrefix[i].toString()) ||
            (Integer.parseInt(
                hashedAddress[i].toString(),
                16
            ) <= 7 && addressWithoutPrefix[i].toString()
                .toLowerCase() != addressWithoutPrefix[i].toString())
        ) return false
    }
    return true
}

