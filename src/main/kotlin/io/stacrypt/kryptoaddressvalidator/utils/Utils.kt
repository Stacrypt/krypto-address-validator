package io.stacrypt.kryptoaddressvalidator.utils

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
}
