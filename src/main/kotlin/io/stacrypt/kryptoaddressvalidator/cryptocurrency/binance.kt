package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32

enum class BinanceChainNetwork : Network {
    Mainnet,
    Testnet
}

// FIXME: need to be fix on misdiagnosis some addresses,
//  Known problem is on verifyChecksum in decodeBech32
fun String.isValidBinanceChainAddress(network: Network, currency: CryptoCurrency): Boolean {
    try {
        val decodedAddress = decodeBech32()
        val data = decodedAddress.data

        if (data.isEmpty()) return false

        val dataWithNoVersion = ByteArray(data.size - 1)
        System.arraycopy(data, 1, dataWithNoVersion, 0, dataWithNoVersion.size)
        val res = convertBits(dataWithNoVersion, 5, 8, false)

        if (res != null) {
            if (res.size < 2 || res.size > 40) return false
            if (res.size != 19) return false
        }

        when (network) {
            BinanceChainNetwork.Mainnet ->
                if (decodedAddress.humanReadablePart.startsWith("bnb")) return true
            BinanceChainNetwork.Testnet ->
                if (decodedAddress.humanReadablePart.startsWith("tbnb")) return true
        }
        return false
    } catch (e: Exception) {
        return false
    }
}



