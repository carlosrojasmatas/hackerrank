package interviewKit.warmup

object Socks {

  def sockMerchant(socks: Array[Int]): Int = {
    def fold(curr:List[Int], pivot:List[Int], count:Int): Int = {
      if (curr.isEmpty) count
      else {
        val h = curr.head
        if(!pivot.isEmpty && pivot.head == h){
            fold(curr.tail,pivot.tail,count + 1  )
        }else{
          fold(curr.tail,curr.head :: pivot,count)
        }
      }
    }

    val sorted = socks.sorted
    fold(socks.toList.sorted,List.empty,0)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = sockMerchant(ar)

    println(result)

  }
}
