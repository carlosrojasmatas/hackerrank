package challenges


object FindTheMedian {

  import java.io.{BufferedReader, InputStreamReader}


  def findMedian(arr: Array[Int]): Int = {

    val i  = arr.length / 2
    val s = arr.sorted
    s(i)
  }

  def main(args: Array[String]) {
    val in = new BufferedReader(new InputStreamReader(System.in))

    val n = in.readLine.trim.toInt

    val arr = in.readLine.split(" ").map(_.trim.toInt)
    val result = findMedian(arr)

    println(result)

  }
}
