package challenges


/**
  * Created by carlosrojasmatas on 1/24/17.
  */
object Sherlock {

  import scala.collection.mutable.ArrayBuffer


  def toDecentNumber(seed:Int):Array[Int] = {
    var n5 = seed
    var n3 = 0

    while(!isDecent(n5,n3) && n5 > 0){
      n5 = n5 - 5
      n3 = n3 + 5
    }

    if(n5 < 0) Array(-1)
    else Array.fill(n5)(5) ++ Array.fill(n3)(3)


  }

  def isDecent(nr5:Int,nr3:Int):Boolean = (nr5 % 3 == 0 && nr3%5 == 0)



  def main(args: Array[String]): Unit = {

    val sc = new java.util.Scanner (System.in);
    val t = sc.nextInt();
    val rs:ArrayBuffer[Array[Int]] = new ArrayBuffer[Array[Int]]()

    for {
      i <- 1 to t
    }{
      val n = sc.nextInt();
      if( n == 1) rs.append(Array(-1))
      else if( n == 3) rs.append(Array(5,5,5))
      else if (n == 5) rs.append(Array(3, 3, 3, 3, 3))
      else{
        rs.append(toDecentNumber(n))
      }

    }


    rs.foreach(a => println (a.mkString("")))

  }
}
