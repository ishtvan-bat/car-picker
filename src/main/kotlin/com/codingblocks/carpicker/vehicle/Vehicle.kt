package com.codingblocks.carpicker.vehicle

import com.codingblocks.carpicker.vehicle.parts.Engine
import com.codingblocks.carpicker.vehicle.parts.WheelBase

class Vehicle (
    val wheelBase: WheelBase,
    private val engine: Engine
    ) {

    val price: Int = wheelBase.totalCost + engine.totalCost
}
