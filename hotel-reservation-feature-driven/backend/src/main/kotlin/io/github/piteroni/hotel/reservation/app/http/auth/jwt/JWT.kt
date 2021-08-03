package io.github.piteroni.hotel.reservation.app.http.auth.jwt

import com.auth0.jwt.JWT
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Date

class JWT(private val config: JWTConfig) {
    fun createToken(userId: Int): String = JWT
        .create()
        .withAudience(config.audience)
        .withExpiresAt(Date.from(LocalDateTime.now().plusHours(config.expiration).toInstant(ZoneOffset.UTC)))
        .withClaim("userId", userId)
        .withIssuer(config.issuer)
        .sign(config.algorithm)
}