package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator

class StellarValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.XLM, ChainType.DEFAULT -> address.isValidStellarAddress()
            else -> throw ChainNotSupportException()
        }
}

fun String.isValidStellarAddress(): Boolean =
    "G([A-Z]|[2-7]){55}".toRegex().matches(this)