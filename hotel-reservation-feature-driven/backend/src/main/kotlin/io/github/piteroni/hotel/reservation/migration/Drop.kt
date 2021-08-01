package io.github.piteroni.hotel.reservation.migration

import io.github.piteroni.hotel.reservation.app.entities.RoomIntroductionImages
import io.github.piteroni.hotel.reservation.app.entities.RoomTypes
import io.github.piteroni.hotel.reservation.app.entities.Rooms
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun drop() {
    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.drop(RoomIntroductionImages)
        SchemaUtils.drop(Rooms)
        SchemaUtils.drop(RoomTypes)
    }
}

fun main() {
    connect()
    drop()
}
