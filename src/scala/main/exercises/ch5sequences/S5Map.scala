//package main.exercises.ch5sequences
//
//object S5Map extends App {
//
//  // map
//
//  sealed trait LinkedList[A] {
//    def map[B](fn: A => B): LinkedList[B] = {
//      this match {
//        case End() => End[B]()
//        case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
//      }
//    }
//
//    //    def flatMap[B](fn: A => LinkedList[B]): LinkedList[B] = {
//    //      this match {
//    //        case End() => End[B]()
//    ////        case Pair(hd, tl) => Pair[B](fn(hd), tl.flatMap(fn))
//    //      }
//    //    }
//  }
//
//  final case class Pair[A](hd: A, tail: LinkedList[A]) extends LinkedList[A]
//
//  final case class End[A]() extends LinkedList[A]
//
//  val users = Pair("u1", End())
//
//  def lastOrder(u: String) = "o1"
//
//  println(users.map(lastOrder))
//
//  // flatMap
//
//  sealed trait Maybe[A] {
//    def flatMap[B](fn: A => Maybe[B]): Maybe[B] = this match {
//      case Full(value) => fn(value)
//      case Empty() => Empty[B]()
//    }
//
//    // 5.5.4.2 Mapping Maybe - p150
//
//    def map[B](fn: A => B): Maybe[B] = this match {
//      case Full(v) => Full(fn(v))
//      case Empty() => Empty[B]()
//    }
//
//    // 5.5.4.2 map in terms of flatMap
//
//    def flatMapMap[B](fn: A => B): Maybe[B] = {
//      def fn2(a: A): Maybe[B] = Full(fn(a))
//      flatMap[B](fn2)
//      // or, as per the solution, just...
//      // flatMap[B](v => Full(fn(v)))
//    }
//  }
//
//  final case class Full[A](value: A) extends Maybe[A]
//
//  final case class Empty[A]() extends Maybe[A]
//
//  // test 5.5.4.2
//
//  val fullInt: Maybe[Int] = Full(1)
//  def intToString(n: Int): String = "cat"
//  println(s"test 5.5.4.1: ${fullInt.map(intToString)}")
//  println(s"test 5.5.4.1: ${fullInt.flatMapMap(intToString)}")
//
//  val emptyInt: Maybe[Int] = Empty()
//  println(s"test 5.5.4.1: ${emptyInt.map(intToString)}")
//  println(s"test 5.5.4.1: ${emptyInt.flatMapMap(intToString)}")
//
//
//
//  // example p148
//  def mightFail1: Maybe[Int] = Full(1)
//
//  def mightFail2: Maybe[Int] = Full(2)
//
//  def mightFail3: Maybe[Int] = Empty()
//
//  val testMaybe: Maybe[Int] =
//    mightFail1 flatMap { x =>
//      mightFail2 flatMap { y =>
//        mightFail3 flatMap { z =>
//          Full(x + y + z)
//        }
//      }
//    }
//
//  println(testMaybe)
//
//  val testMaybe2: Maybe[Int] =
//    mightFail1 flatMap { x =>
//      mightFail2 flatMap { y =>
//        Full(x + y)
//      }
//    }
//
//  println(testMaybe2)
//
//  /* Summary:
//  We use map when we want to transform the value within the context to a new
//  value, while keeping the context the same. We use flatMap when we want
//  to transform the value and provide a new context.
//   */
//
//  // 5.5.4.1 Mapping lists - p150
//
//  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))
//
//  println(list.map(x => 2 * x))
//  println(list.map(x => 1 + x))
//  println(list.map(x => x / 3))
//
//
//
//
//}
