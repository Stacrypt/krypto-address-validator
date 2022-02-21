package io.stacrypt.kryptoaddressvalidator

import kotlin.Exception

class CryptocurrencyAddressValidator {

    private val cryprtocurrency: Cryptocurrency

    constructor(cryptocurrency: String) {
        this.cryprtocurrency = try {
            Cryptocurrency.valueOf(cryptocurrency.uppercase())
        } catch (e: Exception) {
            Cryptocurrency.values().toList().find { it.nickname == cryptocurrency.lowercase() }
                ?: throw UnsupportedOperationException("Currency doesn't support.")
        }
    }

    constructor(cryptocurrency: Cryptocurrency) {
        this.cryprtocurrency = cryptocurrency
    }

    fun validateAddress(
        address: String,
        network: Network? = null,
        chainType: ChainType? = null
    ): Boolean =
        this.cryprtocurrency.addressValidator.validateAddress(address, network, chainType)

}