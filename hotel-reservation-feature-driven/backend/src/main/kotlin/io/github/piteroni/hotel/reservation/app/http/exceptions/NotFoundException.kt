package io.github.piteroni.hotel.reservation.app.http.exceptions

import io.ktor.http.HttpStatusCode

private const val defaultMessage = "specified resource does not exist"

class NotFoundException : HttpException {
    init {
        statusCode = HttpStatusCode.NotFound
    }

    constructor(message: String?) : super(message)
    constructor(cause: Throwable) : super(defaultMessage, cause)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}