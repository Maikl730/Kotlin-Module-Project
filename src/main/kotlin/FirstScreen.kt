
import types.Archiv
import java.util.Scanner


class FirstScreen:ScreenCreater() {

companion object{
    const val WELCOME = "Ваши заметки"
    const val SPISOKOF = "Список архивов"
    const val CREATE = "архив"
    const val BYE = "Приложение закрыто"
}

    override fun doScreen() {
        println(WELCOME)

        doCommands(
            welcome = SPISOKOF,
            whatCreate = CREATE,
            list = archivs,
            onListDo = { command -> archivScreen.doScreen(archivs[command - 1]) },
            onCreateNew = { createArchiv(archivs) }
        )

        println(BYE)
    }
}