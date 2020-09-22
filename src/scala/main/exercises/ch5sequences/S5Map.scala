package main.exercises.ch5sequences

object S5Map {

  sealed trait LinkedList[A] {
    def map[B](fn: A => B): LinkedList[B] = {
      this match {
        case End() => End()
        case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
      }
    }
  }
  final case class Pair[A](hd: A, tail: LinkedList[A]) extends LinkedList[A]
  final case class End[A]() extends LinkedList[A]
}
