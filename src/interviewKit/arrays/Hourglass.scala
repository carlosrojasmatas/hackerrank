package interviewKit.arrays


object Hourglass {

  // Complete the checkMagazine function below.
  def hourglassSum(arr: Array[Array[Int]]): Int = {

    var max = -100
    for {
      i <- 0 to arr.length - 3
      j <- 0 to arr.head.length - 3
    } {
      val hourglass = arr(i)(j) + arr(i)(j + 1) + arr(i)(j + 2) +
        arr(i + 1)(j + 1) + arr(i + 2)(j) + arr(i + 2)(j + 1) + arr(i + 2)(j + 2)
      if (hourglass > max) max = hourglass
    }

    max
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    println(result)

  }
}
