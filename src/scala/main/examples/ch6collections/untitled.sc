val sequence = Seq(1, 2, 3)
sequence.apply(0)
sequence(0)
//sequence(3)
sequence.head
sequence.tail
sequence.tail.head
//Seq().head
//Seq().tail
sequence.headOption
Seq().headOption
sequence.length
sequence.contains(2)
sequence.find(_ == 3)
sequence.find(_ > 4)
sequence.filter(_ > 1)
sequence.sortWith(_ > _)
sequence.:+(4)
sequence :+ 4
sequence.+:(0)

// right associative ...
// https://stackoverflow.com/questions/930486/what-is-associativity-of-operators-and-why-is-it-important

0 +: sequence
sequence ++ Seq(4, 5, 6)
Nil
val list = 1 :: 2 :: 3 :: Nil
4 :: 5 :: list
List(1, 2, 3)
List(1, 2, 3) ::: List(4, 5, 6)
import scala.collection.immutable.Vector
Vector(1, 2, 3)
import scala.collection.immutable._
Queue(1, 2, 3)
import scala.collection.immutable.Vector.apply
apply(1, 2, 3)

val animals: Seq[String] = Seq("cat", "dog", "penguin")
"mouse" +: animals :+ "tyrannosaurus"
2 +: animals

"dog".permutations.toList
Seq("a", "wet", "dog").map(_.permutations.toList)

Seq("a", "wet", "dog").flatMap(_.permutations.toList)

Seq("a", "b", "c").permutations.toList

Seq(1, 2, 3).permutations


val x = Seq(5)
x.foldLeft(1)(_ / _)
//x.foldRight()

/*
https://stackoverflow.com/questions/6253978/difference-between-fold-and-foldleft-or-foldright/6255094#6255094

foldRight associates to the right. I.e. elements will be accumulated in right-to-left order:

List(a,b,c).foldRight(z)(f) = f(a, f(b, f(c, z)))

foldLeft associates to the left. I.e. an accumulator will be initialized and elements will be added to the accumulator in left-to-right order:

List(a,b,c).foldLeft(z)(f) = f(f(f(z, a), b), c)
 */

println("foldRight")
List(5,10,15).foldRight(100)((x,y) => x - y)
List(5,10,15).foldRight(100)(_ - _)

println("foldLeft")
List(5,10,15).foldLeft(100)((x,y) => x - y)
List(5,10,15).foldLeft(100)(_ - _)

/*

FOLDRIGHT STEPS:

List(a,b,c).foldRight(z)(f) = f(a, f(b, f(c, z)))

List(5,10,15).foldRight(100)((x, y) => x - y) = f(a, f(b, f(c, z)))
List(5,10,15).foldRight(100)(_ - _) = f(5, f(10, f(15, 100)))
List(5,10,15).foldRight(100)(_ - _) = f(5, f(10, (15 - 100)))
List(5,10,15).foldRight(100)(_ - _) = f(5, f(10, -85))
List(5,10,15).foldRight(100)(_ - _) = f(5, (10 - -85))
List(5,10,15).foldRight(100)(_ - _) = f(5, (10 + 85))
List(5,10,15).foldRight(100)(_ - _) = f(5, (10 + 85))
List(5,10,15).foldRight(100)(_ - _) = f(5, 95)
List(5,10,15).foldRight(100)(_ - _) = (5 - 90)
List(5,10,15).foldRight(100)(_ - _) = -90

*/

println("foldRight steps")
val f = (x: Int, y: Int) => x - y
f(15, 100)
f(10, f(15, 100))
f(5, f(10, f(15, 100)))

/*

FOLDLEFT STEPS:

List(a,b,c).foldLeft(z)(f) = f(f(f(z, a), b), c)

List(5,10,15).foldLeft(100)((x, y) => x - y) = (f(f(z, a), b), c)
List(5,10,15).foldLeft(100)(_ - _) = ???


 */



