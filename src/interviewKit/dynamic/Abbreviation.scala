package interviewKit.dynamic

object Abbreviation {


  // Complete the abbreviation function below.
  def abbreviation(a: String, b: String): String = {

    def rollOver(a:String,b:String):Boolean ={
      if(a.equals(b) || b.isEmpty) true
      else if(a.size < b.size) false
      else{
        val sh = a.head
        val th = b.head
        if(sh.toInt == th.toInt) rollOver(a.tail,b.tail)
        else rollOver(a.tail,b)
      }
    }


    if(rollOver(a.toUpperCase,b.toUpperCase)) "YES" else "NO"
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val a = stdin.readLine

      val b = stdin.readLine

      val result = abbreviation(a, b)

      println(result)
    }

  }
}
