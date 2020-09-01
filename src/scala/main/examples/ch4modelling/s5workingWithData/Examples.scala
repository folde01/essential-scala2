package examples.ch4modelling.s5workingWithData

import examples.ch4modelling.s5workingWithData.example4_5_3_patmatpat.Food


sealed trait A {
  def foo: String = "It's A!"
}

final case class B() extends A {
  override val foo = "It's B"
}

final case class C() extends A {
  override def foo = "It's C"
}

final case class D() extends A

// product type polymorphism pattern
trait F

case class A2(b: B, c: C) {
  def f: F = ??? // uses b and c
}

// sum type polymorphism pattern
trait F3
sealed trait A3 {
  def f3: F3
}
final case class B3() extends A3 {
  def f3: F3 = ???
}
final case class C3() extends A3 {
  def f3: F3 = ???
}

// product type pattern matching pattern
// A has a B and a C
// write a method f that takes an A and creates an F from A's B and C.

object foo {
  case class A(b: B, c: C)
  trait F
  def f(a: A): F = a match {
    case A(b, c) => ???
  }
}

object app extends App {
  println(B().foo)
  println(C().foo)
  println(D().foo)
}

// sum type pattern matching pattern
object sumPatMat {
  sealed trait A
  final case class B() extends A
  final case class C() extends A
  trait F
  def f(a: A): F = a match {
    case b: B => ???
    case c: C => ???
  }
}

// 4.5.3 complete example

object example4_5_3_patmatpat {

  sealed trait Food
  case object Antelope extends Food
  case object Licorice extends Food
  case object TigerFood extends Food
  case class CatFood(food: String) extends Food

  sealed trait Feline {
    def dinner: Food = this match {
      case Cat(favFood: String) => CatFood(favFood)
      case Lion => Antelope
      case Tiger => TigerFood
      case Panther => Licorice
    }
  }
  final case object Lion extends Feline
  final case object Tiger extends Feline
  final case object Panther extends Feline
  final case class Cat(favFood: String) extends Feline

}

object example4_5_3_polymorphism {
  sealed trait Food
  case object Antelope extends Food
  case object Licorice extends Food
  case object TigerFood extends Food
  case class CatFood(food: String) extends Food

  sealed trait Feline {
    def dinner: Food
  }

  case class Cat(favFood: String) extends Feline {
    override def dinner: Food = CatFood(favFood)
  }

  final case object Lion extends Feline {
    override def dinner: Food = Antelope
  }

  final case object Tiger extends Feline {
    override def dinner: Food = TigerFood
  }

  final case object Panther extends Feline {
    override def dinner: Food = Licorice
  }
}





