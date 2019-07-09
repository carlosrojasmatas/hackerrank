package challenges.sorting

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object CountingSort {

  def countingSort(arr: Array[Int]): Array[Int] = {
    val mx = arr.max
    val c = Array.fill(mx + 1)(0)
    for {
      i <- arr
    } {
      c.update(i, c(i) + 1)
    }
    c
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for (arr_i <- 0 to n - 1) {
      arr(arr_i) = sc.nextInt();
    }
    val result = countingSort(arr);
    println(result.mkString(" "))


  }
}

object CountingSort2 {

  def countingSort(arr: Array[Int]): Array[Int] = {
    val mx = arr.max
    val c = Array.fill(mx + 1)(0)
    for {
      i <- arr
    } {
      c.update(i, c(i) + 1)
    }
    c
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    var n = sc.nextInt()
    var arr = new Array[Int](n)
    for (arr_i <- 0 to n - 1) {
      arr(arr_i) = sc.nextInt()
    }
    val result = countingSort(arr)
    for {
      i <- result.indices
      t <- 0 until result(i)
    } {
      print(i + " ")
    }


  }
}


object FullCountingSort {


  def sort(arr: List[(Int, String)], mx: Int): ArrayBuffer[StringBuilder] = {
    val c = ArrayBuffer.fill(mx + 1)(new StringBuilder())

    def fill(curr: ArrayBuffer[StringBuilder], rem: List[(Int, String)]): ArrayBuffer[StringBuilder] = {
      if (rem.isEmpty) curr
      else {
        val (i, el) = rem.head
        curr(i) = curr(i).append(el)
        fill(curr, rem.tail)
      }
    }

    val init = System.currentTimeMillis();
    val r = fill(c, arr)
    println(s"Processing time: ${System.currentTimeMillis() - init} ")
    r
  }

  def main(args: Array[String]) {

    import java.io.{BufferedReader, InputStreamReader}

    val in = new BufferedReader(new InputStreamReader(System.in))
    val n = in.readLine().trim.toInt

    val a = ListBuffer.empty[(Int,String)]
    val h = n / 2
    var max = 0
    val init = System.currentTimeMillis()

    for (nItr <- 1 to n) {
      val xs = in.readLine.split(" ")
      val x = xs(0).trim.toInt
      if(x > max) max = x
      val s = if(nItr <= h) "- " else xs(1) + " "

      a.append((x,s))

    }
    println(s"Reading time:${System.currentTimeMillis() - init}")
    sort(a.toList, max).foreach(print)

  }


}