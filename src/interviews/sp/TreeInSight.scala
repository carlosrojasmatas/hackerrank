package interviews.sp

object TreeInSight {

  case class Range(coords: (Int, Int), offset: Int = 0)

  def findMaxRange(tree: List[Int], o: Int): Int = {

    def rangeFor(pos: Int): Range = {

      val r = pos + o
      if (r <= 360) Range((pos, r))
      else {
        Range((pos, 360), (o - (360 - pos)))
      }
    }


   val counts = for {
      t <- tree
    } yield {
      val r = rangeFor(t)
      tree.count { el =>
        val (l,u)=r.coords
        val p1 = el >= l && el < u
        val p2= r.offset > 0 && el >= 0 && el < r.offset

        p1 || p2
      }
    }

    counts.max
  }


  def main(args: Array[String]): Unit = {

    val a = List(1,2,10,35,60, 75,90,91,92,93,94,95,96,97,98,118,200,210,350,355,356)

    println(findMaxRange(a,50))

  }
}
