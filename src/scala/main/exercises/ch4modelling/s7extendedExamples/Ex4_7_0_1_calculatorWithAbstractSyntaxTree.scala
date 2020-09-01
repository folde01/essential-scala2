package exercises.ch4modelling.s7extendedExamples

sealed trait Expression {
  def eval: Calculation = this match {
    case Addition(left, right) => left.eval match {
      case Failure(reason) => Failure(reason)
//      case Success(x) =>
    }
    case Number(value) => Success(value)
    case SquareRoot(Number(n)) if n < 0 => Failure("square root of negative number")
    case Division(left, right) => right match {
      case Number(0) => Failure("division by zero")
      case Number(r) => left match {
        case Number(l) => Success(l/r)
//        case expression: Expression => expression.eval  ...
      }
    }
//    case Subtraction(left, right) => left.eval - right.eval
  }
}
final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class Number(value: Double) extends Expression
final case class SquareRoot(num: Number) extends Expression

sealed trait Calculation
final case class Success(value: Double) extends Calculation
final case class Failure(reason: String) extends Calculation

