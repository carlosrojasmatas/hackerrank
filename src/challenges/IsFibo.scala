package challenges

/**
  * Created by carlosrojasmatas on 10/18/16.
  */
object IsFibo {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    val tc = sc.nextInt()
    var rs = Array.empty[String]

    for {
       i <- 1 to tc
    }{
      val nr = BigInt(sc.next())

      if(isFibo(nr)) rs= rs :+ "IsFibo"
      else rs = rs :+ "IsNotFibo"
    }

    rs.foreach(println _)

  }



  def isFibo(n:BigInt):Boolean = {
    isPerfectSquare(5*Math.pow(n.doubleValue(),2) + 4 )  || isPerfectSquare(5*Math.pow(n.doubleValue(),2) - 4)
  }

  def isPerfectSquare(n:Double):Boolean = Math.sqrt(n.doubleValue()).isWhole()
}
