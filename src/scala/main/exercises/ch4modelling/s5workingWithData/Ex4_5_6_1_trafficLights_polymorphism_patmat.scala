package exercises.ch4modelling.s5workingWithData

object Ex4_5_6_1_trafficLights_polymorph {

  sealed trait TrafficLight {
    def next: TrafficLight
  }
  final case object Red extends TrafficLight {
    def next: TrafficLight = Green
  }
  final case object Green extends TrafficLight {
    def next: TrafficLight = Yellow
  }
  final case object Yellow extends TrafficLight {
    def next: TrafficLight = Red
  }
}

object Ex4_5_6_1_trafficLights_patmat {

  sealed trait TrafficLight {
    def next: TrafficLight = this match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
    }
  }
  final case object Red extends TrafficLight
  final case object Green extends TrafficLight
  final case object Yellow extends TrafficLight
}

// Ex4_5_6_1_trafficLights_patmat_outside
sealed trait TrafficLight
final case object Red extends TrafficLight
final case object Green extends TrafficLight
final case object Yellow extends TrafficLight

object USLightController {
  def next(t: TrafficLight): TrafficLight = t match {
    case Red => Green
    case Green => Yellow
    case Yellow => Red
  }
}

case class UKLightController() // does it need state?

object app extends App {
  println(USLightController.next(Red))
}
