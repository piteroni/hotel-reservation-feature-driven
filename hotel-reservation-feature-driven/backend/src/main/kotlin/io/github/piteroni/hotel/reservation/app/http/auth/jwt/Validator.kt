package io.github.piteroni.hotel.reservation.app.http.auth.jwt

import io.github.piteroni.hotel.reservation.app.http.auth.UserIdPrincipal
import io.ktor.auth.jwt.JWTCredential

class Validator(private val config: JWTConfig) {
    fun validate(credential: JWTCredential): UserIdPrincipal? {
        return if (credential.payload.audience.contains(config.audience)) {
            UserIdPrincipal(credential.payload.getClaim("userId").asInt())
        } else {
            null
        }
    }
}
