package io.github.piteroni.hotel.reservation.app.http.auth.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier

fun makeJWTVerifier(config: JWTConfig): JWTVerifier = JWT
    .require(config.algorithm)
    .withAudience(config.audience)
    .withIssuer(config.issuer)
    .build()