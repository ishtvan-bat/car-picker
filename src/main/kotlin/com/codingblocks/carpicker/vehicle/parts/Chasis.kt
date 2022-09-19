package com.codingblocks.carpicker.vehicle.parts

import com.codingblocks.carpicker.vehicle.parts.seat.Seat

data class Chasis(
    private val type: Type,
    val seatFactory: Seat.Factory
    ): IPart {

    private val numSeats: Int = when(this.type){
        Type.HATCHBACK -> 4
        Type.SEDAN -> 5
        Type.SUV -> 8
        Type.PICKUP -> 6
    }

    private val seats: List<Seat> = generateSequence { seatFactory.createSeat() }.take(numSeats).toList()

    override val selfPrice: Int
        get() = when(this.type){
            Type.HATCHBACK -> 150_000
            Type.SEDAN -> 200_000
            Type.SUV -> 250_000
            Type.PICKUP -> 350_000
        }
    override val totalCost: Int
        get() = selfPrice + seats.sumOf { it.totalCost }

    enum class Type {HATCHBACK, SEDAN, SUV, PICKUP}
}