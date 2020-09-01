package exercises.ch5sequences


object S3GenericFolds extends App {
  println("ff")


  //  def fold[A](end: A, f: (Int, A) => A): A =
  //    this match {
  //      case End => end
  //      case Pair(hd, tl) => f(hd, tl.fold(end, f))
  //    }

  sealed trait LinkedList[A] {
    def fold[B](end: B, f: (A, B) => B): B = this match {
      case End() => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
  }

  final case class Pair[A](head: A, tail: LinkedList[A]) extends
    LinkedList[A]

  final case class End[A]() extends LinkedList[A]

  val s: LinkedList[String] = Pair[String]("jo", Pair("al", Pair("ed", End())))

  println(s"fold1: ${s.fold(true, (a: String, b: Any) => a + b)}") // joaledtrue

  //

  sealed trait Tree[A] {
//    def fold[B](leaf: A => B, node: (B, B) => B): B

    def fold[B](leaf: A => B)(node: (B,B) => B): B = this match {
        case Leaf(v: A) => leaf(v)
        case Node(l, r) => node(l.fold(leaf)(node), r.fold(leaf)(node))
      }
  }

  final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
//    def fold[B](leaf: A => B, node: (B, B) => B): B =
//      node(left.fold(leaf, node), right.fold(leaf, node))
  }

  final case class Leaf[A](elem: A) extends Tree[A] {
//    def fold[B](leaf: A => B, node: (B, B) => B): B = leaf(elem)
  }

  val tree: Tree[String] =
    Node(Node(Leaf("To"), Leaf("iterate")),
      Node(Node(Leaf("is"), Leaf("human,")),
        Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))


  def leaf: String => String = v => v
  def node: (String, String) => String = (l, r) => l + " " + r

  println(s"tree.............. ${tree.fold(leaf)(node)}")

//  def leaf2: String => Int = v => v.length
//  def node2: (String, String) => Int = (l, r) => l.length + r.length
//
//  println(s"tree.............. ${tree.fold(leaf2)(node2)}")

//  val tree2: Tree[String] = Leaf[String]("a")
//
//  println(s"tree2: ${tree2.fold[String]((str) => str, (a, b) => a)}")
//
//  val tree3: Tree[String] = Node(tree2, tree2)
//
//  println(s"tree3: ${tree3.fold[String]((s) => s, (a, b) => a + " " + b)}")
//
//  println(s"tree: ${tree.fold[String]((s) => s, (a, b) => a + " " + b)}")
//
//  val tree4: Tree[Int] = Leaf(1)
//
//  println(s"tree4: ${tree4.fold[Int]((n) => n, (a, b) => a + b)}")
//
//  val tree5: Tree[Int] = Node(tree4, tree4)
//
//  println(s"tree5: ${tree5.fold[Int]((n) => n, (a, b) => a + b)}")




}
