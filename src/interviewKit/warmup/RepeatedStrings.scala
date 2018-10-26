package interviewKit.warmup

object RepeatedStrings {

  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    if(s.equals("a")) n
    else {

      //count the a's in the string
      var ais = 0L
      for (c <- s if c == 'a') ais = ais + 1

      val rem = n % s.length
      var as = (n / s.length) * ais
      var curr = 0L

      while (curr < rem) {
        for {
          c <- s if curr < rem
        } {
          curr = curr + 1
          if (c == 'a') as = as + 1
        }
      }

      as
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    println(result)

  }

}
