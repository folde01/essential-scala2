package examples.ch4modelling.s3modellingDataWithTraits

import exercises.ch4modelling.s4sumType.Color

//              and              or
//              ------------     -------------
// has-a        product type
// is-a                          sum type

trait B
trait C

//////////////////
// "IS-A OR"
//////////////////

// product data type 1: A has-a B and a C
case class A1(b: B, c: C)

// Product data type 2
trait A2 {
  def b: B
  def c: C
}

//////////////////
// "HAS-A AND"
//////////////////

// sum data type: BinaryNumber is-a 1 or 0
sealed trait Bin
final case object One extends Bin
final case object Zero extends Bin

sealed trait GoodVsEvil {
  def name: String
}
trait Good extends GoodVsEvil
trait Evil extends GoodVsEvil

object app extends App {
  final class Duckling(val name: String) extends Good
  final class Vampire(val name: String) extends Evil
}

//              and              or
//              ------------     -------------
// has-a        product type
// is-a         "extends with"   sum type

//////////////////
// "IS-A AND"
//////////////////

// a dog is a pet and a canine
trait Canine
trait Pet
class Dog extends Pet with Canine

//////////////////
// "HAS-A OR"
//////////////////

// A has a B and the B is either a C or a D...
// an electric car has EITHER a fuel cell OR a battery
sealed trait ElectricPowerSource
final class FuelCell extends ElectricPowerSource
final class Battery extends ElectricPowerSource

trait ElectricCar {
  def powerSource: ElectricPowerSource
}

// or: A is a D or E , and D has a B and E has a C ...
sealed trait ElectricBus {
  def powerSource: ElectricPowerSource
}
final class BatteryBus(val powerSource: Battery) extends ElectricBus
final class FuelCellBus(val powerSource: FuelCell) extends ElectricBus


case class A(b: B, c: C)

//case class Human(color: Color, bloodType: BloodType)

sealed trait BloodType
final case object A extends BloodType
final case object B extends BloodType
final case object O extends BloodType

trait Human2 {
  def eyecolor: Color
  def bloodType: BloodType
}

trait Zombie {
  def eyecolor: Color
}

case class LivingHuman(eyecolor: Color, bloodType: BloodType) extends Human2
case class WalkingDead(eyecolor: Color) extends Zombie

sealed trait Feline {
  def legs: Int = 4
  def color: Color
}
final case class Lion(val color: Color) extends Feline
final case class Tiger(val color: Color) extends Feline




