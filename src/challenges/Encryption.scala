package challenges

import scala.collection.mutable.ListBuffer

/**
  * Created by carlosrojasmatas on 8/30/16.
  */
object Encryption {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    val s = sc.next();
    val l = s.size
    val sqr = Math.sqrt(l)
    val fl = Math.floor(sqr).toInt
    val ce = Math.ceil(sqr).toInt

    val candidates = for{
      r <- fl to ce
      c <- fl to ce
      if( fl <= r && r <= c && c <= ce && (r * c) >= l)
    } yield {
      (r,c)
    }


    val sel = candidates.map(rc => (rc._1,rc._2, rc._1 * rc._2) ).minBy(m => m._3)

    def loadMatrix(left:String,curr:List[String]):List[String] = {
      if(left.isEmpty) curr
      else loadMatrix(left.drop(sel._2),curr ++ List(left.take(sel._2)))
    }

    val mat = loadMatrix(s,List.empty)

    var list = for{
      j <- 0 to sel._2
    } yield {
      ""
    }

    val res =for{
      i <- 0 to sel._1 - 1
      j <- 0 to sel._2 - 1
    } {
        if(mat(i).size > j )
          list = list.updated(j,list(j) + mat(i)(j))
    }

    println(list.mkString(" "))
  }

}
