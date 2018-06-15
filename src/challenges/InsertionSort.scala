package challenges

object InsertionSort {

  import scala.util.control.Breaks._

  def insertionSort2(arr:Array[Int]) = {

    for(i <- 1 to arr.length - 1){
      for(j <- (i-1) to 0 by -1){
        if(arr(j+1) < arr(j)){
          val el = arr(j)
          arr.update(j,arr(j+1))
          arr.update(j+1,el)
        }
      }
      println(arr.mkString(" "))
    }
  }

  def insertionSort3(arr:Array[Int]):Int = {
    var nr = 0
    for(i <- 1 to arr.length - 1){
      for(j <- (i-1) to 0 by -1){
        if(arr(j+1) < arr(j)){
          nr = nr + 1
          val el = arr(j)
          arr.update(j,arr(j+1))
          arr.update(j+1,el)
        }
      }
    }
    nr
  }

  def insertionSort1(arr: Array[Int]) = {
    val el = arr.last
    for (i <- (arr.size - 2) to 0 by -1) {
      if (arr(i) > el) {
        arr.update(i + 1, arr(i))
        println(arr.mkString(" "))
        if (i == 0) {
          arr.update(i, el)
          println(arr.mkString(" "))
        }
      } else {
        arr.update(i + 1, el)
        println(arr.mkString(" "))
        break
      }
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for (arr_i <- 0 to n - 1) {
      arr(arr_i) = sc.nextInt();
    }
//    insertionSort1(arr);
    println(insertionSort3(arr))
  }

}
