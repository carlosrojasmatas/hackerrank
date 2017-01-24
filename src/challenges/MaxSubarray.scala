package challenges

import java.util.Scanner

/**
  * Created by carlosrojasmatas on 10/18/16.
  */
object MaxSubarray {


  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    sc.useDelimiter(System.getProperty("line.separator"))

    var rs = Array.empty[(Int,Int)]
    val tc = sc.next().trim.toInt


    for{
      t <- 1 to tc
    } {
      val disc = sc.next()
      val nc = sc.next()
      val nrs = nc.split(' ').map(_.trim.toInt).toList
      rs = rs :+ (maxContSubArray(nrs),findNotContSubArray(nrs))

    }

    def findNotContSubArray(a:List[Int]):Int = {
      val positives = a.filter(_ > 0)
      if(positives.isEmpty) a.max
      else positives.sum
    }

    def maxContSubArray(a:List[Int]):Int = {
      var max_local, max_global= a.head
      var max_not_cont = 0
      for{
        x <- a.tail
      }{

        max_local = List(x,max_local + x).max
        max_global = List(max_global,max_local).max
      }

      max_global
    }



    rs.foreach(r => println(s"${r._1} ${r._2}"))
  }
}
