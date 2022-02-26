package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class StellarValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = address.isValidStellarAddress()
}

fun String.isValidStellarAddress(): Boolean =
    "G([A-Z]|[2-7]){55}".toRegex().matches(this)

enum class StellarNetwork : Network {
    Mainnet
}