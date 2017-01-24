package challenges


/**
  * Created by carlosrojasmatas on 11/8/16.
  */
object Candies {

  def main(args: Array[String]): Unit = {


    import scala.collection.mutable.ArrayBuffer
    import java.io.{File, FileInputStream, InputStream}

    var is:InputStream = System.in

    if(args.size > 0 && args(0).equals("f")){
      is = new FileInputStream(new File(args(1)))
    }
    val sc = new java.util.Scanner(is);


    val n = sc.nextInt();
    val students = ArrayBuffer.empty[Long]
    val rs = ArrayBuffer.fill[Long](n)(1)

    for{

      i <- 0 to n - 1

    }{

      val rank =  sc.nextLong()
      students += rank
      var cand = rs(i)

      if(i !=0 )

      {

          if (rank > students(i - 1)){
            cand = rs(i - 1) + 1
          }

      }
        rs(i) = cand

    }


    if(n > 2) {
      for {
        i <- students.size - 2 to 0 by -1
      } {
        if(students(i) > students(i + 1) && rs(i) <= rs(i + 1) ) rs(i) = rs(i+1) + 1
      }
    }

    println(rs.sum)
  }
}
