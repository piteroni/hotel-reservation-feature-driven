package io.github.piteroni.hotel.reservation.migration

import io.github.piteroni.hotel.reservation.app.entities.RoomIntroductionImages
import io.github.piteroni.hotel.reservation.app.entities.RoomTypes
import io.github.piteroni.hotel.reservation.app.entities.Rooms
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

internal fun create(table: IntIdTable) {
    SchemaUtils.create(table)
    SchemaUtils.createMissingTablesAndColumns(table)
}

internal fun migrate() {
    transaction {
        addLogger(StdOutSqlLogger)
        create(RoomTypes)
        create(Rooms)
        create(RoomIntroductionImages)
    }
}

fun main() {
    connect()
    migrate()
    insert()
}
