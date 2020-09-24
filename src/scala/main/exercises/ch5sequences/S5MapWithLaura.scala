//package main.exercises.ch5sequences
//
//object S5MapWithLaura extends App {
//
//  sealed trait LinkedList[A] {
//    def map[B](fn: A => B): LinkedList[B] = this match {
//      case End() => End[B]()
//      //case Pair(hdA, tlA) => // Pair[B] has hdB tlB... fn(hd) is a B! ... tlA.map(fn)
//      case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
//    }
//  }
//  final case class Pair[A](hd: A, tl: LinkedList[A]) extends LinkedList[A]
//  final case class End[A]() extends LinkedList[A]
//
//  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))
//
//  println(list)
//
//  // def doublingMethod(n: Int): Int = n * 2
//  def doublingFunction: Int => Int = { n => 2 * n }
//
//  println(list.map(doublingFunction))
//
//}
