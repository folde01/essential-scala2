package exercises.ch4modelling.s5workingWithData

sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

object Calculator {
  def +(c: Calculation, n: Int): Calculation = c match {
    case Success(result) => Success(result + n)
    case Failure(reason) => Failure(reason)
  }
  def -(c: Calculation, n: Int): Calculation = c match {
    case Success(result) => Success(result - n)
    case Failure(reason) => Failure(reason)
  }
  def /(c: Calculation, n: Int): Calculation = c match {
    case Failure(reason) => Failure(reason)
    case Success(result) => n match {
      case 0 => Failure("division by zero")
      case _ => Success(result / n)
    }
  }
}

object calcTests extends App {
  assert(Calculator.+(Success(1), 1) == Success(2))
  assert(Calculator.-(Success(1), 1) == Success(0))
  assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
  //  assert(Calculator.-(Success(1), 1) == Success(1)) // fails
  assert(Calculator./(Failure("Badness"), 1) == Failure("Badness"))
  assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))
//  assert(Calculator./(Success(1), 0) == Failure("division by zerooooooooooo")) // fails
  assert(Calculator./(Success(1), 1) == Success(1))
}

