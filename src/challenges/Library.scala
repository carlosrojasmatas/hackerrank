package challenges

/**
  * Created by carlosrojasmatas on 8/29/16.
  */
object Library {


  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    var d1 = sc.nextInt();
    var m1 = sc.nextInt();
    var y1 = sc.nextInt();
    var d2 = sc.nextInt();
    var m2 = sc.nextInt();
    var y2 = sc.nextInt();

    val c1 = java.util.Calendar.getInstance()
    val c2 = java.util.Calendar.getInstance()
    c1.clear()
    c2.clear()
    c1.set(y1,m1,d1)
    c2.set(y2,m2,d2)

    var fine:Int = 0

    if( ! (c1.getTimeInMillis <= c2.getTimeInMillis) ){

      if(m1 == m2 && y1 == y2){
        fine = 15 * (d1 - d2)
      }else if(y1 == y2){
        fine = 500 * (m1 - m2)
      }else {
        fine = 10000
      }

    }

    println(fine)
  }
}
