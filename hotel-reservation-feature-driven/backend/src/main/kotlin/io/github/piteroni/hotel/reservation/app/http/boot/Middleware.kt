package io.github.piteroni.hotel.reservation.app.http.boot

import io.github.piteroni.hotel.reservation.app.database.DatabaseConnectionException
import io.github.piteroni.hotel.reservation.app.http.auth.jwt.Validator
import io.github.piteroni.hotel.reservation.app.http.auth.jwt.makeJWTConfig
import io.github.piteroni.hotel.reservation.app.http.auth.jwt.makeJWTVerifier
import io.github.piteroni.hotel.reservation.app.http.exceptions.HttpException
import io.github.piteroni.hotel.reservation.app.http.exceptions.InternalServerErrorException
import io.github.piteroni.hotel.reservation.app.utils.Config
import io.github.piteroni.hotel.reservation.app.utils.UnknownPropertyException
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.jwt.jwt
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.http.HttpMethod
import io.ktor.http.HttpHeaders
import io.ktor.response.respond
import io.ktor.serialization.json

internal fun Application.applyMiddlewares() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        json()
    }

    install(CORS) {
        // for chrome preflight request
        allowNonSimpleContentTypes = true
        allowCredentials = true

        header(HttpHeaders.Authorization)

        methods.addAll(setOf(
            HttpMethod.Get,
            HttpMethod.Head,
            HttpMethod.Options,
            HttpMethod.Post,
            HttpMethod.Put,
            HttpMethod.Delete,
            HttpMethod.Patch,
        ))

        try {
            hosts.addAll(Config.get("ALLOW_HOSTS").split(" "))
        } catch (exception: UnknownPropertyException) {
             throw InternalServerErrorException(exception)
        }
    }

    install(StatusPages) {
        exception<DatabaseConnectionException> { cause ->
            environment.log.error(cause.stackTraceToString())
        }

        exception<HttpException> { cause ->
            call.respond(cause.statusCode, cause.asResponse())

            when (cause.statusCode.value) {
                in 400..499 -> environment.log.warn(cause.stackTraceToString())
                in 500..599 -> environment.log.error(cause.stackTraceToString())
                else -> environment.log.error(cause.stackTraceToString())
            }
        }
    }

    install(Authentication) {
        val jwtConfig = try {
            makeJWTConfig()
        } catch (exception: UnknownPropertyException) {
            throw InternalServerErrorException(exception)
        }

        jwt {
            realm = jwtConfig.realm
            verifier(makeJWTVerifier(jwtConfig))
            validate { credential -> Validator(makeJWTConfig()).validate(credential) }
        }
    }
}
