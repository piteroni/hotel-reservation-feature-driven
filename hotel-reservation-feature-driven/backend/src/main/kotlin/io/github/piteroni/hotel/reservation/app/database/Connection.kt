package io.github.piteroni.hotel.reservation.app.database

import io.github.piteroni.hotel.reservation.app.utils.Config
import org.jetbrains.exposed.sql.Database

class DatabaseConnectionException(throwable: Throwable) : Exception(throwable)

fun connectToDatabase() {
    try {
        Database.connect(
            url = Config.get("DB_URL"),
            driver = Config.get("DB_DRIVER"),
            user = Config.get("DB_USERNAME"),
            password = Config.get("DB_PASSWORD")
        )
    } catch (throwable: Throwable) {
        throw DatabaseConnectionException(throwable)
    }
}
