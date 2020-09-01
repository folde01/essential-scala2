package exercises.ch5sequences


object Examples extends App {

  sealed trait IntList {

//    object add1 {
//      def apply(n: Int): Int = n + 1
//    }
//
//    println(s"add1(2): ${add1(2)}")
//
//    val hi = () => "hi!"
//    println(hi)
//    println(hi())
//
//    val addd1 = (x: Int) => x + 1
//    println(add1(3))
//
//    val summm = (x: Int, y: Int) => (x + y): Int
//    println(summm(3, 4))
//



    def sum: Int = this match {
      case End => 0
      case Pair(hd, tl) => hd + tl.sum
    }

    def sumFold: Int = fold(0, (x: Int, y: Int) => x + y)

    def fold(end: Int, f: (Int, Int) => Int): Int = this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

    def foldGeneric[A](end: A, f: (Int, A) => A): A = this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.foldGeneric(end, f))
    }

    def double: IntList =
      this match {
        case End => End
        case Pair(hd, tl) => Pair(hd * 2, tl.double)
      }

    // case Pair(hd, tl) => f(hd, tl.foldGeneric(end, f))
    //                      (hd, tl.foldGeneric(end, f)) => 2 * hd
    def doubleFold: IntList = foldGeneric(End, (hd: Int, tl: IntList) => Pair(2 * hd, tl))

    def productFold: Int = fold(1, (hd, tailProduct) => hd * tailProduct)

    def product: Int =
      this match {
        case End => 1
        case Pair(hd, tl) => hd * tl.product
      }

    def lengthFold: Int = fold(0, (_, tailLength) => 1 + tailLength)

    def length: Int =
      this match {
        case End => 0
        case Pair(_, tl) => 1 + tl.length
      }
  }

  // part 3: if e.g. length were rather in Pair and End, then lengthFold should refer to this.fold, with fold remaining in the trait? I think therefore better to use pattern matching.

  case object End extends IntList

  case class Pair(hd: Int, tl: IntList) extends IntList

  val two: Pair = Pair(2, End)
  val oneTwo: Pair = Pair(1, two)
  val oneTwoThree: Pair = Pair(1, Pair(2, Pair(3, End)))

  println("assert(two.sum == 1)")
  assert(two.sum == 2)
  println("assert(two.sumFold == 1)")
  assert(two.sumFold == 2)

  println("assert(End.length == 0)")
  assert(End.length == 0)
  println("assert(two.length == 1)")
  assert(two.length == 1)
  println("assert(oneTwo.length == 2)")
  assert(oneTwo.length == 2)

  println("assert(End.lengthFold == 0)")
  assert(End.lengthFold == 0)
  println("assert(two.lengthFold == 1)")
  assert(two.lengthFold == 1)
  println("assert(oneTwo.lengthFold == 2)")
  assert(oneTwo.lengthFold == 2)

  println("assert(End.product == 1)")
  assert(End.product == 1)
  println("assert(two.product == 2)")
  assert(two.product == 2)
  println("assert(oneTwo.product == 2)")
  assert(oneTwo.product == 2)
  println("assert(oneTwoThree.product == 6)")
  assert(oneTwoThree.product == 6)

  println("assert(End.productFold == 1)")
  assert(End.productFold == 1)
  println("assert(two.productFold == 2)")
  assert(two.productFold == 2)
  println("assert(oneTwo.productFold == 2)")
  assert(oneTwo.productFold == 2)
  println("assert(oneTwoThree.productFold == 6)")
  assert(oneTwoThree.productFold == 6)

  println("assert(End.double == End)")
  assert(End.double == End)
  println("assert(two.double == Pair(4, End))")
  assert(two.double == Pair(4, End))
  println("assert(oneTwo.double == Pair(2, Pair(4, End)))")
  assert(oneTwo.double == Pair(2, Pair(4, End)))

  println("assert(End.doubleFold == End)")
  assert(End.doubleFold == End)
  println("assert(two.doubleFold == Pair(4, End))")
  assert(two.doubleFold == Pair(4, End))
  println("assert(oneTwo.doubleFold == Pair(2, Pair(4, End)))")
  println(s"oneTwo.doubleFold: ${oneTwo.doubleFold}")
  assert(oneTwo.doubleFold == Pair(2, Pair(4, End)))



}



