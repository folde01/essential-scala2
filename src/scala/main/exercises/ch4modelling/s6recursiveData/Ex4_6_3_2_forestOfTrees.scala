package exercises.ch4modelling.s6recursiveData

import exercises.ch4modelling.s6recursiveData.patmatTree.{Leaf, Node}

object patmatTree extends App {
  sealed trait Tree {
    def sum: Int = this match {
      case Leaf(el) => el
      case Node(l, r) => l.sum + r.sum
    }
    def double: Tree = this match {
      case Leaf(el) => Leaf(2*el)
      case Node(l, r) => Node(l.double, r.double)
    }
  }
  final case class Node(left: Tree, right: Tree) extends Tree
  final case class Leaf(element: Int) extends Tree

  assert(Leaf(1).sum == 1)
  assert(Node(Leaf(1), Leaf(2)).sum == 3)
  assert(Node(Leaf(1), Node(Leaf(1), Leaf(2))).sum == 4)
  assert(Node(Node(Leaf(1), Node(Leaf(1), Leaf(2))),  Node(Leaf(1), Leaf(2))).sum == 7)

  assert(Leaf(1).double == Leaf(2))
  assert(Node(Leaf(1), Leaf(2)).double == Node(Leaf(2), Leaf(4)))
  assert(Node(Leaf(1), Node(Leaf(1), Leaf(2))).double == Node(Leaf(2), Node(Leaf(2), Leaf(4))))

}



object polymorphismTree extends App {
  sealed trait Tree {
    def sum: Int
    def double: Tree
  }
  final case class Node(left: Tree, right: Tree) extends Tree {
    def sum: Int = left.sum + right.sum
    def double: Tree = Node(left.double, right.double)
  }
  final case class Leaf(element: Int) extends Tree {
    def sum: Int = element
    def double: Tree = Leaf(2*element)
  }

  assert(Leaf(1).sum == 1)
  assert(Node(Leaf(1), Leaf(2)).sum == 3)
  assert(Node(Leaf(1), Node(Leaf(1), Leaf(2))).sum == 4)
  assert(Node(Node(Leaf(1), Node(Leaf(1), Leaf(2))),  Node(Leaf(1), Leaf(2))).sum == 7)

  assert(Leaf(1).double == Leaf(2))
  assert(Node(Leaf(1), Leaf(2)).double == Node(Leaf(2), Leaf(4)))
  assert(Node(Leaf(1), Node(Leaf(1), Leaf(2))).double == Node(Leaf(2), Node(Leaf(2), Leaf(4))))
}

