package com.codingblocks.carpicker.vehicle.parts

data class WheelBase(val size: WheelBase.Size):IPart {
    val chasis: Chasis = Chasis()
    val wheels: List<Wheel> = listOf(
        Wheel(), Wheel(), Wheel(), Wheel()
    )
    override val price: Int
        get() = when(size) {
            Size.SMALL -> TODO()
            Size.MEDIUM -> TODO()
            Size.BIG -> TODO()
        }

    enum class Size { SMALL, MEDIUM, BIG}
}