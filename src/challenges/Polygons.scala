package challenges

/**
  * Created by carlosrojasmatas on 8/10/16.
  */
object Polygons {

  def main(args: Array[String]) {

    def isPolygon(rs: Array[Int], combs: List[List[Int]]): Boolean = {

      combs match {
        case List() => false
        case h :: t => {
          if (ineq(rs)) true else isPolygon(rs ++ h, t)
        }
      }

    }

    def cut(original: Array[Int], ineqs: Array[Int], currCn: Int): Int = {
      if (isPolygon(original diff List(ineqs.head), combinations(ineqs.head))) currCn
      else {
        cut(original, ineqs.tail, currCn + 1)
      }
    }

    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    val a = new Array[Int](n);
    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt();
    }

    if (ineq(a)) println(0)
    else {
      val in = a.filter(isIneq(_, a))
      println(cut(a,in,1))
    }
  }

  private def remove(num: Int, list: List[Int]): List[Int] = list diff List(num)

  private def combinations(v: Int): List[List[Int]] = {
    val r = 1 to v
    r.combinations(2).toList.map(_.toList)
  }

  private def isIneq(el: Int, rs: Array[Int]): Boolean = {
    val sum = rs.sum / 2
    el >= sum
  }

  private def ineq(rs: Array[Int]): Boolean = {
    val sum = rs.sum / 2
    ! rs.find(_ >= sum).isDefined
  }
}

