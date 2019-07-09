package challenges

object MiniMaxSum {

  /*
     * Complete the miniMaxSum function below.
     */
  def miniMaxSum(arr: Array[Long]): (Long, Long) = {
    val s = arr.sorted
    (s.take(4).sum, s.drop(1).sum)
  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn

    val arr = scan.readLine.split(" ").map(_.trim.toLong)
    val (min, max) = miniMaxSum(arr)
    println(s"$min $max")
  }


}
