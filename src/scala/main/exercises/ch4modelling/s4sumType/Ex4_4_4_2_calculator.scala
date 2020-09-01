package exercises.ch4modelling.s4sumType

sealed trait Calculation
final case class Successful(result: Int) extends Calculation
final case class Failure(message: String) extends Calculation

