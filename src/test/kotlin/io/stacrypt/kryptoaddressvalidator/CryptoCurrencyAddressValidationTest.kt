package io.stacrypt.kryptoaddressvalidator

import io.stacrypt.kryptoaddressvalidator.cryptocurrency.*
import org.junit.Assert
import org.junit.Test

class CryptoCurrencyAddressValidationTest {
    @ExperimentalUnsignedTypes
    @Test
    fun testBitcoinAddressValidator() {
        // Main network
        Assert.assertTrue(
                "12KYrjTdVGjFMtaxERSk3gphreJ5US8aUP".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "12QeMLzSrB8XH8FvEzPMVoRxVAzTr5XM2y".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BTC,
                        BitcoinNetwork.Mainnet
                )
        )

        Assert.assertTrue(
                "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BTC,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "mipcBbFg9gMiCh81Kj8tqqdgoZub1ZJRfn".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "3EktnHQD7RiAE6uzMj2ZifT9Yg".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BTC,
                        BitcoinNetwork.Mainnet
                )
        )

        Assert.assertFalse(
                "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )


        // Test network
        Assert.assertFalse(
                "2MzQwSSnBHWHq47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BTC,
                        BitcoinNetwork.Testnet
                )
        )
        Assert.assertTrue(
                "mipcBbFg9gMiCh81Kj8tqqdgoZub1ZJRfn".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Testnet
                )
        )
        Assert.assertTrue(
                "2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BTC,
                        BitcoinNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Testnet
                )
        )

        // Segwit addresses
        // Main network
        Assert.assertTrue(
                "bc1qw508d6qejxtdg4y5r3zarvary0c5xw7kv8f3t4".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "BC1QW508D6QEJXTDG4Y5R3ZARVARY0C5XW7KV8F3T4".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bc1q2t63ewm3mvh0ztmnmezxm7s0tefknenxlrlwrk".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bc1qc7slrfxkknqcq2jevvvkdgvrt8080852dfjewde450xdlk4ugp7szw5tk9".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1pw508d6qejxtdg4y5r3zarvary0c5xw7kw508d6qejxtdg4y5r3zarvary0c5xw7k7grplx".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1pw508d6qejxtdg4y5r3zarvary0c5xw7kw508d6qejxtdg4y5r3zarvary0c5xw7k7grplx".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "BC1SW50QA3JX3S".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1zw508d6qejxtdg4y5r3zarvaryvg6kdaj".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1qw508d6qejxtdg4y5r3zarvary0c5xw7kv8f3t5".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "BC13W508D6QEJXTDG4Y5R3ZARVARY0C5XW7KN40WF2".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1rw5uspcuh".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc10w508d6qejxtdg4y5r3zarvary0c5xw7kw508d6qejxtdg4y5r3zarvary0c5xw7kw5rljs90".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "BC1QR508D6QEJXTDG4Y5R3ZARVARYV98GJ9P".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1zw508d6qejxtdg4y5r3zarvaryvqyzf3du".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "tb1qrp33g0q5c5txsp9arysrx4k6zdkfs4nce4xj0gdcccefvpysxf3q0sL5k7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1zw508d6qejxtdg4y5r3zarvaryvqyzf3du".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "tb1qrp33g0q5c5txsp9arysrx4k6zdkfs4nce4xj0gdcccefvpysxf3pjxtptv".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1gmk9yu".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "bc1zw508d6qejxtdg4y5r3zarvaryvqyzf3du".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Mainnet
                )
        )
        // Test network
        Assert.assertTrue(
                "tb1qrp33g0q5c5txsp9arysrx4k6zdkfs4nce4xj0gdcccefvpysxf3q0sl5k7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Testnet
                )
        )
        Assert.assertTrue(
                "tb1qqqqqp399et2xygdj5xreqhjjvcmzhxw4aywxecjdzew6hylgvsesrxh6hy".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Bitcoin,
                        BitcoinNetwork.Testnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testLitecoinAddressValidator() {
        // Main network
        Assert.assertTrue(
                "LW2E9WRvyY3GHbPGqDMnBkrfCUkxBRU642".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "3CKuQw6LJJsfdoSkZ2JrMZLQgyBeuHhSRD".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Mainnet
                )
        )

        Assert.assertFalse(
                "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                        CryptoCurrency.LTC,
                        LitecoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "mipcBbFg9gMiCh81Kj8tqqdgoZub1ZJRfn".isValidCryptoCurrencyAddress(
                        CryptoCurrency.LTC,
                        LitecoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "3EktnHQD7RiAE6uzMj2ZifT9Yg".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Mainnet
                )
        )

        // Test network
        Assert.assertFalse(
                "2MzQwSSnBHWHq47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Litecoin,
                        LitecoinNetwork.Testnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testBitcoincashAddressValidator() {
        // Main network
        Assert.assertTrue(
                "12KYrjTdVGjFMtaxERSk3gphreJ5US8aUP".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "12QeMLzSrB8XH8FvEzPMVoRxVAzTr5XM2y".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "12QeMLzSrB8XH8FvEzPMVoRxVAzTr5XM2y".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "12QeMLzSrB8XH8FvEzPMVoRxVAzTr5XM2y".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BCH,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "1oNLrsHnBcR6dpaBpwz3LSwutbUNkNSjs".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BCH,
                        BitcoinCashNetwork.Mainnet
                )
        )

        Assert.assertTrue(
                "3NJZLcZEEYBpxYEUGewU4knsQRn1WM5Fkt".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "3NJZLcZEEYBpxYEUGewU4knsQRn1WM5Fkt".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BCH,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bitcoincash:qq4v32mtagxac29my6gwj6fd4tmqg8rysu23dax807".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BCH,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bitcoincash:qrd9khmeg4nqag3h5gzu8vjt537pm7le85lcauzezc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "qrd9khmeg4nqag3h5gzu8vjt537pm7le85lcauzezc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "1LuZmXJfzf73ooUcC7BHKB92gjLEGv7eCh".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "mipcBbFg9gMiCh81Kj8tqqdgoZub1ZJRfn".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "3EktnHQD7RiAE6uzMj2ZifT9Yg".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Mainnet
                )
        )

        // Test network
        Assert.assertTrue(
                "bchtest:qpq7dml7qr6kjpu5gau0t9sx6a3xvdmt8quv5jr3h0".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )

        Assert.assertTrue(
                "qpq7dml7qr6kjpu5gau0t9sx6a3xvdmt8quv5jr3h0".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )

        Assert.assertTrue(
                "mmXQsLex5dVjhTPZaHmhPc2EhyPXSNydS9".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "17VZNX1SN5NtKa8UQFxwQbFeFc3iqRYhem".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "3EktnHQD7RiAE6uzMj2ZifT9YgRrkSgzQX".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "2MzQwSSnBHWHq47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
        Assert.assertFalse(
                "4MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
        Assert.assertTrue(
                "mzBc4XEFSdzCDcTxAgf6EZXgsZWpztRhef".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
        Assert.assertTrue(
                "2MxKEf2su6FGAUfCEAHreGFQvEYrfYNHvL7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BitcoinCash,
                        BitcoinCashNetwork.Testnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testPolkadotAddressValidator() {
        Assert.assertTrue(
                "1iQPKJmghHbrRhUiMt2cNEuxYbR6S9vYtJKqYvE4PNR9WDB".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DOT,
                        PolkadotNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "1FRMM8PEiWXYax7rpS6X4XZX1aAAxSWx1CrKTyrVYhV24fg".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DOT,
                        PolkadotNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "5CK8D1sKNwF473wbuBP6NuhQfPaWUetNsWUNAAzVwTfxqjfr".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DOT,
                        PolkadotNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "CpjsLDC1JFyrhm3ftC9Gs4QoyrkHKhZKtK7YqGTRFtTafgp".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Polkadot,
                        PolkadotNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "15FKUKXC6kwaXxJ1tXNywmFy4ZY6FoDFCnU3fMbibFdeqwGw".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Polkadot,
                        PolkadotNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "CxDDSH8gS7jecsxaRL9Txf8H5kqesLXAEAEgp76Yz632J9M".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DOT,
                        PolkadotNetwork.Mainnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testRippleAddressValidator() {
        // Mainnet
        Assert.assertTrue(
                "rrrrrrrrrrrrrrrrrrrrrhoLvTp".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "rrrrrrrrrrrrrrrrrrrrBZbvji".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "rHb9CJAWyB4rj91VRWn96DkukG4bwdtyTh".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "rrrrrrrrrrrrrrrrrNAMEtxvNvQ".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "rG1QQv2nh2gr7RCZ1P8YYcBUKCCN633jCN".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "rDTXLQ7ZKZVKz33zJbHjgVShjsBnqMBhMN".isValidCryptoCurrencyAddress(
                        CryptoCurrency.XRP,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "6xAff4d6793F584a473348EbA058deb8ca".isValidCryptoCurrencyAddress(
                        CryptoCurrency.XRP,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "DJ53hTyLBdZp2wMi5BsCS3rtEL1ioYUkva".isValidCryptoCurrencyAddress(
                        CryptoCurrency.XRP,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "DJ53hTyLBdZp2wMi5BsCS3rtEL1ioYUkva".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "arrrrrrrrrrrrrrrrrrrrhoLvTp".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ripple,
                        RippleNetwork.Mainnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testTronAddressValidator() {
        // Mainnet
        Assert.assertTrue(
                "TRdoTa6RRfW2yTaqietaAsLGRf36h99KL5".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tron,
                        TronNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "TDwcZFyHNDkWa6hMzVeBnzTiPZZVCBaHyb".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tron,
                        TronNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "TUGwuNwgqqUq2FPuW5211dMVuTgJxJy15g".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tron,
                        TronNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "TRJbFUwpaBcnK8YrFRRfvpTWgswihwFmrT".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tron,
                        TronNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "TNDzfERDpxLDS2w1q6yaFC7pzqaSQ3Bg3r".isValidCryptoCurrencyAddress(
                        CryptoCurrency.TRX,
                        TronNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "xrb_1111111112111111111111111111111111111111111111111111hifc8npp".isValidCryptoCurrencyAddress(
                        CryptoCurrency.TRX,
                        TronNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "TNDzfERDpxLDS2w1q6yaFC7pzqaSQ3Bg31".isValidCryptoCurrencyAddress(
                        CryptoCurrency.TRX,
                        TronNetwork.Mainnet
                )
        )

        // Testnet
        Assert.assertTrue(
                "27bLJCYjbH6MT8DBF9xcrK6yZnm43vx7MNQ".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tron,
                        TronNetwork.Testnet
                )
        )
        Assert.assertTrue(
                "27bLJCYjbH6MT8DBF9xcrK6yZnm43vx7MNQ".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tron,
                        TronNetwork.Testnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testDogeCoinAddressValidator() {
        // Mainnet
        Assert.assertTrue(
                "DPpJVPpvPNP6i6tMj4rTycAGh8wReTqaSU".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DogeCoin,
                        DogeCoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "DNzLUN6MyYVS5zf4Xc2yK69V3dXs6Mxia5".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DogeCoin,
                        DogeCoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "DPS6iZj7roHquvwRYXNBua9QtKPzigUUhM".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DogeCoin,
                        DogeCoinNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "A7JjzK9k9x5b2MkkQzqt91WZsuu7wTu6iS".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DOGE,
                        DogeCoinNetwork.Mainnet
                )
        )

        // Testnet
        Assert.assertTrue(
                "2MxKEf2su6FGAUfCEAHreGFQvEYrfYNHvL7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.DOGE,
                        DogeCoinNetwork.Testnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testEthereumAddressValidator() {
        Assert.assertTrue(
                "0xe42108cb8dfab7e80e396ceb66469f7c85a53009".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xdcb5410ef70f59a5a2839fc6d4d0b2ca981f5e2d".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )

        Assert.assertFalse(
                "0xdcb5410ef70f59a5a2839fc6d4d0b2ca981f5e2h".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )

        Assert.assertTrue(
                "0xE37c0D48d68da5c5b14E5c1a9f1CFE802776D9FF".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xa00354276d2fC74ee91e37D085d35748613f4748".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xAff4d6793F584a473348EbA058deb8caad77a288".isValidCryptoCurrencyAddress(
                        CryptoCurrency.ETH,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xc6d9d2cd449a754c494264e1809c50e34d64562b".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0x52908400098527886E0F7030069857D2E4169EE7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0x8617E340B3D01FA5F11F306F4090FD50E238070D".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xde709f2102306220921060314715629080e2fb77".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0x27b1fdb04752bbc536007a920d24acb045561c26".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0x5aAeb6053F3E94C9b9A09f33669435E7Ef1BeAed".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xfB6916095ca1df60bB79Ce92cE3Ea74c37c5d359".isValidCryptoCurrencyAddress(
                        CryptoCurrency.ETH,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xdbF03B407c01E7cD3CBea99509d93f8DDDC8C6FB".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Ethereum,
                        EthereumNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xD1220A0cf47c7B9Be7A2E6BA89F429762e7b9aDb".isValidCryptoCurrencyAddress(
                        CryptoCurrency.ETH,
                        EthereumNetwork.Mainnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testTetherAddressValidator() {
        Assert.assertTrue(
                "3MbYQMMmSkC3AgWkj9FMo5LsPTW1zBTwXL".isValidCryptoCurrencyAddress(
                        CryptoCurrency.USDT,
                        TetherNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "1KdXaqcBeoMAFVAPwTmYvDbEq6RnvNPF6J".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xF6f6ebAf5D78F4c93Baf856d3005B7395CCC272e".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "3MbYQMMmSkC3AgWkj9FMo5LsPTW1zBTwXL".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet,
                        TetherChainType.OMNI
                )
        )
        Assert.assertTrue(
                "0x9ec7d40d627ec59981446a6e5acb33d51afcaf8a".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet,
                        TetherChainType.ERC20
                )
        )
        Assert.assertFalse(
                "1KdXaqcBeoMAFVAPwTmYvDbEq6RnvNPF6Jp".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "0xF6f6ebAf5D78F4c93Baf856d3005B7395CCC272eT".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Tether,
                        TetherNetwork.Mainnet
                )
        )
        Assert.assertFalse(
                "3MbYQMMmSkC3AgWkj9FMo5LsPTW1zBTwXL".isValidCryptoCurrencyAddress(
                        CryptoCurrency.USDT,
                        TetherNetwork.Mainnet,
                        TetherChainType.ERC20
                )
        )
    }


    @ExperimentalUnsignedTypes
    @Test
    fun testBinanceSmartChainAddressValidator() {
        Assert.assertTrue(
                "0x2465176C461AfB316ebc773C61fAEe85A6515DAA".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceSmartChain,
                        BinanceSmartChainNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xC6254B18311Bc0cBe7cf5dEeEd725bC5Aeb7DE59".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceSmartChain,
                        BinanceSmartChainNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xB158F47fDfC6798D594DebD9a7A160D4CdB2bEaC".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceSmartChain,
                        BinanceSmartChainNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "0xc3A9b5190D0133e9Cc4bfbB2fb9FB142a7b67136".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceSmartChain,
                        BinanceSmartChainNetwork.Mainnet
                )
        )
    }

    @ExperimentalUnsignedTypes
    @Test
    fun testCardanoAddressValidator() {
        Assert.assertTrue(
                "Ae2tdPwUPEYzs5BRbGcoS3DXvK8mwgggmESz4HqUwMyaS9eNksZGz1LMS9v".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Cardano,
                        CardanoNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "Ae2tdPwUPEYxYNJw1He1esdZYvjmr4NtPzUsGTiqL9zd8ohjZYQcwu6kom7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Cardano,
                        CardanoNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "DdzFFzCqrhsfdzUZxvuBkhV8Lpm9p43p9ubh79GCTkxJikAjKh51qhtCFMqUniC5tv5ZExyvSmAte2Du2tGimavSo6qSgXbjiy8qZRTg".isValidCryptoCurrencyAddress(
                        CryptoCurrency.ADA,
                        CardanoNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "Ae2tdPwUPEZKmwoy3AU3cXb5Chnasj6mvVNxV1H11997q3VW5ihbSfQwGpm".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Cardano,
                        CardanoNetwork.Mainnet
                )
        )

        // TODO: Should handle this type of address
//        Assert.assertTrue(
//            "4swhHtxKapQbj3TZEipgtp7NQzcRWDYqCxXYoPQWjGyHmhxS1w1TjUEszCQT1sQucGwmPQMYdv1FYs3d51KgoubviPBf".isValidCryptoCurrencyAddress(
//                CryptoCurrency.Cardano,
//                CardanoNetwork.Mainnet
//            )
//        )
        Assert.assertTrue(
                "addr1qxy3w62dupy9pzmpdfzxz4k240w5vawyagl5m9djqquyymrtm3grn7gpnjh7rwh2dy62hk8639lt6kzn32yxq960usnq9pexvt".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Cardano,
                        CardanoNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "addr1skemppwfevyk0lshu2w8j34707s3t3t58a04xcx5ccevrcmvpmxg2qt4pk0".isValidCryptoCurrencyAddress(
                        CryptoCurrency.Cardano,
                        CardanoNetwork.Testnet
                )
        )
    }


    // FIXME: Commented address are valid and validation method should be fix
    @ExperimentalUnsignedTypes
    @Test
    fun testBinanceAddressValidator() {
        Assert.assertTrue(
                "bnb1w8fnhr5kdkeu7gd69r7mknfmxgzhjg3gnzc96p".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceChain,
                        BinanceChainNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bnb1h8nlgl93t7s956gqsx83g2cfyy7zv46cxjnutc".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceChain,
                        BinanceChainNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bnb1xlwceav3nr0g8lw7f0qtmuln543pea4g7g6ac0".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceChain,
                        BinanceChainNetwork.Mainnet
                )
        )
        Assert.assertTrue(
                "bnb1kwnjf9p5c5x7kpxkr29zucvehqhdq3pcma7eq7".isValidCryptoCurrencyAddress(
                        CryptoCurrency.BinanceChain,
                        BinanceChainNetwork.Mainnet
                )
        )
//        Assert.assertTrue(
//            "bnb1tda6rxg2avfn2lhlg95d5h0w4tqa4r4vcrkxk7".isValidCryptoCurrencyAddress(
//                CryptoCurrency.BinanceChain,
//                BinanceChainNetwork.Mainnet
//            )
//        )
//        Assert.assertTrue(
//                "bnb1sn0xw2kmghduy3xlfsvsm26kuh87fju5x22lpn".isValidCryptoCurrencyAddress(
//                        CryptoCurrency.BinanceChain,
//                        BinanceChainNetwork.Mainnet
//                )
//        )
//        Assert.assertTrue(
//                "bnb1vyh3zd0z57j3f3zyf3fx99c48cgq0ctwmhtjft".isValidCryptoCurrencyAddress(
//                        CryptoCurrency.BNB,
//                        BinanceChainNetwork.Mainnet
//                )
//        )
//        Assert.assertTrue(
//                "bnb1aanuahm2c9z5syvwsk4792vddtp74jkme5d38l".isValidCryptoCurrencyAddress(
//                        CryptoCurrency.BinanceChain,
//                        BinanceChainNetwork.Mainnet
//                )
//        )
//        Assert.assertTrue(
//                "bnb13s4hfgegeakq4c3ne2gsctl56pzxvvuv26jrj6".isValidCryptoCurrencyAddress(
//                        CryptoCurrency.BinanceChain,
//                        BinanceChainNetwork.Mainnet
//                )
//        )


    }
}
