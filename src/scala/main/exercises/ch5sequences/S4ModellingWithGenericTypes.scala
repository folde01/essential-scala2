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
    if (input == true) Left[Int, String](123)
    else Right[Int, String]("abc")

  sealed trait Sum[A, B] {
    // 5.4.6.3
    def fold[A, B, C]():
  }

  final case class Left[A, B](value: A) extends Sum[A, B]

  final case class Right[A, B](value: B) extends Sum[A, B]

  println(intOrString(true))
  println(intOrString(false))
  println(Left[Int, String](1).value)
  println(Right[Int, String]("foo").value)
  val sum: Sum[Int, String] = Right("foo")

  sum match {
    case Left(x) => x.toString
    case Right(x) => x
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
