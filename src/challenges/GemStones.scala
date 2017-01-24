package challenges

/**
  * Created by carlosrojasmatas on 9/24/16.
  */
object GemStones {


  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in);
    val t = sc.nextInt();
    var gems = Array.empty[String]
    for{
      i <- 1 to t
    }{
      gems = gems :+ sc.next()
    }

    val els = gems.flatten.distinct

    val rss = (for {
      e <- els
    }yield{
        gems.map(_.contains(e)).count(_ == true)
    }).toList
    println(rss.count(_ == gems.size))
  }
}
