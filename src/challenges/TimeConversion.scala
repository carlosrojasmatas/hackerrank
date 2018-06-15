package challenges

object TimeConversion {

  case class Time(h: String, m: String, s: String, ampm: String) {
    override def toString: String = s"$h:$m:$s$ampm"

    def toMilitary: String = {
      if (ampm == "AM") {
        if (h == "12") {
          s"00:$m:$s"
        } else {
          s"$h:$m:$s"
        }
      } else {
        if(h == "12"){
          s"$h:$m:$s"
        }else{
          s"${h.toInt + 12}:$m:$s"
        }
      }
    }
  }

  private def fromString(st: String): Time = {
    val asArray = st.split(":")
    val h = asArray.head
    val m = asArray.tail.head
    val s = asArray.last.take(2)
    val a = asArray.last.drop(2)
    Time(h, m, s, a)
  }

  def timeConversion(s: String): String = {
    fromString(s).toMilitary
  }

  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn
    val t = scan.readLine()
    println(timeConversion(t))
  }
}
