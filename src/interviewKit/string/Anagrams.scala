package interviewKit.string

object Anagrams {

    // Complete the makeAnagram function below.
    def makeAnagram(a: String, b: String): Int = {

      val asciiFlor = 97
      val nrOfLetter = 'z'.toInt - 'a'.toInt

      //the strings must be sorted
      def countFreqs(rem:Array[Int],fqs:Array[Int]):Array[Int] = {
        if(rem.isEmpty) fqs
        else{
          val h = rem.head
          fqs(h) = fqs(h)+ 1
          countFreqs(rem.tail,fqs)
        }
      }

      val aInt = a.map(_.toInt - asciiFlor).toArray
      val bInt = b.map(_.toInt - asciiFlor).toArray

      val afqs = countFreqs(aInt,Array.fill(nrOfLetter + 1)(0))
      val bfqs = countFreqs(bInt,Array.fill(nrOfLetter + 1)(0))

      var rs = 0
      for{
        i <- 0 to nrOfLetter
      }{
        rs = rs + (Math.abs(afqs(i)-bfqs(i)))
      }

      rs

    }

    def main(args: Array[String]): Unit = {
      val stdin = scala.io.StdIn


      val a = stdin.readLine

      val b = stdin.readLine

      val res = makeAnagram(a, b)

      println(res)

    }
}
