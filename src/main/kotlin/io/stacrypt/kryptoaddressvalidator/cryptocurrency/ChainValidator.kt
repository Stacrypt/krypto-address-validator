package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainNotSupportException
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32
import io.stacrypt.kryptoaddressvalidator.utils.Utils.convertBits

class ChainValidator : CryptocurrencyValidator {
    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        when (chainType) {
            ChainType.BSC -> address.isValidEthereumAddress()
            ChainType.BNB -> address.isValidBinanceChainAddress(network ?: Network.Mainnet)
            ChainType.ADA -> address.isValidAddressV1() || address.isValidAddressShelley()
            ChainType.BCH -> address.isValidBitcoinCash(network) || address.isValidBitcoinAddress(network)
            ChainType.BTC -> address.isValidBitcoinAddress(network ?: Network.Mainnet)
            ChainType.LTC -> address.isValidLiteCoinAddress(network)
            ChainType.ETH ->  address.isValidEthereumAddress()
            ChainType.DOT -> address.isValidPolkadotAddress(network ?: Network.Mainnet)
            ChainType.DOGE -> address.isValidDogeCoinAddress(network)
            ChainType.FTM -> address.isValidEthereumAddress()
            ChainType.MATIC -> address.isValidEthereumAddress()
            ChainType.XRP -> address.isValidRippleAddress(network ?: Network.Mainnet)
            ChainType.TRX -> address.isValidTronAddress(network)
            ChainType.SOL -> address.isValidSolanaAddress()
            ChainType.XLM -> address.isValidStellarAddress()
            ChainType.DEFAULT -> throw ChainNotSupportException()
            else -> throw ChainNotSupportException()
        }
}



