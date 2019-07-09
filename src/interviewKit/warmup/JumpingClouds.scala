package interviewKit.warmup

object JumpingClouds {


  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int]): Int = {

    var i = 0
    var steps = 0

    while (i < c.size - 1) {
      if (i == c.size - 2) {
        val optOne = c(i + 1)
        i = i + 1
      } else {
        val optOne = c(i + 1)
        val optTwo = c(i + 2)
        if (optTwo == 0) {
          i = i + 2
        } else {
          i = i + 1

        }

      }
      steps = steps + 1
    }

    steps
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    println(result)
  }


}
