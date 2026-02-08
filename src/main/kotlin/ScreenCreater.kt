import types.Archiv
import types.OriginOfArchivAndZametka
import types.Zametka
import java.util.Scanner

open class ScreenCreater {
    private val scanner = Scanner(System.`in`)

    open fun doScreen(){}
    open fun doScreen(archiv: Archiv){}
    open fun doScreen(zametka:Zametka){}


   protected fun <T: OriginOfArchivAndZametka>begining(welcome:String, create:String, list:ArrayList<T>){
        println(welcome)
        println("0. Создать $create")
        list.forEachIndexed { index, archiv -> println("${index+1}. ${list[index].name}") }
        println("${list.size + 1}. Выйти")
    }


   protected fun createArchiv(list: ArrayList<Archiv>){
        println("Введите название для архива")
        var nameOfNew:String =""
        while (true){
            nameOfNew = scanner.nextLine()
            if (nameOfNew.length>3) break
            println("Слишком короткое название")
        }

        list.add(Archiv(name = nameOfNew, ArrayList<Zametka>()))
    }

    protected fun createZametka(list: ArrayList<Zametka>){
        println("Введите название для заметки")
        var nameOfNew = ""
        var text = ""
        while (true){
            nameOfNew = scanner.nextLine()
            if (nameOfNew.length>3) break
            println("Слишком короткое название")
        }
        println("Запишите что-то в замету \"$nameOfNew\"")

        while (true){
            text = scanner.nextLine()
            if (text.length>=1) break
            println("Заметка не может оставаться пустой")
        }

        list.add(Zametka(name=nameOfNew, text=text))
    }

    protected fun <T: OriginOfArchivAndZametka>doCommands(welcome:String, whatCreate:String, list: ArrayList<T>, onListDo:(command:Int)->Unit, onCreateNew:()->Unit){

        while (true){
            begining(welcome,whatCreate,list)

            var command:Int = -1
            if (scanner.hasNextInt()) command = scanner.nextInt()
            scanner.nextLine()

            when(command){
                -1 -> println("Введите число")
                0 -> onCreateNew.invoke()
                in 1 ..list.size -> onListDo.invoke(command)
                list.size + 1 -> break
                else -> println("Неверная команда")
            }
        }
    }

}