package main.exercises.ch5sequences

object S5Map extends App {

  // map

  sealed trait LinkedList[A] {
    def map[B](fn: A => B): LinkedList[B] = {
      this match {
        case End() => End[B]()
        case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
      }
    }

    //    def flatMap[B](fn: A => LinkedList[B]): LinkedList[B] = {
    //      this match {
    //        case End() => End[B]()
    ////        case Pair(hd, tl) => Pair[B](fn(hd), tl.flatMap(fn))
    //      }
    //    }
  }

  final case class Pair[A](hd: A, tail: LinkedList[A]) extends LinkedList[A]

  final case class End[A]() extends LinkedList[A]

  val users = Pair("u1", End())

  def lastOrder(u: String) = "o1"

  println(users.map(lastOrder))

  // flatMap

  sealed trait Maybe[A] {
    def flatMap[B](fn: A => Maybe[B]): Maybe[B] = this match {
      case Full(value) => fn(value)
      case Empty() => Empty[B]()
    }
  }

  final case class Full[A](value: A) extends Maybe[A]

  final case class Empty[A]() extends Maybe[A]

  def mightFail1: Maybe[Int] = Full(1)

  def mightFail2: Maybe[Int] = Full(2)

  def mightFail3: Maybe[Int] = Empty()

  val testMaybe: Maybe[Int] =
    mightFail1 flatMap { x =>
      mightFail2 flatMap { y =>
        mightFail3 flatMap { z =>
          Full(x + y + z)
        }
      }
    }

  println(testMaybe)

  val testMaybe2: Maybe[Int] =
    mightFail1 flatMap { x =>
      mightFail2 flatMap { y =>
        Full(x + y)
      }
    }

  println(testMaybe2)


}
