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

ASSOCIATIVITY:

https://stackoverflow.com/a/25589282

http://web.deu.edu.tr/doc/oreily/java/langref/ch04_14.htm


The associativity of an operator (e.g. addition or substraction) refers to whether you work left-to-right (aka 'left-associative') or right-to-left ('right-associative').

+, -, * and / are all left-associative, so ...

5 + 10 + 15
(5 + 10) + 15
15 + 15
30

5 - 10 - 15
(5 - 10) - 15
-5 - 15
-20

5 * 10 * 15
50 * 15
75

5 / 10 / 15
(5 / 10) / 15
(1/2) / 15
1/30

= (aka 'the assignment operator') is right-associative ...

var a = 3
var b = 4
a = b = 5

So what is the value of a in this case? Because the assignment operator is right-associative, the scala compiler solves it in this order:

var a = 3
var b = 4
a = b = 5

a = (b = 5)
a = (4)


What would the value of a be if we lived in a world where the assignment operator was left associative?

var a = 3
var b = 4
a = b = 5

(a = b) = 5
3 = 5
:(


FOLDLEFT VS FOLDRIGHT:



https://stackoverflow.com/questions/6253978/difference-between-fold-and-foldleft-or-foldright/6255094#6255094

foldRight is right-associative, meaning we work right-to-left. I.e. elements will be accumulated in right-to-left order:

List(a,b,c).foldRight(z)(f) = f(a, f(b, f(c, z)))

foldLeft is left-associative, meaning we work left-to-right. I.e. an accumulator will be initialized and elements will be added to the accumulator in left-to-right order:

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



