package challenges

/**
  * Created by carlosrojasmatas on 8/10/16.
  */
object Sets {


  def main(args: Array[String]) {

    import scala.collection.immutable.ListMap

    case class Candidate(x:Int,y:Int,distance:Int)



    def pick(a:List[Candidate]):Option[(Candidate,Candidate)] = {

      val lc = a.filter(c => c.x > c.y)
      val rc =  a.filter(c => c.x < c.y)

      if(lc.isEmpty || rc.isEmpty) None
      else{
        val rs= (for {
          i <- lc
          j <- rc
          if(i.x != j.x)
        } yield (i,j))
        if (rs.isEmpty) None
        else Some(rs.head)
      }


    }

    def distance(diffA:Array[Int],diffB:Array[Int],movs:Int):Int= {

      if(diffA.isEmpty || diffA.size % 2 != 0) movs
      else{

        val distances = for{
          ael <- diffA
          bel <- diffB
        } yield (Candidate(ael,bel,ael - bel))

        val distGroup = distances.toList.groupBy(d => Math.abs(d.distance))
        val candidates= ListMap(distGroup.toSeq.sortBy(_._1):_*).head

        val cands = pick(candidates._2)

        cands match {
          case None => -1
          case Some(cs) => {
            val xtr = List(cs._1.x,cs._2.x)
            val ytr = List(cs._1.y,cs._2.y)
            distance(diffA diff xtr,diffB diff ytr,movs + Math.abs(cs._1.distance))
          }
        }
      }
    }


    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    val a = new Array[Int](n);
    val b = new Array[Int](n);

    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt();
    }

    for(b_i <- 0 to n-1) {
      b(b_i) = sc.nextInt();
    }

    val aDiff = a diff b
    val bDiff = b diff a



    //can't be resolved if they have different or even sizes
    if (a.size != b.size || aDiff.size % 2 != 0 || bDiff.size % 2 != 0){

      println(-1)

    } else {
        println(distance(aDiff,bDiff,0))
    }



  }
}
