package com.codingblocks.carpicker.vehicle.parts

data class Engine(
    private val type: Type,
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
}