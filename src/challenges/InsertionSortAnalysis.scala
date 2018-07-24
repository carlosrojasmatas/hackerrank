package challenges

import java.io.{BufferedReader, InputStreamReader}

import scala.collection.mutable.ArrayBuffer

object InsertionSortAnalysis {

  def getSum(bit: Array[Int], i: Int): Int = {
    var idx = i
    var sum = 0
    while (idx > 0) {

      sum = sum + bit(idx)
      idx = idx - (idx & -idx)
    }
    sum
  }


  def updateBit(bit: Array[Int], i: Int, am: Int): Array[Int] = {
    var idx = i
    val n = bit.length
    while (idx < n) {
      val nv = bit(idx) + am
      bit(idx) = nv
      idx = idx + (idx & -idx)
    }
    bit
  }

  def sortedIndex(arr: Array[Int]): Array[Int] = {
    val s = arr.sorted
    for {
      el <- arr
    } yield {
      val i = bSearch(s,el)
      i + 1
    }
  }

  def bSearch(arr:Array[Int], el:Int):Int = {

    def loop(start:Int,end:Int):Int = {
      if(start == end){

        if (arr(start) == el) start else -1

      } else {

        val m = start + ((end - start) / 2)
        if(el == arr(m)) m
        else if(el < arr(m)) loop(start,m)
        else loop(m + 1,end)

      }
    }

    loop(0,arr.length - 1)
  }

  def countInversions(arr: Array[Int]): Long = {
    var inv = 0L
    val sIdx = sortedIndex(arr)
    var bit = Array.fill(sIdx.length + 1)(0)
    for {
      i <- sIdx.length - 1 to 0 by -1
    } {
      val el = sIdx(i)
      val s = getSum(bit, el - 1)
      inv = inv + s
      bit = updateBit(bit, el, 1)
    }
    inv
  }

  def mergeSort(arr: Array[Int]): Long = {
    var nrOfSwaps = 0L

    def partition(start: Int, end: Int): Unit = {
      if (start < end) {
        val mid = start + (end - start) / 2
        partition(start, mid)
        partition(mid + 1, end)
        merge(start, end, mid)
      }
    }

    def merge(l: Int, r: Int, mid: Int): Unit = {
      val buffer = arr.clone()

      for {
        i <- l to r
      } {
        buffer(i) = arr(i)
      }

      var i = l
      var j = mid + 1
      var curr = l

      while (i <= mid && j <= r) {
        val lel = buffer(i)
        val rel = buffer(j)

        if (lel > rel) {
          arr(curr) = rel
          j = j + 1
          nrOfSwaps = nrOfSwaps + ((mid + 1) - i)
        } else {
          arr(curr) = lel
          i = i + 1
        }
        curr = curr + 1
      }

      for {
        k <- 0 to mid - i
      } {
        arr(curr + k) = buffer(i + k)
      }
    }

    partition(0, arr.length - 1)
    nrOfSwaps

  }


  def sortAndCount(arr: ArrayBuffer[Int]): Long = {
    var shifts = 0L
    for {
      i <- 1 until arr.length
      j <- i - 1 to 0 by -1
      if arr(j + 1) < arr(j)
    } {
      val r = arr(j + 1)
      val l = arr(j)

      if (r < l) {
        val b = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = b
        shifts = shifts + 1
      }
    }

    shifts
  }


  def main(args: Array[String]): Unit = {
    val in = new BufferedReader(new InputStreamReader(System.in))

    val t = in.readLine.trim.toInt
    val rs = ArrayBuffer.empty[Long]
    for (tItr <- 1 to t) {
      val n = in.readLine.trim.toInt

      val arr = in.readLine.split(" ").map(_.toInt)
      println("Counting inversions")
      val init = System.currentTimeMillis()
      val result = countInversions(arr)
      println(s"Total time: ${System.currentTimeMillis()-init}")
      rs.append(result)
    }
    rs.foreach(println)


  }

}
