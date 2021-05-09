package io.stacrypt.kryptoaddressvalidator.crypto

import java.security.MessageDigest

fun ByteArray.sha256Digest(): ByteArray = MessageDigest
    .getInstance("SHA-256")
    .also { it.reset() }
    .digest(this)


fun ByteArray.sha256DigestDual() = this.sha256Digest().sha256Digest()

fun ByteArray.sha512Digest(): ByteArray = MessageDigest
    .getInstance("SHA-512")
    .also { it.reset() }
    .digest(this)

