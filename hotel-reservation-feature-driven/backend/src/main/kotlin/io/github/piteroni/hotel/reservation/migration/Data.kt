package io.github.piteroni.hotel.reservation.migration

import io.github.piteroni.hotel.reservation.app.entity.Room
import io.github.piteroni.hotel.reservation.app.entity.RoomCatalogImage
import io.github.piteroni.hotel.reservation.app.entity.RoomType
import org.jetbrains.exposed.sql.transactions.transaction

internal fun insert() {
    transaction {
        RoomType.new {
            name = "和室"
        }.also {
            Room.new {
                name = "ゆとりの和室"
                description = "お風呂・トイレも部屋内にある、広めの和室です。部活・サークルなど、気の合う仲間たちと大人数で利用するのに適しています。"
                amenity = "テレビ、エアコン、冷蔵庫、部屋着、ドライヤー、シャンプー、リンス"
                type = it
                dayFee = 9000
                capacity = 4
                imagePath = "/image/japanese-style-room.jpg"
            }.also {
                RoomCatalogImage.new {
                    path = "/image/japanese-style-room-introduction-1.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/japanese-style-room-introduction-2.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/japanese-style-room-introduction-3.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/japanese-style-room-introduction-4.jpg"
                    room = it
                }
            }
        }

        RoomType.new {
            name = "洋室"
        }.also {
            Room.new {
                name = "落ち着きのある洋室"
                description = "2~3名でのご利用に最適な落ち着きのある洋室です。ファミリー様も大歓迎です。トイレは部屋内にありますが、お風呂は大浴場利用となります。"
                amenity = "テレビ、エアコン、冷蔵庫、部屋着"
                type = it
                dayFee = 8000
                capacity = 3
                imagePath = "/image/western-style-room.jpg"
            }.also {
                RoomCatalogImage.new {
                    path = "/image/western-style-room-introduction-1.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/western-style-room-introduction-2.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/western-style-room-introduction-3.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/western-style-room-introduction-4.jpg"
                    room = it
                }
            }
        }

        RoomType.new {
            name = "和洋室"
        }.also {
            Room.new {
                name = "みんなで和洋室"
                description = "最大6名まで利用可能な和洋室です。ベッド3台、布団3組の形となります。シャワー、トイレは部屋内にありますが、お風呂は大浴場利用となります。"
                amenity = "テレビ、エアコン、冷蔵庫、部屋着"
                type = it
                dayFee = 10000
                capacity = 6
                imagePath = "/image/japanese-western-style-room.jpg"
            }.also {
                RoomCatalogImage.new {
                    path = "/image/japanese-western-style-room-introduction-1.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/japanese-western-style-room-introduction-2.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/japanese-western-style-room-introduction-3.jpg"
                    room = it
                }

                RoomCatalogImage.new {
                    path = "/image/japanese-western-style-room-introduction-4.jpg"
                    room = it
                }
            }
        }
    }
}
