package challenges


/**
  * Created by carlosrojasmatas on 10/31/16.
  */
object SansaAndXor {


  def main(args: Array[String]): Unit = {

    import java.io.{File, FileInputStream, InputStream}

    var is:InputStream = System.in
    if(args.size > 0 && args(0).equals("f")){
      is = new FileInputStream(new File(args(1)))
    }
    val sc = new java.util.Scanner(is);
    sc.useDelimiter(System.getProperty("line.separator"))

    val tc = sc.nextInt()

    var rs = Array.empty[Int]

    for {
      t <- 1 to tc
    } {
      val n = sc.next().trim.toInt
      val a = sc.next().trim.split(' ').map(_.toInt)

      if(a.isEmpty || n % 2 == 0) rs = rs :+ 0
      else{
        rs = rs :+ a.zipWithIndex.filter(x => x._2 % 2 ==0).map(_._1).reduce((a,b) => a ^ b)
      }

    }

    rs.foreach(println _)
  }

  def xor(array: Array[Int]): Int = {
  8
  }

  def filterEven(array: Array[Int]): Array[Int] = {

    def count(left: Array[Int], curr: Array[Int]): Array[Int] = {
      if (left.isEmpty) curr
      else {
        val i = left.head
        count(left.tail, curr.updated(i - 1, curr(i - 1) + 1))
      }
    }
    val counts = count(array, Array.fill[Int](array.length)(0))
    val evens = counts.zipWithIndex.filterNot(_._1 % 2 == 0)

    array.filter(evens.map(_._2 + 1).contains(_)).distinct
  }

  def flattenCombs(array: Array[Int]): Array[Int] = {

    def decompose(offset: Int, take: Int): Array[Int] = {
      if (take == array.size) array
      else {
        val curr = array.slice(offset, (offset + take))
        curr ++ (if (offset + take == array.size) decompose(0, take + 1) else decompose(offset + 1, take))
      }
    }

    decompose(0, 1)

  }
}
