
import types.Archiv

class ArchivScreen():ScreenCreater() {

    companion object {
        const val WELCOME = "Архив"
        const val SPISOKOF = "Список заметок"
        const val CREATE = "заметку"
        const val BYE = "Выходим из Архива"
    }
    override fun doScreen(archiv: Archiv) {
        println("$WELCOME ${archiv.name}")

        doCommands(
            welcome = SPISOKOF,
            whatCreate = CREATE,
            list = archiv.zametki,
            onListDo = {command -> zametkaScreen.doScreen(archiv.zametki[command-1])},
            onCreateNew = {createZametka(archiv.zametki)}
        )

        println(BYE)
    }
}