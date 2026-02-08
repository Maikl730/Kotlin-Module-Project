package types

class Command(val name:String, val onComDo:(command:Int)->Unit) {
}