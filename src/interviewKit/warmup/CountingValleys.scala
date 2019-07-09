package interviewKit.warmup

object CountingValleys {


  def countingValleys2(n: Int, s: String): Int = {

    def walk(level:Int, dow:Int, path:String):Int = {
      if(path.isEmpty) dow
      else{
        val step = path.head
        step match {
          case 'U' if level == -1 =>
            walk(level + 1,dow + 1, path.tail)
          case 'U' =>
            walk(level + 1,dow, path.tail)
          case 'D' =>
            walk(level - 1,dow, path.tail)
        }
      }
    }

    walk(0,0,s)
  }

  def countingValleys(n: Int, s: String): Int = {

    var level = 0
    var dow = 0;
    val it = s.iterator

    while(it.hasNext){
      val step = it.next()
      step match {
        case 'U' if level == -1 =>
          level = level + 1
          dow = dow + 1
        case 'U' =>
          level = level + 1
        case 'D' =>
          level = level - 1
      }

    }
    dow
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = countingValleys(n, s)

    println(result)

  }


}
