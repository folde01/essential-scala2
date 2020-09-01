package examples

sealed trait Food

class Pizza() extends Food
case class Fiorentina() extends Pizza

final case class Pasta() extends Food
//case class Linguini() extends Pasta // error!

object Chapter04SealedTraits extends App {
  def missingCase(f: Food) =
    f match {
      case Pasta() => "Pasta!"
    }
}
