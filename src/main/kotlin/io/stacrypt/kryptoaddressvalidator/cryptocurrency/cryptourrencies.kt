package io.stacrypt.kryptoaddressvalidator.cryptocurrency

interface Network {}
enum class CryptoCurrency {
    // Bitcoin
    Bitcoin,
    BTC,

    // Litecoin
    Litecoin,
    LTC,

    // BitcoinCash
    BitcoinCash,
    BCH
}
//
//val bech32EncodeValidationCurrencies = mapOf(
//    "BTC" to "Bitcoin",
//    "LTC" to "Litecoin",
//    "dgb" to "DigiByte",
//    "ada" to "Cardano",
//    "cro" to "Crypto.com Coin"
//)
val bech32EncodeValidationCurrencies = listOf(
    CryptoCurrency.Bitcoin,
    CryptoCurrency.Litecoin
)

@ExperimentalUnsignedTypes
fun String.isValidCryptoCurrencyAddress(
    cryptoCurrency: CryptoCurrency, network: Network
): Boolean {
    return when (cryptoCurrency) {
        CryptoCurrency.Bitcoin, CryptoCurrency.BTC -> isValidBitcoinAddress(network,cryptoCurrency)
        CryptoCurrency.Litecoin, CryptoCurrency.LTC -> isValidBitcoinAddress(network,cryptoCurrency)
        CryptoCurrency.BitcoinCash, CryptoCurrency.BCH -> isValidBitcoinCashAddress(network,cryptoCurrency)
    }
}
