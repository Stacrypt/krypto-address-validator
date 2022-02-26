package io.stacrypt.kryptoaddressvalidator.utils

import java.io.ByteArrayOutputStream
import kotlin.experimental.and


object Utils {
    /**
     * Concatenates the two given byte arrays and returns the combined byte
     * array.
     *
     * @param first
     * @param second
     * @return
     */
    @ExperimentalUnsignedTypes
    fun concatenateByteArrays(first: UByteArray, second: UByteArray): UByteArray {
        val concatenatedBytes = UByteArray(first.size + second.size)
        System.arraycopy(first, 0, concatenatedBytes, 0, first.size)
        System.arraycopy(second, 0, concatenatedBytes, first.size, second.size)
        return concatenatedBytes
    }

    fun convertBits(data: ByteArray, fromWidth: Int, toWidth: Int, pad: Boolean): List<Int>? {
        var acc = 0
        var bits = 0
        val maxv = (1 shl toWidth) - 1
        val ret: MutableList<Int> = ArrayList()
        for (i in data.indices) {
            val value = (data[i] and 0xff.toByte()).toInt()
            if (value < 0 || value shr fromWidth != 0) {
                return null
            }
            acc = acc shl fromWidth or value
            bits += fromWidth
            while (bits >= toWidth) {
                bits -= toWidth
                ret.add(acc shr bits and maxv)
            }
        }
        if (pad) {
            if (bits > 0) {
                ret.add(acc shl toWidth - bits and maxv)
            } else if (bits >= fromWidth || acc shl toWidth - bits and maxv != 0) {
                return null
            }
        }
        return ret
    }

}
