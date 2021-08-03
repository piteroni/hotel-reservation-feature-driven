package io.github.piteroni.hotel.reservation.app.http.exceptions

import io.ktor.http.HttpStatusCode

private const val defaultMessage = "bad request"

class BadRequestException : HttpException {
    init {
        statusCode = HttpStatusCode.BadRequest
    }

    constructor(message: String?) : super(message)
    constructor(cause: Throwable) : super(defaultMessage, cause)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}