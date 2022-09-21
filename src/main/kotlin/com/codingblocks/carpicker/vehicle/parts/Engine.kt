package com.codingblocks.carpicker.vehicle.parts

class Engine private constructor(
    val type: Type,
    val transmission: Transmission
    ): IPart {

    override val selfPrice: Int
        get() = when(this.type){
            Type.PETROL -> 100_000
            Type.DIESEL -> 200_000
            Type.HYBRID -> 500_000
            Type.ELECTRIC -> 400_000
        }
    override val totalCost: Int
        get() = selfPrice + transmission.totalCost

    enum class Type {PETROL, DIESEL, HYBRID, ELECTRIC}

    class Builder {

        private lateinit var engineType: Type
        private lateinit var transmission: Transmission

        fun setEngineType(engineType: Type):Builder {
            this.engineType = engineType
            return this
        }

        fun setTransmission(transmission: Transmission):Builder{
            this.transmission = transmission
            return this
        }

        fun build(): Engine {
            return Engine(this.engineType, this.transmission)
        }
    }
}