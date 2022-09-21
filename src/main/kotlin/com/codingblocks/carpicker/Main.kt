package com.codingblocks.carpicker

import com.codingblocks.carpicker.vehicle.CliktExe
import com.codingblocks.carpicker.vehicle.Vehicle
import com.codingblocks.carpicker.vehicle.parts.Chasis
import com.codingblocks.carpicker.vehicle.parts.Engine
import com.codingblocks.carpicker.vehicle.parts.Transmission
import com.codingblocks.carpicker.vehicle.parts.WheelBase
import com.codingblocks.carpicker.vehicle.parts.seat.Seat
import com.codingblocks.carpicker.vehicle.parts.wheel.Wheel
import com.github.ajalt.clikt.*
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.output.TermUi

fun main(args: Array<String>) = CliktExe().main(args)