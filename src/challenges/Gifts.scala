package challenges

import scala.collection.mutable.ListBuffer

/**
  * Created by carlosrojasmatas on 8/17/16.
  */
object Gifts {


  def main(args: Array[String]) {

    def computeCost(b:Long,w:Long,x:Long,y:Long):Long =  {
      b * x + w * y
    }

    val sc = new java.util.Scanner (System.in);
    val t = sc.nextInt();
    var a0 = 0;
    val rs:scala.collection.mutable.ListBuffer[Long]= ListBuffer.empty
    while(a0 < t){
      var b = sc.nextLong();
      var w = sc.nextLong();
      var x = sc.nextLong();
      var y = sc.nextLong();
      var z = sc.nextLong();
      a0+=1;

      val c1 = computeCost(b,w,x,y)
      val c2 = computeCost(b,w,x,x + z)
      val c3 = computeCost(b,w,y+z,y)

      rs += List(c1,c2,c3).min
    }

    rs.foreach(println _)
  }
}
