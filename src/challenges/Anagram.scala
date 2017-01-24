package challenges

/**
  * Created by carlosrojasmatas on 10/14/16.
  */
object Anagram {

  def main(args: Array[String]): Unit = {

    val sc = new java.util.Scanner (System.in);
    var tc = sc.nextInt();
    var rs = Array.empty[Int]
    for{
      i <- 0 to tc -1
    }{
      val s = sc.next()
      if(s.length % 2 > 0) rs = rs :+ -1
      else
      {

        val (s1,s2) = s.splitAt(s.length / 2)
        rs = rs :+ s1.diff(s2).length

      }
    }

    rs.foreach(println _)

  }
}
