package challenges

import java.io.{File, FileInputStream, InputStream}
import java.util.regex.{Matcher, Pattern}

/**
  * Created by carlosrojasmatas on 9/19/16.
  */
object GridSearch {

  def main(args: Array[String]): Unit = {
    var is:InputStream = System.in
    if(args.size > 0 && args(0).equals("f")){
      is = new FileInputStream(new File(args(1)))
    }

    val sc = new java.util.Scanner(is);
    var t = sc.nextInt();
    var a0 = 0;
    var rs = Array.empty[String]
    while (a0 < t) {
      var R = sc.nextInt();
      var C = sc.nextInt();
      var G = new Array[String](R);
      for (gi <- 0 to R - 1) {
        G(gi) = sc.next();
      }
      var r = sc.nextInt();
      var c = sc.nextInt();
      var P = new Array[String](r);
      for (pi <- 0 to r - 1) {
        P(pi) = sc.next();
      }

      rs = rs :+ binarySearch(G, P)
      a0 += 1;
    }

    def binarySearch(grid:Array[String], pattern:Array[String]):String = {
      val gis = 0 to grid.length - 1
      val gjs = 0 to grid(0).length - 1
      val init = pattern(0)(0)
      val maxVComp = grid.length - pattern.length
      val maxHComp = grid(0).length - pattern(0).length
      var found = Option.empty[Boolean]
      for{
        i <- gis
        j <- gjs
        if !found.isDefined && i <= maxVComp && j <= maxHComp
      }{
        val c = grid(i)(j)
        if(c.equals(init)){
          var rs = true
          for{
            k <- 0 to pattern.length -1
            c <- 0 to pattern(0).length -1
          }{
            rs = rs & grid(i+k)(j + c).equals(pattern(k)(c))
          }

          if(rs) found = Some(rs)
        }
      }
      if(found.isDefined && found.get) "YES"
      else "NO"

    }

    rs.foreach(println _)
  }



}

object Aproach2{

  def main(args: Array[String]): Unit = {

    var is:InputStream = System.in
    if(args.size > 0 && args(0).equals("f")){
      is = new FileInputStream(new File(args(1)))
    }
    val init = System.currentTimeMillis()
    val sc = new java.util.Scanner(is);
    var t = sc.nextInt();
    var a0 = 0;
    var rs = Array.empty[Boolean]
    while (a0 < t) {
      var R = sc.nextInt();
      var C = sc.nextInt();
      var G = new Array[String](R);
      for (gi <- 0 to R - 1) {
        G(gi) = sc.next();
      }
      var r = sc.nextInt();
      var c = sc.nextInt();
      var P = new Array[String](r);
      for (pi <- 0 to r - 1) {
        P(pi) = sc.next();
      }

      rs = rs :+ deepSearch(G,P)
      a0 += 1;
    }


    rs.foreach(r => println (if(r)"YES" else "NO"))

    println((System.currentTimeMillis() - init)/1000)

  }

  def search(grid:Array[String],pattern:Array[String]):Boolean = {



    def searchPattern(text:String,pat:String,curr:Array[Int]):Array[Int] = {
      if(!text.contains(pat)) curr
      else searchPattern(text.replaceFirst(pat,"x"*pat.length),pat,curr :+ text.indexOf(pat))
    }

    def evalPositions(text:Array[String],pat:Array[String],pos:Int):Boolean = {

      if(pat.isEmpty) true
      else {
        if(text.head.indexOf(pat.head) == pos) evalPositions(text.tail,pat.tail,pos)
        else false
      }
    }

    //    val rs = searchPattern(text,p2,Array.empty[Int])
    val maxVComp = grid.length - pattern.length
    val init = pattern(0)
    var rs = false

    for{
      e <- 0 to maxVComp
      i <- searchPattern(grid(e),init,Array.emptyIntArray)
      if !rs
    }{
      val in =evalPositions(grid.slice(e+1,grid.length),pattern.slice(1,pattern.length),i)
      if (in) rs = true
    }
    rs
  }

  def deepSearch(grid:Array[String], pattern:Array[String]):Boolean = {
    val gis = 0 to grid.length - 1
    val gjs = 0 to grid(0).length - 1
    val init = pattern(0)(0)
    val maxVComp = grid.length - pattern.length
    val maxHComp = grid(0).length - pattern(0).length
    var found = Option.empty[Boolean]
    for{
      i <- gis
      j <- gjs
      if !found.isDefined && i <= maxVComp && j <= maxHComp
    }{
      val c = grid(i)(j)
      if(c.equals(init)){

        def seek(c1:String,c2:String):Boolean = {
          if(c1.size < c2.size) false
          else if(c2.isEmpty)true
          else if(!c1.head.equals(c2.head)) seek(c1.tail,c2)
          else seek(c1.tail,c2.tail)
        }

        var rs = true

        for{
          k <- 0 to pattern.length -1
//          c <- 0 to pattern(0).length -1
        }{
//          rs = rs & grid(i+k)(j + c).equals(pattern(k)(c))
          rs = rs & seek(grid(i+k),pattern(k))
        }

        if(rs) found = Some(rs)
      }
    }
    found.isDefined && found.get

  }

}

object Aproach3 {

  def main(args: Array[String]): Unit = {
    var is:InputStream = System.in
    if(args.size > 0 && args(0).equals("f")){
      is = new FileInputStream(new File(args(1)))
    }
    val init = System.currentTimeMillis()
    val sc = new java.util.Scanner(is);
    var t = sc.nextInt();
    var a0 = 0;
    var rs = Array.empty[Boolean]
    while (a0 < t) {
      var R = sc.nextInt();
      var C = sc.nextInt();
      var G = new Array[String](R);
      for (gi <- 0 to R - 1) {
        G(gi) = sc.next();
      }
      var r = sc.nextInt();
      var c = sc.nextInt();
      var P = new Array[String](r);
      for (pi <- 0 to r - 1) {
        P(pi) = sc.next();
      }

      rs = rs :+ search(G,P)
      a0 += 1;
    }



    rs.foreach(r => println (if(r)"YES" else "NO"))

    println((System.currentTimeMillis() - init)/1000)


  }

  def search(grid:Array[String],pattern:Array[String]):Boolean = {

    val gc = grid(0).size
    val pc = pattern(0).size

    var rs = false
    var h= 0
    for{
      g <- grid
      i <- 0 to gc
//      if rs == false && grid.indexOf(g) <= pattern.size
    }{
      if(i <= (gc - pc) && g.substring(i).startsWith(pattern(0))) {
        val subMat = grid.slice(grid.indexOf(g),grid.indexOf(g) + pattern.size).map(_.substring(i))
        if(compareArrays(subMat,pattern)) rs = true
        //        subMat.foreach(println _)
      }
    }

    rs
  }

  def compareArrays(a1:Array[String],a2:Array[String]):Boolean = {
//    println("***************************Comparing*********************")
//    a1.foreach(println _)
//    println("-----")
//    a2.foreach(println _)
//    println("***************************End*********************")
    a1.zip(a2).filter(tup => !tup._1.startsWith(tup._2)).size == 0
  }
}