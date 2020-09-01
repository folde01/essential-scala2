package exercises.ch4modelling.s7extendedExamples.json


object json extends App {
  sealed trait Json {
    def print: String = {
      def quote(s: String): String =
        '"'.toString ++ s ++ '"'.toString
      def seqToJson(seq: SeqCell): String =
        seq match {
          case SeqCell(h, t @ SeqCell(_, _)) =>
            s"${h.print}, ${seqToJson(t)}"
          case SeqCell(h, SeqEnd) => h.print
        }
      def objectToJson(obj: ObjectCell): String =
        obj match {
          case ObjectCell(k, v, t @ ObjectCell(_, _, _)) =>
            s"${quote(k)}: ${v.print}, ${objectToJson(t)}"
          case ObjectCell(k, v, ObjectEnd) =>
            s"${quote(k)}: ${v.print}"
        }
      this match {
        case JsNumber(v) => v.toString
        case JsString(v) => quote(v)
        case JsBoolean(v) => v.toString
        case JsNull => "null"
        case s @ SeqCell(_, _) => "[" ++ seqToJson(s) ++ "]"
        case SeqEnd => "[]"
        case o @ ObjectCell(_, _, _) => "{" ++ objectToJson(o) ++ "}"
        case ObjectEnd => "{}"
      }
    }
  }
  final case class JsNumber(value: Double) extends Json
  final case class JsString(value: String) extends Json
  final case class JsBoolean(value: Boolean) extends Json
  case object JsNull extends Json
  sealed trait JsSequence extends Json
  final case class SeqCell(head: Json, tail: JsSequence) extends
    JsSequence
  case object SeqEnd extends JsSequence
  sealed trait JsObject extends Json

  final case class ObjectCell(key: String, value: Json, tail: JsObject
                             ) extends JsObject
  case object ObjectEnd extends JsObject

  val jsonTrue = JsBoolean(true)
  println("jsonTrue: " + jsonTrue.print)

  val json1 = JsNumber(1.0)
  println("json1: " + json1.print)

  val jsonFoo = JsString("foo")
  println("jsonFoo: " + jsonFoo.print)

  val jsonBar = JsString("bar")
  println("jsonBar: " + jsonBar.print)

  val jsonListEnd = SeqEnd
  println("jsonListEnd: " + jsonListEnd.print)

  val jsonPairEmpty = SeqCell(SeqEnd, SeqEnd)
  println("jsonPairEmpty: " + jsonPairEmpty.print)

  val jsonPairOneElem = SeqCell(jsonFoo, SeqEnd)
  println("jsonPairOneElem: " + jsonPairOneElem.print)

  val jsonPairOneElem2 = SeqCell(jsonBar, SeqEnd)
  println("jsonPairOneElem2: " + jsonPairOneElem2.print)

  val jsonPairTwoElem = SeqCell(jsonFoo, jsonPairOneElem2)
  println("jsonPairTwoElem: " + jsonPairTwoElem.print)

}