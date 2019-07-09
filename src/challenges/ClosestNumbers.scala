package challenges
import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.ArrayBuffer
object ClosestNumbers {




  def closestNumbers(arr:Array[Long]):Array[Long] = {
    def loop(rem:Array[Long],curr:Array[Long],currMin:Long):Array[Long] = {
      if(rem.length == 1)curr
      else{
        val (a,b) = (rem.head,rem.tail.head)
        val currDif = b-a

        if(currDif < currMin)loop(rem.tail,Array(a,b),currDif)
        else if(currDif == currMin) loop(rem.tail,curr ++ Array(a,b),currDif)
        else loop(rem.tail,curr,currMin)
      }
    }
    loop(arr.sorted,Array.empty,Long.MaxValue)
  }

  def closestNumbers2(arr:Array[Long]):Array[Long] = {
    var i = 0
    var currMin = Long.MaxValue
    val curr = ArrayBuffer.empty[Long]
    while(i < arr.length - 2){
      val(a,b) = (arr(i),arr(i+1))
      val currDif= b-a
      if(currDif < currMin) {
        curr.clear()
        curr.append(a,b)
        currMin = currDif
      } else if(currDif == currMin) {
        curr.append(a,b)
      }
      i = i + 1
    }
    curr.toArray
  }


  def main(args: Array[String]) {
    val in = new BufferedReader(new InputStreamReader(System.in))
    val n = in.readLine().trim.toInt


    val arr = in.readLine.split(" ").map(_.trim.toLong)
    val result = closestNumbers2(arr.sorted)

    println(result.mkString(" "))

  }
}
