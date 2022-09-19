package com.codingblocks.carpicker.vehicle.parts

import com.codingblocks.carpicker.vehicle.parts.wheel.Wheel

data class WheelBase(
    val size: WheelBase.Size,
    val chasis: Chasis,
    val wheelFactory: Wheel.Factory,
    val spareWheel: Boolean = false
    ):IPart {

    val numWheels = 4 + if (spareWheel) 1 else 0

    private val wheels: List<Wheel> = generateSequence { wheelFactory.createWheel() }.take(numWheels).toList()

    override val selfPrice: Int
        get() = when(this.size) {
            Size.SMALL -> 100_000
            Size.MEDIUM -> 125_000
            Size.BIG -> 175_000
        }
    override val totalCost: Int
        get() = selfPrice + chasis.totalCost + wheels.sumOf { it.totalCost }

    enum class Size { SMALL, MEDIUM, BIG}
}