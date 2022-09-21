package com.codingblocks.carpicker.vehicle

import com.codingblocks.carpicker.vehicle.parts.Chasis
import com.codingblocks.carpicker.vehicle.parts.Engine
import com.codingblocks.carpicker.vehicle.parts.Transmission
import com.codingblocks.carpicker.vehicle.parts.WheelBase
import com.codingblocks.carpicker.vehicle.parts.seat.Seat
import com.codingblocks.carpicker.vehicle.parts.wheel.Wheel
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError

class CliktExe: CliktCommand() {
    override fun run() {
        echo("""
                --------  Welcome to Car Picker 1.0  ------------
        Here you can build your very own car, with everything fully customizable.
                    Feel free to pick engine, seats, wheels etc.
    """.trimMargin())

        confirm("Continue to build a car ? ", abort=true)

        val wheelBaseBuilder = WheelBase.Builder()
        val chasisBuilder = Chasis.Builder()
        val engineBuilder = Engine.Builder()

        // ----- Start wheelbase work ----------
        prompt("Enter wheelbase size: (s)mall, (m)edium or (l)arge"){
            when(it){
                "S", "s" -> wheelBaseBuilder.setSize(WheelBase.Size.SMALL)
                "M", "m" -> wheelBaseBuilder.setSize(WheelBase.Size.MEDIUM)
                "L", "l" ->  wheelBaseBuilder.setSize(WheelBase.Size.LARGE)
                else -> throw UsageError("Size has to be: (s)mall, (m)edium or (l)arge")
            }
        }!!

        prompt("Enter wheelbase type: (s)teel, (a)lloy or (c)arbon"){
            when(it){
                "S", "s" -> wheelBaseBuilder.setWheelFactory(Wheel.Factory(Wheel.Type.STEEL))
                "A", "a" -> wheelBaseBuilder.setWheelFactory(Wheel.Factory(Wheel.Type.ALLOY))
                "C", "c" ->  wheelBaseBuilder.setWheelFactory(Wheel.Factory(Wheel.Type.CARBON))
                else -> throw UsageError("Wheelbase type has to be: (s)teel, (a)lloy or (c)arbon")
            }
        }!!
        // ----- End  wheelbase work ----------

        // ----- Start Chasis work ----------
        prompt("Enter chasis type size: (H)ATCHBACK, (SU)V, (P)ICKUP or (S)EDAN"){
            when(it){
                "H", "h" -> chasisBuilder.setChasisType(Chasis.Type.HATCHBACK)
                "SU", "su" -> chasisBuilder.setChasisType(Chasis.Type.SUV)
                "S", "s" -> chasisBuilder.setChasisType(Chasis.Type.SEDAN)
                "P", "p" -> chasisBuilder.setChasisType(Chasis.Type.PICKUP)
                else -> throw UsageError("Chasis type has to be: (s)mall, (m)edium or (l)arge")
            }
        }!!
        prompt("Enter Seat Upholstery type : (C)LOTH, (R)EXINE or (L)EATHER"){
            when(it){
                "C", "c" -> chasisBuilder.setSeatFactory(Seat.Factory(Seat.Upholstery.CLOTH))
                "R", "r" -> chasisBuilder.setSeatFactory(Seat.Factory(Seat.Upholstery.REXINE))
                "L", "l" -> chasisBuilder.setSeatFactory(Seat.Factory(Seat.Upholstery.LEATHER))
                else -> throw UsageError("Seat Upholstery type has to be: (C)LOTH, (R)EXINE or (L)EATHER")
            }
        }!!
        // ----- End Chasis work ----------

        // ----- Start engine work ----------

        prompt("Enter Engine type : (P)ETROL, (D)IESEL, (H)YBRID or (E)LECTRIC"){
            when(it){
                "P", "p" -> engineBuilder.setEngineType(Engine.Type.PETROL)
                "D", "d" -> engineBuilder.setEngineType(Engine.Type.DIESEL)
                "H", "h" -> engineBuilder.setEngineType(Engine.Type.HYBRID)
                "E", "e" -> engineBuilder.setEngineType(Engine.Type.ELECTRIC)
                else -> throw UsageError("Engine type has to be: (P)ETROL, (D)IESEL, (H)YBRID or (E)LECTRIC")
            }
        }!!

        prompt("Enter Transmission type : (R)WD, (F)WD or (A)WD"){
            when(it){
                "R", "r" -> engineBuilder.setTransmission(Transmission(Transmission.Type.RWD))
                "F", "f" -> engineBuilder.setTransmission(Transmission(Transmission.Type.FWD))
                "A", "a" -> engineBuilder.setTransmission(Transmission(Transmission.Type.AWD))
                else -> throw UsageError("Transmission type has to be: (R)WD, (F)WD or (A)WD")
            }
        }!!

        // ----- End engione work ----------

        val myCar = Vehicle.Builder()
            .setChasis(chasisBuilder.build())
            .setEngine(engineBuilder.build())
            .setWheelBase(wheelBaseBuilder.build())
            .build()


        echo("program continues")
        echo("""
            ${myCar.wheelBase.size}
            ${myCar.chasis.type}
            ${myCar.chasis.seats.size}
            ${myCar.engine.type}
            ${myCar.engine.transmission.type}
            ${myCar.wheelBase.wheels.map { it.type }}
        """.trimIndent())

    }
}