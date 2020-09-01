package exercises

// 4.1.4.1

trait Feline {
  def colour: String
  def sound: String = this match {
    case _: Cat => "meow"
    case _ => "roar"
  }
}

case class Cat(
              colour: String,
              food: String
              ) extends Feline

case class Lion(
                colour: String,
                maneSize: Int
              ) extends Feline

case class Tiger(
                 colour: String,
               ) extends Feline

case class Panther(
                  colour: String,
                ) extends Feline


// 4.1.4.2

trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle(radius: Double) extends Shape {
  def sides = 1
  def perimeter = Math.PI * radius * 0.5
  def area = Math.PI * radius * radius
}

case class Rectangle(height: Double, width: Double) extends Shape {
  def sides = 4
  def perimeter = 2 * (height + width)
  def area = height * width
}

case class Square(length: Double) extends Shape {
  val r = Rectangle(length, length)
  def sides = r.sides
  def perimeter = r.perimeter
  def area = r.area
}

// 4.1.4.3

trait Rectangular extends Shape {
  def sides = 4
  def width: Double
  def height: Double
  def perimeter = 2 * (width + height)
  def area = width * height
}

case class Rectangle2(
                       height: Double,
                       width: Double) extends Rectangular

case class Square2(size: Double) extends Rectangular {
  def width = size
  def height = size
}
// 4.2.2.1 Printing Shapes

trait ShapeSealed {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Triangle(
                   base: Double,
                   height: Double) extends ShapeSealed {
  def sides = 3
  def perimeter = 9999
  def area = base * height * 0.5
}

case class Star(color: String) extends ShapeSealed {
  def sides = 10
  def perimeter = 999999
  def area = 999999
}

object Draw {
  def apply(s: ShapeSealed): String = {
    s match {
      case Triangle(base,height) => s"it's a triangle with base $base and height $height!!!"
      case Star(color) => s"it's a $color star!!"
    }
  }
}

/*
// 4.2.2.2 The Color and the Shape


sealed trait Color {
  def red: Int
  def green: Int
  def blue: Int
  def lightness: String = List(red, green, blue).max match {
    case lightest if lightest > (255/2) => "light"
    case _ => "dark"
  }
}

trait PredefinedColor extends Color {
  def name: String
}

object Red extends PredefinedColor  {
  val name = "red"
  val red = 255
  val green = 0
  val blue = 0
}

object Yellow extends PredefinedColor {
  val name = "yellow"
  val red = 255
  val green = 255
  val blue = 0
}

object Pink extends PredefinedColor {
  val name = "pink"
  val red = 255
  val green = 0
  val blue = 255
}

case class CustomColor(
                       red: Int,
                       green: Int,
                       blue: Int) extends Color {
}

trait ColoredShapeSealed {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
}

case class ColoredTriangle(
                     base: Double,
                     height: Double,
                     color: CustomColor) extends ColoredShapeSealed {
  def sides = 3
  def perimeter = 9999
  def area = base * height * 0.5
}

case class ColoredStar(color: Color) extends ColoredShapeSealed {
  def sides = 10
  def perimeter = 999999
  def area = 999999
}

object DrawColored {
  def apply(s: ColoredShapeSealed): String = {
    s match {
      case ColoredTriangle(base,height, CustomColor(_,_,_)) => s"it's a ${s.color.lightness} triangle with base $base and height $height!!!"
      case ColoredTriangle(base,height, PredefinedColor) => s"it's a ${s.color.name} triangle with base $base and height $height!!!"
//      case ColoredStar(CustomColor(_,_,_)) => s"it's a ${s.color.name} star!!"
    }
  }
}

 */

object Chapter04 extends App {

  // 4.1.4.1
  val cat = Cat("blue", "mice")
  println(cat.sound)
  val lion = Lion("red", 10)
  println(lion.sound)

  // 4.1.4.2
  println(Circle(1).area)
  println(Rectangle(1, 2).perimeter)
  println(Square(2.5).area)

  // 4.1.4.3
  println(Rectangle2(2, 3).area)
  println(Square2(3).perimeter)

  // 4.2.2.1 Printing Shapes
  println(Draw(Star("red")))
  println(Draw(Triangle(5,4)))

  /*
  println("\n4.2.2.2 The Color and the Shape")
  println(DrawColored(ColoredTriangle(4, 5, CustomColor(100, 100, 100))))
  println(DrawColored(ColoredStar(CustomColor(200, 200, 100))))
  println(DrawColored(ColoredStar(Red)))
   */
}

