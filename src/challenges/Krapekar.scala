package challenges

/**
  * Created by carlosrojasmatas on 8/29/16.
  */
object Krapekar {


  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in);

    val p = sc.nextInt();
    val q = sc.nextInt();

    var rs:Array[Int] = Array.emptyIntArray

    for {
      i <- p to q
      if (isK(i,decompose(i * i.toLong)))
    } {
      rs = rs ++ Array(i)
    }

    if(rs.size == 0) println("INVALID RANGE")
    else println(rs.mkString(" "))
  }


  private def isK(o: Int, a: Array[Int]): Boolean = {


    val d = decompose(o).size

    val (l,r) = if (a.size % 2 ==0) a.splitAt(d) else a.splitAt(d - 1)
    compose(r) + compose(l) == o
  }

  private def decompose(int: Long): Array[Int] = {
    int.toString.map(c => (c - '0')).toArray
  }

  private def compose(a:Array[Int]):Long = {
    if(a.size!=0)
    a.mkString.toInt
    else 0
  }

}
