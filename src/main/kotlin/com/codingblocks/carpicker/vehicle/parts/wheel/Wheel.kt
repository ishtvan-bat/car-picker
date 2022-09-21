package com.codingblocks.carpicker.vehicle.parts.wheel

import com.codingblocks.carpicker.vehicle.parts.IPart

 class Wheel private constructor(
    val type: Type
        ): IPart {
    override val selfPrice: Int = when (this.type){
        Type.STEEL -> 10_000
        Type.ALLOY -> 12_000
        Type.CARBON -> 20_000
    }

    override val totalCost = selfPrice

    enum class Type { STEEL, ALLOY, CARBON }

    class Factory (
        val type: Type
    ) {
        fun createWheel(numWheels: Int): List<Wheel> {
            return generateSequence { Wheel(type) }.take(numWheels).toList()
        }
    }

}