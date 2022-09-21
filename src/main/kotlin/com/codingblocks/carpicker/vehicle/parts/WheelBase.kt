package com.codingblocks.carpicker.vehicle.parts

import com.codingblocks.carpicker.vehicle.parts.wheel.Wheel

class WheelBase private constructor(
    val size: Size,
    val wheels: List<Wheel>
    ):IPart {



    override val selfPrice: Int
        get() = when(this.size) {
            Size.SMALL -> 100_000
            Size.MEDIUM -> 125_000
            Size.LARGE -> 175_000
        }
    override val totalCost: Int
        get() = selfPrice + wheels.sumOf { it.totalCost }

    enum class Size { SMALL, MEDIUM, LARGE}

    class Builder {

        private lateinit var size: Size
        private lateinit var wheelFactory: Wheel.Factory
        private var spareWheel: Boolean = false

        fun setSize(size: WheelBase.Size):Builder {
            this.size = size
            return this
        }

        fun setWheelFactory(wheelFactory: Wheel.Factory): Builder {
            this.wheelFactory = wheelFactory
            return this
        }

        fun setSpareWheel(spareWheel: Boolean): Builder {
            this.spareWheel = spareWheel
            return this
        }

        fun build(): WheelBase {
            return WheelBase(
                this.size,
                this.wheelFactory.createWheel(
                    4 + if (this.spareWheel) 1 else 0
                )
            )
        }
    }
}