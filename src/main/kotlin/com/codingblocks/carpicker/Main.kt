package com.codingblocks.carpicker

import com.codingblocks.carpicker.vehicle.Vehicle
import com.codingblocks.carpicker.vehicle.parts.Chasis
import com.codingblocks.carpicker.vehicle.parts.Engine
import com.codingblocks.carpicker.vehicle.parts.Transmission
import com.codingblocks.carpicker.vehicle.parts.WheelBase
import com.codingblocks.carpicker.vehicle.parts.seat.Seat
import com.codingblocks.carpicker.vehicle.parts.wheel.Wheel

fun main() {

    val hondaCity = Vehicle(
        WheelBase(
            WheelBase.Size.MEDIUM,
            Chasis(
                Chasis.Type.SEDAN,
                Seat.Factory(Seat.Upholstery.LEATHER)
                ),
            Wheel.Factory(Wheel.Type.STEEL)
        ),
        Engine(
            Engine.Type.DIESEL,
            Transmission(Transmission.Type.AWD)
        )
    )

    val ecosport = Vehicle(
        WheelBase(
            WheelBase.Size.SMALL,
            Chasis(
                Chasis.Type.SUV,
                Seat.Factory(Seat.Upholstery.REXINE)
                ),
            Wheel.Factory(Wheel.Type.ALLOY),
            spareWheel = true
        ),
        Engine(
            Engine.Type.PETROL,
            Transmission(Transmission.Type.FWD)
        )
    )

    println("HondaCity = ${hondaCity.price}")
    println("Ecosport = ${ecosport.price}")
    println("Ecosport = ${ecosport.wheelBase.numWheels}")
}