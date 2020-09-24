package main.exercises.ch5sequences

object S5MapLiveCoding extends App {
  // Map

  // Stories

  // 1 .... IDs  => Users
  /*
    have List[ID]
    want  List[User]

    fn ID => User


   2... have   a possible User
   want   a possible most recent order (because maybe there's no orders)

   need fn ...

   Maybe[User] ... Full(v), Empty()

   fn: User => Order

   Maybe[Order]

   3... possibly completed Order (have)... or error msg
   want: total value of our possible Order ... or error msg

   types:

   X[String, Order]
   X[String, Double]


   In common:

   fn A => B
   X[A] ... start here
   X[B] ... end here

   map runs our fn and turns our X[A] into an X[B]
   and it lives on the X trait

   */

  sealed trait LinkedList[A] {
    def map[B](fn: A => B): LinkedList[B] = this match {
      case End() => End[B]()
      case Pair(hdA, tlA) => Pair(fn(hdA), tlA.map(fn))   // pair of B thing ... turn hdA into B.. turn tlA into tlB
    }
  }
  final case class Pair[A](hd: A, tl: LinkedList[A]) extends LinkedList[A]
  final case class End[A]() extends LinkedList[A]

  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Pair(4, Pair(5, End())))))

  println(list)

  def doublerThing(a: Int): Int = {
    a * 2
  }

  val doublerThing2: Int => Int = x => 2 * x

  println(list.map(doublerThing))

  println(list.map(doublerThing2))

  println(list.map(x => 2 * x))

  println(s"super concise... ${list.map(_ * 2)}")

  case class PairOfStrings(stringA: String, stringB: String)

  val stringsAreEqualWithoutCase: PairOfStrings => Boolean =
    { p => p.stringA.equalsIgnoreCase(p.stringB) }

  // use lambdas for one-liners only, otherwise make a proper method with parameters (a def)

  val pos: LinkedList[PairOfStrings] = Pair(PairOfStrings("foo", "Foo"), End())

  println(pos.map(stringsAreEqualWithoutCase))

  // exercise: linked list of strings... apply fold and use stringsAreEqualWithoutCase to get a true/false



    // Liskov substitution principle ... from the "S.O.L.I.D. principles" ... use the more abstract type
  // contract between trait and implementation is maintained






}
