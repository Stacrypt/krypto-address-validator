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
    BCH,

    // Cardano
    ADA,
    Cardano,

    // Polkadot
    Polkadot,
    DOT,

    // Ripple
    Ripple,
    XRP
}

val bech32EncodeValidationCurrencies = listOf(
    CryptoCurrency.Bitcoin,
    CryptoCurrency.BTC,
    CryptoCurrency.Litecoin,
    CryptoCurrency.LTC,
    CryptoCurrency.Cardano,
    CryptoCurrency.ADA
)

@ExperimentalUnsignedTypes
fun String.isValidCryptoCurrencyAddress(
    cryptoCurrency: CryptoCurrency, network: Network
): Boolean {
    return when (cryptoCurrency) {
        CryptoCurrency.Bitcoin, CryptoCurrency.BTC -> isValidBitcoinAddress(network, cryptoCurrency)
        CryptoCurrency.Litecoin, CryptoCurrency.LTC -> isValidBitcoinAddress(
            network,
            cryptoCurrency
        )
        CryptoCurrency.BitcoinCash, CryptoCurrency.BCH -> isValidBitcoinCashAddress(
            network,
            cryptoCurrency
        )
//        CryptoCurrency.Cardano, CryptoCurrency.ADA -> isValidCardanoCashAddress(network,cryptoCurrency)
        CryptoCurrency.Polkadot, CryptoCurrency.DOT -> isValidatePolkadotAddress(
            network,
            cryptoCurrency
        )
        CryptoCurrency.Ripple, CryptoCurrency.XRP -> isValidRippleAddress(
            network,
            cryptoCurrency
        )
        else -> false
    }
}

