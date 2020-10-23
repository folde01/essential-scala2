package main.exercises.ch5sequences

import org.scalatest._

object S4ModellingWithGenericTypes extends App {

  // 5.4.1.1
  case class Pair[A, B](one: A, two: B)

  val pair = Pair[String, Int]("hi", 2)
  // pair: Pair[String,Int] = Pair(hi,2)
  pair.one
  // res0: String = hi
  pair.two
  // res1: Int = 2

  assert(pair.one == "hi")
  assert(pair.two == 2)

  // 5.4.3.1

  def intOrString(input: Boolean): Sum[Int, String] =
    if (input == true) Failure[Int, String](123)
    else Success[Int, String]("abc")

  sealed trait Sum[A, B] {
    // 5.4.6.3
    //    def fold[A, B, C](f1: A => C, f2: B => C): C = this match {
    //      case Left(value) => f1(value)
    //      case Right(value) => f2(value)
    //    }

    // 5.5.4.4 - part 2
    def map[C](f: B => C): Sum[A, C] = {
      this match {
        case Failure(v) => Failure(v)
        case Success(v) => Success(f(v))
      }
    }

    def flatMap[C](f: B => Sum[A, C]): Sum[A, C] =
      this match {
        case Failure(v) => Failure(v)
        case Success(v) => f(v)
      }
  }

  // 5.5.4.4 - part 1

  final case class Failure[A, B](value: A) extends Sum[A, B]

  final case class Success[A, B](value: B) extends Sum[A, B]

  val five: Sum[String, Int] = Success(5)
  val pi: Sum[String, Int] = Failure("I'm not really pi, I'm just some words!")

  def twoInts(n: Int): String = n.toString + n.toString

  def twoInts2(n: Int) = Success(n).toString + Success(n).toString

  val answer554421 = five.map(twoInts)
  val answer554422 = pi.map(twoInts)
  val answer554431 = five.flatMap(twoInts2)

  println(s"5.5.4.4 part 2 - 1: " + answer554421)
  println(s"5.5.4.4 part 2 - 2: " + answer554422)

  println(intOrString(true))
  println(intOrString(false))
  println(Failure[Int, String](1).value)
  println(Success[Int, String]("foo").value)
  val sum: Sum[Int, String] = Success("foo")

  sum match {
    case Failure(x) => x.toString
    case Success(x) => x
  }

  // 5.4.4.1

  sealed trait Maybe[A] {
    // 5.4.6.2
    def fold[B](e: B, f: A => B): B = this match {
      case Empty() => e
      case Full(value: A) => f(value)
    }
  }

  final case class Full[A](value: A) extends Maybe[A]

  final case class Empty[A]() extends Maybe[A]

  val perhaps: Maybe[Int] = Empty[Int]

  val perhaps2: Maybe[Int] = Full(1)

  // 5.4.6.1 - traits when inheritance is needed


}
