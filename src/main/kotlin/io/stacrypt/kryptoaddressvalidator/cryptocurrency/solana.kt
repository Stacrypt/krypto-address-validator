package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator

class SolanaValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.SOL, ChainType.DEFAULT -> address.isValidSolanaAddress()
            else -> throw ChainNotSupportException()
        }
}

fun String.isValidSolanaAddress(): Boolean =
    "[1-9A-HJ-NP-Za-km-z]{32,44}".toRegex().matches(this)