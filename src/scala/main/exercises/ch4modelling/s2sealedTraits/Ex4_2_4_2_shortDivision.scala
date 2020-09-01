package exercises.ch4modelling.s2sealedTraits

object divide {
  def apply(a: Int, b: Int): DivisionResult = {
    if (b == 0) Infinite else Finite(a/b)
  }
}

sealed trait DivisionResult

final case class Finite(quotient: Int) extends DivisionResult
final case object Infinite extends DivisionResult

object app extends App {
  def describeDivisionOf(a: Int, b: Int): String = {
    divide(a, b) match {
      case Finite(quotient) => s"$quotient"
      case Infinite => "division by zero"
    }
  }
  println(describeDivisionOf(1, 1))
  println(describeDivisionOf(1, 2))
  println(describeDivisionOf(1, 0))
}