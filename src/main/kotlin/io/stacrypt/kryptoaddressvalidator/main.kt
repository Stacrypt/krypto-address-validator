package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.*

fun main() {
    // Check invalid bitcoin address
    println(CryptocurrencyAddressValidator("bitcoin").validateAddress("abc1223"))
    // Check valid bitcoin address
    println(CryptocurrencyAddressValidator(Cryptocurrency.BTC).validateAddress("3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX"))
    // Check bitcoin address on testnet network
    println(
        CryptocurrencyAddressValidator("bitcoin").validateAddress(
            "tb1qqqqqp399et2xygdj5xreqhjjvcmzhxw4aywxecjdzew6hylgvsesrxh6hy",
            network = Network.Testnet
        )
    )
    // Check tether on BEP20 chain
    println(
        CryptocurrencyAddressValidator(Cryptocurrency.USDT).validateAddress(
            "0x0a621fe2375b6c8ebe176a0c97151468fb048fa2",
            network = Network.Mainnet,
            chainType = ChainType.BSC
        )
    )
    // Check tether on ERC20 chain
    println(
        CryptocurrencyAddressValidator(Cryptocurrency.USDT).validateAddress(
            "0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a",
            network = Network.Mainnet,
            chainType = ChainType.ETH
        )
    )

    // Unsupported currency test
    println(
        CryptocurrencyAddressValidator("ABCD").validateAddress(
            "0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a"
        )
    )
}