import org.scalatest.flatspec.AnyFlatSpec
import main.exercises.ch5sequences.S4ModellingWithGenericTypes.Pair
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class PairSpec extends AnyFlatSpec {
  "foo" should "do bar" in {

    val pair = Pair[String, Int]("hi", 2)
    assert(pair.one == "hi")
    assert(pair.two == 2)
  }
}
