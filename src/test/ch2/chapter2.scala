package ch2

import org.scalatest.flatspec.AnyFlatSpec

class chapter2 extends AnyFlatSpec{
  "The function" should "return the sum of the numbers" in {
    assert(Foo.addition(4, 4) == 8)
  }
  it should "cancel the btest bc... " in {
    cancel("cant run bc")
  }
  ignore should "cancel the btest bc... " in {
    cancel("cant run bc")
  }
  val list = List(1,2,3,4)
  "the list" should "contain 4" in {
    assert(list.exists(_ === 3))
  }



  "The function" should "return an int" in {
    assert(Foo.returnANumber("6") == 6)
  }
}

object Foo {
  def addition(x: Int, y: Int): Int = ???
  def returnANumber(s: String): Int = 7
}
