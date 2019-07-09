package challenges

/**
  * Created by carlosrojasmatas on 8/10/16.
  */
object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var guests = sc.nextInt(); // guests
    var cookies = sc.nextInt(); // cookies

    // more guests than cookies
    if(guests >= cookies) println(Math.abs(cookies - guests))
    else {
      if(cookies % guests == 0) println(0)
      else println( guests - (cookies % guests))
    }
  }
}

