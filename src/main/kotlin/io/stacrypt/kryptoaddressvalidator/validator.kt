package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.*
import java.lang.Exception

final class CryptocurrencyAddressHelper {

    val cryprtocurrency: Cryptocurrency

    constructor(cryptocurrency: String) {
        this.cryprtocurrency = cryprtocurrency.runCatching {
            Cryptocurrency.valueOf(cryptocurrency.uppercase())
        }.getOrElse {
            Cryptocurrency.values().toList().findLast { it.nickname == cryptocurrency.lowercase() }
        }
    }

    constructor(cryptocurrency: Cryptocurrency) {
        this.cryprtocurrency = cryptocurrency
    }

    fun validateAddress(address: String, network: String = this.cryprtocurrency.defaultNetwork.toString()) =
        this.cryprtocurrency.addressValidator.validateAddress(address, network)

}

abstract class CryptocurrencyValidator() {
    abstract fun validateAddress(address: String, network: String): Boolean
}

class BitcoinCryptocurrencyValidator() {
    override fun validateAddress(address: String, network: String): Boolean {

    }
}


internal interface IAddressValidator {
    abstract fun validateAddress(address: String): Boolean
}