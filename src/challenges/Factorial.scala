package challenges

/**
  * Created by carlosrojasmatas on 8/16/16.
  */
object Factorial {


  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();

      def factorial(n:Int):BigInt ={


        if(n == 1) {
          n
        }else{
          n * factorial(n - 1)
        }

      }

      println(factorial(n))

  }
}
