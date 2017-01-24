package challenges

/**
  * Created by carlosrojasmatas on 10/5/16.
  */
object FibonacciModified {

  def main(args: Array[String]): Unit = {
    import scala.math.BigInt
    val sc = new java.util.Scanner(System.in);

    val t = sc.nextLine();

    val vals = t.split(' ').map(_.toInt)

    def fModified(ti:BigInt,ti1:BigInt,it:Int,seek:Int): BigInt = {
      if(it  > seek ) ti1
      else{
        val ti2 = ti + (ti1 * ti1)
        fModified(ti1,ti2,it + 1,seek)
      }
    }

    val rs =fModified(vals(0).toLong,vals(1).toLong,3,vals(2))
    println(rs)
  }
}
