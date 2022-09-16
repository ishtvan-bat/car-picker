package com.codingblocks.carpicker.vehicle.parts

class Engine: IPart {
    val transmission: Transmission = Transmission()
    override val price: Int
        get() = 150_000
}