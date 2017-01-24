package challenges

/**
  * Created by carlosrojasmatas on 10/14/16.
  */
object FindDigits {


  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    val tc = sc.nextInt()
    var rs = Array.empty[Int]

    for{
      t <- 1 to tc
    }{
      val n = sc.next()
      rs = rs :+ (n.toString.map( _.toString.toInt)
        .count(d => d != 0 && n.toInt % d == 0 ))
    }

    rs.foreach(println _)

  }
}
