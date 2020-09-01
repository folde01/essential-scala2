package exercises.ch4modelling.s4sumType

sealed trait Color {
  def next: Color
}

final object Red extends Color {
  val next = Green
}
final object Yellow extends Color {
  val next = Red
}
final object Green extends Color {
  val next = Yellow
}

object ex4_4_4_1_stopOnADime extends App {

}


