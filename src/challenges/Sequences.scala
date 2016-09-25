package challenges

/**
  * Created by carlosrojasmatas on 8/12/16.
  */
object Sequences {


  def main(args: Array[String]) {
//    val sc = new java.util.Scanner (System.in);
//    val n = sc.nextInt();
//    val a = new Array[Int](n);
//    val b = new Array[Int](n);
//
//    for(a_i <- 0 to n-1) {
//      a(a_i) = sc.nextInt();
//    }
//
//    for(b_i <- 0 to n-1) {
//      b(b_i) = sc.nextInt();
//    }


    def checkBounds(seq:Seq[Int],bound:Int):Boolean ={
      seq.filterNot(s => s >= -1 && s <= seq.length-1).isEmpty
    }


    def isNice(nr:Seq[Int]):Boolean  = {

      if(!nr.find(_ != 0).isDefined) true
      else {

        val idx = (0 to nr.length -1).combinations(2).toList

        val fcond = for{
          i <- 0 to nr.length - 1
        }yield{
          (nr(i) >=0 && nr(i) <= (i))
        }

        val congruences = idx.map(pair => {
          val k  = pair(0)
          val m = pair(1)
          if(m == 0 || k == 0 || m % k != 0) true
          else if(k != 0  &&  nr(k) % k == nr(m) % k) true
          else false
        })

        !fcond.contains(false) && !congruences.contains(false)
      }

    }

    def pickIndex(curr:Int,length:Int):Int = {
      if(curr >= length - 1) 0
      else curr + 1
    }

    def findNices(seq:Seq[Int],count:Int,currIdx:Int):Int ={
      println(seq)
      if(seq(currIdx) > seq.length -1 ) count
      else {
          findNices(seq.updated(currIdx,seq(currIdx) + 1), if (isNice(seq)) count + 1 else count,currIdx)
      }
    }

    val seq = List(0,-1,-1)

    val idxs  = for {
      i <- 0 to seq.length - 1
      if(seq(i) == -1)
    } yield i

    val n = idxs.map(

      i => {
        findNices(seq,0,i)
      }

    )

    println((n.sum % (10E9 + 7)).toInt)
  }


}


object Variations {


  def main(args: Array[String]) {
    val l = Seq(0,0,0)

   val all =  for{
      i <- 1 to l.length
    }yield l.combinations(i)

    all.flatten.foreach(c => {
      for {
        i <- c
      } println(l.updated(i,l(i) + 1))
    })


  }
}
