package exercises.ch4modelling.s7extendedExamples.calculator

import exercises.ch4modelling.s7extendedExamples.calculator.Calculator.Success

object Calculator extends App {
  sealed trait Expression {
    def eval: Calculation = this match {
      case Number(value) => Success(value)

      case SquareRoot(ex) => ex.eval match {
        case Failure(msg) => Failure(msg)
        case Success(result) =>
          if (result < 0) Failure("Can't sqrt a neg")
          else Success(Math.sqrt(result))
      }

      case Division(left: Expression, right: Expression) => right.eval match {
        case Failure(msg) => Failure(msg)
        case Success(result1) =>
          if (result1 == 0) Failure("Div by 0")
          else left.eval match {
            case Failure(msg) => Failure(msg)
            case Success(result2) => Success(result2 / result1)
        }
      }

      case Addition(left, right) => left.eval match {
        case Failure(msg) => Failure(msg)
        case Success(result1) => right.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result2) => Success(result1 + result2)
        }
      }

      case Subtraction(left, right) => left.eval match {
        case Failure(msg) => Failure(msg)
        case Success(result1) => right.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result2) => Success(result1 - result2)
        }
      }
    }
  }
  final case class Addition(left: Expression, right: Expression) extends Expression
  final case class Subtraction(left: Expression, right: Expression) extends Expression
  final case class Division(left: Expression, right: Expression) extends Expression
  final case class SquareRoot(ex: Expression) extends Expression
  final case class Number(value: Double) extends Expression

  sealed trait Calculation
  final case class Success(result: Double) extends Calculation
  final case class Failure(msg: String) extends Calculation


//  val t1 = Number(5)
//  assert(t1.eval == 5)
//  val t2 = Number(15)
//  assert(t2.eval == 15)
//  val t3 = Addition(t1, t2)
//  assert(t3.eval == 20)
//  val t4 = Subtraction(t3, t1)
//  assert(t4.eval == 15)

  assert(
    Addition(
      SquareRoot(Number(-1.0)),
      Number(2.0)
    ).eval ==
    Failure("Can't sqrt a neg"))

  assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success (4.0))
  assert(Division(Number(4), Number(0)).eval == Failure("Div by 0"))

  println("finished tests")
}
