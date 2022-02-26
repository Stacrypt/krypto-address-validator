package io.stacrypt.kryptoaddressvalidator.cryptocurrency

import io.stacrypt.kryptoaddressvalidator.ChainType
import io.stacrypt.kryptoaddressvalidator.CryptocurrencyValidator
import io.stacrypt.kryptoaddressvalidator.Network
import io.stacrypt.kryptoaddressvalidator.cryptography.Bech32.decodeBech32
import io.stacrypt.kryptoaddressvalidator.cryptography.decodeBase58WithChecksum
import java.io.ByteArrayOutputStream
import kotlin.experimental.and

class BitcoinValidator : CryptocurrencyValidator {

    override fun validateAddress(
        address: String,
        network: Network?,
        chainType: ChainType?
    ): Boolean =
        address.isValidBitcoinAddress(network ?: BitcoinNetwork.Mainnet)
}

@ExperimentalUnsignedTypes
fun String.isValidBitcoinAddress(network: Network): Boolean {
    if (this.isEmpty()) return false
    try {
        val decodeBase58WithChecksum = this.decodeBase58WithChecksum()
        val byteArray = decodeBase58WithChecksum.toUByteArray()

        if (byteArray.size == 21) {
            when (network) {
                BitcoinNetwork.Mainnet, BitcoinNetwork.Testnet -> {
                    if (byteArray.getBitcoinAddressType() == network) return true
                }
                LitecoinNetwork.Mainnet, LitecoinNetwork.Testnet -> {
                    if (byteArray.getLitecoinAddressType() == network) return true
                }
                BitcoinCashNetwork.Mainnet, BitcoinCashNetwork.Testnet -> {
                    if (byteArray.getBitcoinCashAddressType() == network) return true
                }
                TronNetwork.Mainnet, TronNetwork.Testnet -> {
                    if (byteArray.getTronAddressType() == network) return true
                }
                DogeCoinNetwork.Mainnet, DogeCoinNetwork.Testnet -> {
                    if (byteArray.getDogeCoinAddressType() == network) return true
                }
                TetherNetwork.Mainnet, TetherNetwork.Testnet -> {
                    if (byteArray.getTetherAddressType() == network) return true
                }
            }
        }
        return false
    } catch (e: Exception) {
        return isValidSegwitAddress(this, network)
    }
}

fun isValidSegwitAddress(address: String, network: Network?): Boolean {
    try {
        val decodedAddress = address.decodeBech32()
        val data = decodedAddress.data

        if (data.isEmpty() || data[0] > 16.toByte()) return false

        val dataWithNoVersion = ByteArray(data.size - 1)
        System.arraycopy(data, 1, dataWithNoVersion, 0, dataWithNoVersion.size)
        val res = convertBits(dataWithNoVersion, 5, 8, false)

        if (res != null) {
            if (res.size < 2 || res.size > 40) return false
            if (data[0] == 0.toByte() && res.size != 20 && res.size != 32) return false
        }

        if (data[0] == 0.toByte()) {
            when (network) {
                BitcoinNetwork.Mainnet ->
                    if (decodedAddress.humanReadablePart.startsWith("bc")) return true
                BitcoinNetwork.Testnet ->
                    if (decodedAddress.humanReadablePart.startsWith("tb")) return true
                LitecoinNetwork.Mainnet ->
                    if (decodedAddress.humanReadablePart.startsWith("ltc")) return true
                LitecoinNetwork.Testnet ->
                    if (decodedAddress.humanReadablePart.startsWith("tltc")) return true
            }
        }
        return false
    } catch (e: Exception) {
        return false
    }
}

@ExperimentalUnsignedTypes
fun UByteArray.getBitcoinAddressType(): BitcoinNetwork? {
    if (this[0] == 0.toUByte() ||
        this[0] == 5.toUByte()
    ) {
        return BitcoinNetwork.Mainnet
    }
    if (this[0] == 111.toUByte() ||
        this[0] == 196.toUByte() ||
        this[0] == 60.toUByte() ||
        this[0] == 38.toUByte()
    ) {
        return BitcoinNetwork.Testnet
    }

    return null
}

/**
 * Inspired by https://www.codota.com/web/assistant/code/rs/5c7ca2c4ac38dc0001e3c259#L35
 */
@Throws(Exception::class)
fun convertBits(data: ByteArray, frombits: Int, tobits: Int, pad: Boolean): ByteArray? {
    var acc = 0
    var bits = 0
    val baos = ByteArrayOutputStream()
    val maxv = (1 shl tobits) - 1
    for (i in data.indices) {
        val value: Int = data[i].and(0xff.toByte()).toInt()
        if (value ushr frombits != 0) {
            throw Exception("invalid data range: data[$i]=$value (frombits=$frombits)")
        }
        acc = acc shl frombits or value
        bits += frombits
        while (bits >= tobits) {
            bits -= tobits
            baos.write(acc ushr bits and maxv)
        }
    }
    if (pad) {
        if (bits > 0) {
            baos.write(acc shl tobits - bits and maxv)
        }
    } else if (bits >= frombits) {
        throw Exception("illegal zero padding")
    } else if (acc shl tobits - bits and maxv != 0) {
        throw Exception("non-zero padding")
    }
    return baos.toByteArray()
}

enum class BitcoinNetwork : Network {
    Mainnet,
    Testnet
}

