import org.w3c.dom.html.HTMLButtonElement

/*
sealed trait Music

sealed trait Melody extends Music
final case class MelodyCell(head: MusicAction, tail: Melody) extends Melody
final case object MelodyEnd extends Melody

sealed trait MusicAction extends Music {
  def duration: Duration

  def bar: Int
}

final case class Note(
                       tone: Tone,
                       octave: Octave,
                       duration: Duration,
                       key: Key,
                       bar: Int,
                       accidental: Accidental
                     ) extends MusicAction

final case class Rest(
                       duration: Duration,
                       bar: Int
                     ) extends MusicAction


sealed trait ActionElement

sealed trait Duration extends ActionElement {
  def baseDuration: BaseDuration

  def isDotted: Boolean

  sealed trait BaseDuration {
    def value: Double
  }

  case object Whole extends BaseDuration {
    val value = 1
  }

  case object Half extends BaseDuration {
    val value = 1 / 2
  }

  case object Quarter extends BaseDuration {
    val value = 1 / 4
  }

}

sealed trait NoteElement extends ActionElement

sealed trait Tone extends NoteElement {
  def letter: Char

  def octave4Frequency: Double

  def octave4Wavelength: Double
}

final case class Octave(value: Int) extends NoteElement

final case class Key(value: String,
                    signature: KeySignature
                    ) extends NoteElement

sealed trait Accidental extends NoteElement




// static object created in memory at app launch. GC ignores.
case object C extends Tone {
  val letter = 'C'
  val octave4Frequency = 261.63
  val octave4Wavelength = 131.87
}


def foo(tone: Tone): String = {
  tone match {
        case C => "cccc"
        case D(_,_,_) => "dddd"
      }
}


// GC'd. Instantiable. Pattern matchable. Use of lots of instances.
case class D(
              letter: Char = 'D',
              octave4Frequency: Double = 293.66,
              octave4Wavelength: Double = 117.48
            ) extends Tone
// case object Dsharp extends D

case class E() extends Tone {
  def letter = 'E'

  def octave4Frequency = 1235

  def octave4Wavelength = 1222

}

case object Flat extends Accidental

case object Sharp extends Accidental

case object Natural extends Accidental

sealed trait KeySignature
final case class KeySignatureCell(
                                 head: Accidental,
                                 tail: KeySignature
                                 )
case object KeySignatureEnd


/* Todo:
sealed trait Octave4Frequencies
sealed trait Octave4Wavelengths
 */


 */