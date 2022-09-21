package com.codingblocks.carpicker.vehicle.parts

import com.codingblocks.carpicker.vehicle.parts.seat.Seat

class Chasis private  constructor(
    val type: Type,
    val seats: List<Seat>
    ): IPart {



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

    class Builder {

        lateinit var chasisType: Chasis.Type
        lateinit var seatFactory: Seat.Factory

        fun setChasisType(chasisType: Chasis.Type):Builder{
            this.chasisType =chasisType
            return this
        }

        fun setSeatFactory(seatFactory: Seat.Factory):Builder{
            this.seatFactory =seatFactory
            return this
        }
        fun build(): Chasis {
            val numSeats: Int = when(this.chasisType){
                Type.HATCHBACK -> 4
                Type.SEDAN -> 5
                Type.SUV -> 8
                Type.PICKUP -> 6
            }

            return Chasis(
                this.chasisType,
                this.seatFactory.createSeats(numSeats)
            )
        }
    }
}