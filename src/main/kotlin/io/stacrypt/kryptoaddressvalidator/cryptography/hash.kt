package io.stacrypt.kryptoaddressvalidator.cryptography

import org.bouncycastle.jcajce.provider.digest.Blake2b
import org.bouncycastle.jcajce.provider.digest.Keccak
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

fun ByteArray.blake2b512Hash(): ByteArray = Blake2b.Blake2b512().digest(this)

fun ByteArray.keccak256Hash(): ByteArray = Keccak.Digest256().digest(this)
