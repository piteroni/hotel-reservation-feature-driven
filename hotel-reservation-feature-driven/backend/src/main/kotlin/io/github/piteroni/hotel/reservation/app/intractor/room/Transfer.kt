package io.github.piteroni.hotel.reservation.app.intractor.room

import kotlinx.serialization.Serializable

@Serializable
data class RoomCatalogItem(
    val id: Int,
    val name: String,
    val type: String,
    val dayFee: Int,
    val imagePath: String
)

class RoomNotFoundException(override val message: String?) : Exception(message)

@Serializable
data class RoomCatalogItemDetails(
    val name: String,
    val description: String,
    val type: String,
    val dayFee: Int,
    val amenity: String,
    val catalogImagePaths: List<String>
)
