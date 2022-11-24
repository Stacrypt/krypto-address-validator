package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.ChainType
import io.stacrypt.kryptoaddressvalidator.cryptocurrency.Network

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

    constructor() {
        this.cryprtocurrency = Cryptocurrency.ChainValidator
    }

    fun validateAddress(
        address: String,
        network: Network? = null,
        chainType: ChainType = ChainType.DEFAULT
    ): Boolean =
        this.cryprtocurrency.addressValidator.validateAddress(address, network, chainType)

}