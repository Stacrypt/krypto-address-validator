package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.*

interface Network {}
interface ChainType {}
interface CryptocurrencyValidator {
    fun validateAddress(address: String, network: Network? = null, chainType: ChainType? = null): Boolean
}

enum class Cryptocurrency(val nickname: String, val addressValidator: CryptocurrencyValidator) {
    // Bitcoin
    BTC("bitcoin", BitcoinValidator()),

    // Litecoin
    LTC("litecoin", BitcoinValidator()),

    // BitcoinCash
    BCH("bitcoincash", BitcoinCashValidator()),

    // Cardano
    ADA("cardano", CardanoValidator()),

    // Polkadot
    DOT("polkadot", PolkadotValidator()),

    // Ripple
    XRP("ripple", RippleValidator()),

    // Tron
    TRX("tron", BitcoinValidator()),

    // Doge
    DOGE("dogecoin", BitcoinValidator()),

    // Tether
    USDT("tether", TetherValidator()),

    // Tether
    ETH("ethereum", EthereumValidator()),

    // Binance
    BNB("binancecoin", BinanceValidator()),

    // Binance smart chain
    BSC("binancesmartchain", EthereumValidator()),

    // Chain Link
    LINK("chainlink", ChainLinkValidator()),

    // Dai
    DAI("dai", DaiValidator()),

    // Stellar
    XLM("stellar", StellarValidator()),

    // Uniswap
    UNI("uniswap", UniValidator()),

    // Solana
    SOL("solana", SolanaValidator()),

    // Shiba
    SHIB("shiba", ShibaValidator()),

    // Axie Infinity
    AXS("axie infinity", UniValidator()),

    // Mana
    MANA("decentraland", ManaValidator()),

    // Sand
    SAND("sandbox", ManaValidator()),

    // Matic
    MATIC("polygon", MaticValidator()),

    // Cake
    CAKE("pancakeswap", BitcoinValidator()),

    // Fantom
    FTM("fantom", FantomValidator()),

    // Aave
    AAVE("aave", UniValidator())

}