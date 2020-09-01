package exercises.Ex4222colorAndShape

import exercises.{ShapeSealed, Star, Triangle}

sealed trait Color {
  def red: Int
  def green: Int
  def blue: Int
  def lightness: String = {
    val colors = List(red, green, blue)
//    println(colors.sum)
    if (colors.sum > 255 + 255/2) "light" else "dark"
  }
}

case class definedColor(
                       red: Int,
                       green: Int,
                       blue: Int
                  ) extends Color

case class ColoredTriangle(base: Double,
                           height: Double,
                           color: Color) extends ShapeSealed {
  val area = base * height * .5
  val sides = 3
  val perimeter = 9999
}

case class ColoredStar(color: Color) extends ShapeSealed {
  def sides = 10
  def perimeter = 999999
  def area = 999999
}

object DrawWithColor {
  def apply(s: ShapeSealed): String = {
    s match {
      case ColoredTriangle(base,height, color) => s"it's a ${color.lightness} triangle with base $base and height $height"
      case ColoredStar(color) => s"it's a ${color.lightness} star"
    }
  }
}
object app extends App {
  val Red: Color = definedColor(255, 0, 0)
  val Yellow: Color = definedColor(255, 255, 0)
  val Pink: Color = definedColor(255, 0, 255)
  val Purple: Color = definedColor(76, 7, 81)
  println(s"red is ${Red.lightness}")
  println(s"yellow is ${Yellow.lightness}")
  println(s"pink is ${Pink.lightness}")
  println(s"purple is ${Purple.lightness}")

  println(DrawWithColor(ColoredTriangle(1, 2, Yellow)))
  println(DrawWithColor(ColoredStar(Red)))
}

