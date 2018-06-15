package challenges

object QuickSort {

  def quickSort(arr: Array[Int]): Array[Int] =  {
    def partition(p:Int,r:Array[Int],e:Array[Int],l:Array[Int],rem:Array[Int]):Array[Int] = {
      if(rem.isEmpty) l ++ e ++ r
      else {
        val h = rem.head
        if(h < p) partition(p,r,e, l :+ h,rem.tail)
        else if(h > p) partition(p,r :+ h,e, l,rem.tail)
        else partition(p,r ,e :+ h, l,rem.tail)
      }
    }
    partition(arr.head,Array.empty,Array.empty,Array.empty,arr)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    val result = quickSort(arr);
    println (result.mkString(" "))


  }
}
