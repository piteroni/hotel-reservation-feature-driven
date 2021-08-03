package io.github.piteroni.hotel.reservation.app.http.auth

import io.ktor.auth.Principal
import kotlinx.serialization.Serializable

@Serializable
data class UserIdPrincipal(val value: Int) : Principal
