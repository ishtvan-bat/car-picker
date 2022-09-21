package com.codingblocks.carpicker.vehicle.parts.seat

import com.codingblocks.carpicker.vehicle.parts.IPart

class Seat private constructor(
    val upholstery: Upholstery
        ): IPart {

    override val selfPrice: Int = when(this.upholstery){
        Upholstery.CLOTH -> 10_000
        Upholstery.REXINE -> 15_000
        Upholstery.LEATHER -> 20_000
    }

    override val totalCost: Int = selfPrice

    enum class Upholstery { CLOTH, REXINE, LEATHER}

    class Factory (val upholstery: Upholstery){
        fun createSeats(numSeats: Int): List<Seat> {
            return generateSequence { Seat(upholstery) }.take(numSeats).toList()
        }
    }
}