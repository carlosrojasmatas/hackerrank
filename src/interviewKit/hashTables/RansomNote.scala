package interviewKit.hashTables

object RansomNote {

  // Complete the checkMagazine function below.
  def checkMagazine(magazine: Array[String], note: Array[String]) {

    val wordMap = scala.collection.mutable.Map.empty[String, Int]
    for {
      w <- magazine
    } {
      if (wordMap.contains(w))
        wordMap(w) = wordMap(w) + 1
      else
        wordMap.put(w,1)
    }

    var rs = "Yes"
    for {
      n <- note
    } {
      if(!wordMap.contains(n)) rs ="No"
      else{
        val wc = wordMap(n)
        if (wc > 0) {
          wordMap(n) = wordMap(n) - 1
        } else rs = "No"
      }

    }
    println(rs)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val mn = stdin.readLine.split(" ")

    val m = mn(0).trim.toInt

    val n = mn(1).trim.toInt

    val magazine = stdin.readLine.split(" ")

    val note = stdin.readLine.split(" ")
    checkMagazine(magazine, note)
  }

}
