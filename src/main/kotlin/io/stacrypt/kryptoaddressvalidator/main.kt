package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.BitcoinNetwork
import io.stacrypt.kryptoaddressvalidator.cryptocurrency.TetherChainType
import io.stacrypt.kryptoaddressvalidator.cryptocurrency.TetherNetwork

fun main() {
    // Check invalid bitcoin address
    println(CryptocurrencyAddressValidator("bitcoin").validateAddress("abc1223"))
    // Check valid bitcoin address
    println(CryptocurrencyAddressValidator(Cryptocurrency.BTC).validateAddress("3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX"))
    // Check bitcoin address on testnet network
    println(
        CryptocurrencyAddressValidator("bitcoin").validateAddress(
            "tb1qqqqqp399et2xygdj5xreqhjjvcmzhxw4aywxecjdzew6hylgvsesrxh6hy",
            network = BitcoinNetwork.Testnet
        )
    )
    // Check tether on BEP20 chain
    println(
        CryptocurrencyAddressValidator(Cryptocurrency.USDT).validateAddress(
            "3MbYQMMmSkC3AgWkj9FMo5LsPTW1zBTwXL",
            network = TetherNetwork.Mainnet,
            chainType = TetherChainType.BEP20
        )
    )
    // Check tether on ERC20 chain
    println(
        CryptocurrencyAddressValidator(Cryptocurrency.USDT).validateAddress(
            "0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a",
            network = TetherNetwork.Mainnet,
            chainType = TetherChainType.ERC20
        )
    )

    // Unsupported currency test
    println(
        CryptocurrencyAddressValidator("ABCD").validateAddress(
            "0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a"
        )
    )
}