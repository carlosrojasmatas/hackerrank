package challenges.sorting

import scala.collection.mutable

object HackerLand {

  // Complete the activityNotifications function below.
  def activityNotifications(expenditure: Array[Int], d: Int): Int = {
    val feqArray = Array.fill(201)(0)


    def updateFrequencies(out:Int,in:Int) = {
      feqArray(out) = feqArray(out) - 1
      feqArray(in) = feqArray(in) + 1
    }

    def sort(array:Array[Int]):Array[Int] =
      feqArray.indices.flatMap(s => Array.fill(feqArray(s))(s)).toArray

    def median(arr: Array[Int]): Double = {

      val l = arr.length
      if (l % 2 == 0) {
        val m2 = l / 2
        val m1 = m2 - 1
        m1 + m2 / 2
      } else {
        arr(arr.length / 2)
      }

    }

    def trailingLoop(windowExp: Array[Int], remaining:Array[Int],not: Int): Int = {
      println(remaining.length)
      if (remaining.length <= 0 ) not
      else {
        val m = median(sort(windowExp))
        val out = windowExp.head
        val in = remaining.head
        updateFrequencies(out,in)
        val nRemaining = remaining.tail
        trailingLoop(windowExp.tail :+ in,nRemaining,if(in >= m * 2) not + 1 else not)
      }

    }

    var expenditures = expenditure.take(d)
    var remainingQ = new mutable.Queue[Int]
    expenditure.drop(d).foreach(remainingQ += _)
    expenditures.foreach(i => feqArray(i) = feqArray(i) + 1)
    var not = 0
    while(!remainingQ.isEmpty){
      val m = median(sort(expenditures))
      val out = expenditures.head
      val in = remainingQ.dequeue()
      if(in >= m * 2) not = not + 1
      else{
        println(s"$in - $m - ${m*2}")
      }
      updateFrequencies(out,in)
      expenditures = expenditures.tail :+ in
    }
    //roll the thing
//    trailingLoop(init,expenditure.drop(d),None,0)
    not
  }



  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nd = stdin.readLine.split(" ")
    val n = nd(0).trim.toInt
    val d = nd(1).trim.toInt

    val expenditure = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = activityNotifications(expenditure, d)

    println(result)

  }


}
