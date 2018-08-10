package challenges.sorting

object BigSorting {

  private class BigNumberComparator extends Ordering[String]  {
    override def compare(x: String, y: String): Int = {
      if(x.length != y.length) x.length compareTo(y.length)
      else{
        BigInt(x).compare(BigInt(y))
      }
    }
  }

  def selectionSorter(toSort: Array[BigInt]) {

    def swap(l: Int, r: Int) = {
      val lel = toSort(l)
      val rel = toSort(r)
      toSort.update(r, lel)
      toSort.update(l, rel)
    }

    for (i <- 0 to toSort.length - 2) {
      var min = i + 1

      for (j <- i + 1 until toSort.length) {
        if (toSort(j) < toSort(min)) {
          min = j
        }
      }
      swap(i, min)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine().toInt
    val unsorted = Array.ofDim[String](n)

    for (unsortedItr <- 0 until n) {
      val unsortedItem = stdin.readLine
      unsorted(unsortedItr) = unsortedItem
    }

    unsorted.sorted(new BigNumberComparator).foreach(n => println(n))
  }

}
