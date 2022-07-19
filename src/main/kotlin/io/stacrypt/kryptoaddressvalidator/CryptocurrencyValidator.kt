package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.*

interface CryptocurrencyValidator {
    fun validateAddress(address: String, network: Network? = null, chainType: ChainType? = null): Boolean
}

enum class Cryptocurrency(val nickname: String, val addressValidator: CryptocurrencyValidator) {
    // Bitcoin
    BTC("bitcoin", BitcoinValidator()),

    // Litecoin
    LTC("litecoin", LiteCoinValidator()),

    // BitcoinCash
    BCH("bitcoincash", BitcoinCashValidator()),

    // Cardano
    ADA("cardano", CardanoValidator()),

    // Polkadot
    DOT("polkadot", PolkadotValidator()),

    // Ripple
    XRP("ripple", RippleValidator()),

    // Tron
    TRX("tron", TronValidator()),

    // Doge
    DOGE("dogecoin", DogeCoinValidator()),

    // Tether
    USDT("tether", TetherValidator()),

    // Ethereum
    ETH("ethereum", EthereumValidator()),

    // Binance
    BNB("binancecoin", BinanceValidator()),

    // Chain Link
    LINK("chainlink", EthereumValidator()),

    // Dai
    DAI("dai", EthereumValidator()),

    // Stellar
    XLM("stellar", StellarValidator()),

    // Uniswap
    UNI("uniswap", EthereumValidator()),

    // Solana
    SOL("solana", SolanaValidator()),

    // Shiba
    SHIB("shiba", EthereumValidator()),

    // Axie Infinity
    AXS("axie infinity", EthereumValidator()),

    // Mana
    MANA("decentraland", EthereumValidator()),

    // Sand
    SAND("sandbox", EthereumValidator()),

    // Matic
    MATIC("polygon", EthereumValidator()),

    // Cake
    CAKE("pancakeswap", BinanceValidator()),

    // Fantom
    FTM("fantom", EthereumValidator()),

    // Aave
    AAVE("aave", EthereumValidator()),

    // Filecoin
    FIL("filecoin", BinanceValidator()),

    // Cosmos
    ATOM("cosmos", BinanceValidator())

}