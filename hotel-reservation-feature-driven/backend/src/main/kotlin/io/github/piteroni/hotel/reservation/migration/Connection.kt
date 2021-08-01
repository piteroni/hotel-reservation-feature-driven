package io.github.piteroni.hotel.reservation.migration

import io.github.piteroni.hotel.reservation.app.utils.Config
import org.jetbrains.exposed.sql.Database

fun connect() {
    Database.connect(
        url = Config.get("DB_URL"),
        driver = Config.get("DB_DRIVER"),
        user = Config.get("DB_USERNAME"),
        password = Config.get("DB_PASSWORD")
    )
}
