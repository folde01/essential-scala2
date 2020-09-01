package examples.ch4modelling.s6recursiveData

import scala.annotation.tailrec

// Recursive Algebraic Data Types Pattern

sealed trait RecursiveExample
final case class RecursiveCase(recursion: RecursiveExample)
  extends RecursiveExample
case object BaseCase extends RecursiveExample

// example:

sealed trait IntList
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

object foo extends App {
  val d = End
  val c = Pair(3, d)
  val b = Pair(2, c)
  val a = Pair(1, b)

  val example: Pair = Pair(1, Pair(2, Pair(3, End) ))
  println("tests...")
  assert(sum(example) == 6)
  assert(sum(example.tail) == 5)
  assert(sum(End) == 0)
  assert(sumTR(example, 0) == 6)
  assert(sumTR(example.tail, 0) == 5)
  assert(sumTR(End, 0) == 0)
  println("done")
  println

  println("val example: Pair = Pair(1, Pair(2, Pair(3, End) ))")
  println("sumTR2(example, 0)...\n")
  sumTR2(example, 0)

  // @tailrec
  def sum(list: IntList): Int = list match {
    case End => 0
    case Pair(head, tail) => head + sum(tail)
  }

  def sum2(list: IntList): Int = list match {
    case End => 0
    case Pair(head, tail) => head + sum2(tail)
  }

  @tailrec
  def sumTR(list: IntList, total: Int): Int = list match {
    case End => total
    case Pair(head, tail) => sumTR(tail, head + total)
  }

  @tailrec
  def sumTR2(list: IntList, total: Int): Int = list match {
    case End => {
      println("total: " + total)
      total
    }
    case Pair(head, tail) => {
      println("head: " + head)
      println("tail: " + tail)
      sumTR2(tail, head + total)
    }
  }
}
//val example: Pair = Pair(1, Pair(2, Pair(3, End) ))
