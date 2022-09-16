package com.codingblocks.carpicker.vehicle.parts

class Chasis: IPart {
    val seats: List<Seat> = listOf(
        Seat(), Seat(), Seat(), Seat()
    )
    override val price: Int
        get() = 200_000
}