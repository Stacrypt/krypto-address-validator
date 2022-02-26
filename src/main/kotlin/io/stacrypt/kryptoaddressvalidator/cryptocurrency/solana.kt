package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network

class SolanaValidator: CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean = address.isValidSolanaAddress()
}

fun String.isValidSolanaAddress(): Boolean =
    "[1-9A-HJ-NP-Za-km-z]{32,44}".toRegex().matches(this)

enum class SolanaNetwork : Network {
    Mainnet
}