import types.Command
import types.Zametka
import java.util.Scanner

class ZametkaScreen:ScreenCreater() {

    private val scanner = Scanner(System.`in`)

    override fun doScreen(zametka: Zametka) {
        println("Заметка ${zametka.name}")


        val commands: ArrayList<Command> = arrayListOf(
            Command("Посмотреть текст заметки",{ println(zametka.text)}),
            Command("Дополнить заметку",{
                zametka.text += scanner.nextLine()
            })
        )

        while (true) {
            commands.forEachIndexed { index, archiv -> println("${index}. ${commands[index].name}") }
            println("${commands.size}. Выйти")


            var command:Int = -1
            if (scanner.hasNextInt()) command = scanner.nextInt()
            scanner.nextLine()

            when(command){
                -1 -> println("Введите число")
                in 0 ..commands.size-1 -> commands[command].onComDo.invoke(0)
                commands.size -> break
                else -> println("Неверная команда")
            }
        }



    }
}