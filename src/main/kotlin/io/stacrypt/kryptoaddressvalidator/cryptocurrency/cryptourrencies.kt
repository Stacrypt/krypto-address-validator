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
    Cardano,
    ADA,

    // Polkadot
    Polkadot,
    DOT,

    // Ripple
    Ripple,
    XRP,

    // Tron
    Tron,
    TRX,

    // Doge
    DogeCoin,
    DOGE,

    // Tether
    Tether,
    USDT,

    // Tether
    Ethereum,
    ETH
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
        CryptoCurrency.Tron, CryptoCurrency.TRX -> isValidBitcoinAddress(
                network,
                cryptoCurrency
        )
        CryptoCurrency.DogeCoin, CryptoCurrency.DOGE -> isValidBitcoinAddress(
                network,
                cryptoCurrency
        )
        CryptoCurrency.Tether, CryptoCurrency.USDT -> isValidTetherAddress(
                network,
                cryptoCurrency
        )
        CryptoCurrency.Ethereum, CryptoCurrency.ETH -> isValidEthereumAddress()

        else -> false
    }
}

