package challenges

/**
  * Created by carlosrojasmatas on 8/18/16.
  */
object Diagonal {


  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a = Array.ofDim[Int](n,n);
    for(a_i <- 0 to n-1) {
      for(a_j <- 0 to n-1){
        a(a_i)(a_j) = sc.nextInt();
      }
    }

    var d1:Int = 0
    var d2:Int = 0

    for {
      i <- 0 to n -1
      j <- 0 to n -1
    }{
      if(i  == j) d1 += a(i)(j)

      if(i+j == n - 1 ) d2 += a(i)(j)
    }

    println(Math.abs(d1 - d2))
  }
}
