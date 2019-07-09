package challenges

import java.io.PrintWriter

object CakeCandles {
  /*
      * Complete the birthdayCakeCandles function below.
      */
  def birthdayCakeCandles(ar: Array[Long]): Int = {
    val max = ar.max
    val c = ar.count(_ == max)
    if(c == 0 ) 1 else c
  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn
    val i = scan.readLine()
    val arr = scan.readLine.split(" ").map(_.trim.toLong)

    val result = birthdayCakeCandles(arr)

    println(result)
  }
}
