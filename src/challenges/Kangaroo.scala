package challenges

/**
  * Created by carlosrojasmatas on 9/1/16.
  */
object Kangaroo {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    var x1 = sc.nextInt();
    var v1 = sc.nextInt();
    var x2 = sc.nextInt();
    var v2 = sc.nextInt();

    if((x1 == x2 ) || (x1 < x2 && v1 <= v2)) println("NO")
    else{


      val rs = (x1 - x2) % (v2 -v1 ) == 0

      println(if (rs) "YES" else "NO")
    }
  }
}
