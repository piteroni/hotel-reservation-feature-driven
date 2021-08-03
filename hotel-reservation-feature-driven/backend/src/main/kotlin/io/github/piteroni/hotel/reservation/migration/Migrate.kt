package io.github.piteroni.hotel.reservation.migration

import io.github.piteroni.hotel.reservation.app.database.connectToDatabase
import io.github.piteroni.hotel.reservation.app.entity.RoomCatalogImages
import io.github.piteroni.hotel.reservation.app.entity.RoomTypes
import io.github.piteroni.hotel.reservation.app.entity.Rooms
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
        create(RoomCatalogImages)
    }
}

fun main() {
    connectToDatabase()
    migrate()
    insert()
}
