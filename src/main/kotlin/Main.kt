import types.Archiv
import types.OriginOfArchivAndZametka
import types.Zametka
import java.util.Scanner

  val archivs: ArrayList<Archiv> = ArrayList()
  val archivScreen = ArchivScreen()
  val zametkaScreen = ZametkaScreen()
  val firstScreen = FirstScreen()

fun main(args: Array<String>) {

    firstScreen.doScreen()

}
