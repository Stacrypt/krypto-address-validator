package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.CryptoCurrency
import io.stacrypt.kryptoaddressvalidator.cryptocurrency.isValidCryptoCurrencyAddress
import io.stacrypt.kryptoaddressvalidator.cryptocurrency.networks
import org.junit.Assert
import org.junit.Test

class CryptoCurrencyAddressValidationTest {
    @ExperimentalUnsignedTypes
    @Test
    fun testBitcoinAddressValidator() {

        Assert.assertTrue(
            "12KYrjTdVGjFMtaxERSk3gphreJ5US8aUP".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Mainnet
            )
        )
        Assert.assertTrue(
            "12QeMLzSrB8XH8FvEzPMVoRxVAzTr5XM2y".isValidCryptoCurrencyAddress(
                CryptoCurrency.BTC,
                networks.Mainnet
            )
        )

        Assert.assertFalse(
            "bc1zw508d6qejxtdg4y5r3zarvaryvqyzf3du".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Mainnet
            )
        )

        // Main network
        Assert.assertTrue(
            "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                CryptoCurrency.BTC,
                networks.Mainnet
            )
        )
        Assert.assertTrue(
            "3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Mainnet
            )
        )
        Assert.assertFalse(
            "mipcBbFg9gMiCh81Kj8tqqdgoZub1ZJRfn".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Mainnet
            )
        )
        Assert.assertFalse(
            "2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Mainnet
            )
        )
        Assert.assertFalse(
            "3EktnHQD7RiAE6uzMj2ZifT9Yg".isValidCryptoCurrencyAddress(
                CryptoCurrency.BTC,
                networks.Mainnet
            )
        )

        Assert.assertFalse(
            "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Mainnet
            )
        )


        // Test network
        Assert.assertFalse(
            "2MzQwSSnBHWHq47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Testnet
            )
        )
        Assert.assertFalse(
            "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                CryptoCurrency.BTC,
                networks.Testnet
            )
        )
        Assert.assertTrue(
            "mipcBbFg9gMiCh81Kj8tqqdgoZub1ZJRfn".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Testnet
            )
        )
        Assert.assertTrue(
            "2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                CryptoCurrency.BTC,
                networks.Testnet
            )
        )
        Assert.assertFalse(
            "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Testnet
            )
        )
        Assert.assertFalse(
            "3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX".isValidCryptoCurrencyAddress(
                CryptoCurrency.Bitcoin,
                networks.Testnet
            )
        )
    }
}
