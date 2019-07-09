package challenges

/**
  * Created by carlosrojasmatas on 8/19/16.
  */
object Staircase {


  def main(args: Array[String]) {


    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();


    val lineFormat= "%1$" + s"${n}s"
    def fill(curr:Array[String],i:Int):Array[String] = {
      if(i == n) curr
      else{
        fill(curr.updated(i,lineFormat.format("#" * (i+1))),i+1)
      }
    }

    fill(Array.ofDim(n),0).foreach(
      println(_)
    )

  }

}
