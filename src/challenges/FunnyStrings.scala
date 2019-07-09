package challenges

/**
  * Created by carlosrojasmatas on 9/5/16.
  */
object FunnyStrings {


  def main(args: Array[String]): Unit = {


    val sc = new java.util.Scanner(System.in);
    val t = sc.nextInt();
    var rs = List.empty[Boolean]
    var a0 = 0
    while (a0 < t) {
      val s = sc.next()
      val r = s.reverse

      val l = s.length

      val f = for {
        i <- l - 1 to 1 by -1
      } yield {
        Math.abs(s(i).toInt - s(i - 1).toInt) == Math.abs(r(i).toInt - r(i - 1).toInt)
      }

      rs  = !f.exists(_ == false) :: rs

      a0 += 1
    }

    rs.reverse.foreach(r => if(r) println("Funny") else println("Not Funny"))
  }

}
