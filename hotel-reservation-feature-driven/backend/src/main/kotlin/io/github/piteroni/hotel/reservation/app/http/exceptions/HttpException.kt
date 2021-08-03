package io.github.piteroni.hotel.reservation.app.http.exceptions

import io.github.piteroni.hotel.reservation.app.http.responses.HttpResponse
import io.github.piteroni.hotel.reservation.app.http.responses.SimpleResponse
import io.ktor.http.HttpStatusCode

open class HttpException : Exception {
    var statusCode: HttpStatusCode = HttpStatusCode.InternalServerError
        protected set

    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)

    fun asResponse(): HttpResponse = SimpleResponse(message ?: "")
}
