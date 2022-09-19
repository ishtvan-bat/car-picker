package com.codingblocks.carpicker.vehicle.parts

data class Transmission(val type: Type): IPart {
    override val selfPrice: Int
        get() = when(this.type){
            Type.RWD -> 90_000
            Type.FWD -> 75_000
            Type.AWD -> 110_000
        }
    override val totalCost: Int
        get() = selfPrice

    enum class Type {RWD, FWD, AWD }
}