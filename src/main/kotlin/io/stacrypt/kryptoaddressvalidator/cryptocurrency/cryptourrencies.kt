package io.stacrypt.kryptoaddressvalidator.cryptocurrency

enum class CryptoCurrency {
    Bitcoin
}

@ExperimentalUnsignedTypes
fun String.isValidCryptoCurrencyAddress(cryptoCurrency: CryptoCurrency
                                        , network: networks):Boolean {
    when(cryptoCurrency){
        CryptoCurrency.Bitcoin -> return isValidBitcoinAddress(network)
    }
}
