package exercises.ch4modelling.s4sumType

final case class BottledWater(size: Int, source: Source, carbonated: Boolean )

sealed trait Source
final case object Well extends Source
final case object Spring extends Source
final case object Tap extends Source

