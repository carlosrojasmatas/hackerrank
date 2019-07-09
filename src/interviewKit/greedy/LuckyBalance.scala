package interviewKit.greedy

object LuckyBalance {

  def luckBalance(k: Int, contests: Array[Array[Int]]): Int = {

    var loses = k
    var tot = 0

    for{
      c <- contests.sortWith((a,b) => a(0) > b(0))
    }{
      val (score,importance) = (c(0),c(1))
      if(importance == 0)
        tot = tot + score
      else{

        if(loses == 0)
          tot = tot - score
        else{
          tot = tot + score
          loses = loses - 1
        }

      }
    }

    tot


  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val contests = Array.ofDim[Int](n, 2)

    for (i <- 0 until n) {
      contests(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = luckBalance(k, contests)

    println(result)

  }

}
