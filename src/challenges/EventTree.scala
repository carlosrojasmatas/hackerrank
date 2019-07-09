package challenges

/**
  * Created by carlosrojasmatas on 11/12/16.
  */
object EventTree {


  case class Node(value: Int, parent: Option[Node] = None) {

    private var _parent: Option[Node] = parent
    private var _childs: List[Node] = List.empty

    def addChild(value: Int) {
      _childs = Node(value, Some(this)) :: _childs
    }


    def updateParent(parent: Node) {
      this._parent = Some(parent)
    }

    def childs = _childs

    def countNodes: Int = {
      def count(node: Node): Int = {
        if (node._childs.isEmpty) 1;
        else {
          1 + node._childs.map(count(_)).sum
        }
      }
      count(this)
    }

    def findNode(v: Int): Option[Node] = {

      def deepFirst(node: Node): Option[Node] = {
        if (node.value == v) {
          Some(node)
        }
        else if (node._childs.isEmpty) None
        else {

          var rs: Option[Node] = None
          val it = node._childs.iterator
          while (it.hasNext && rs == None) {
            rs = deepFirst(it.next())
          }
          rs
        }
      }
      deepFirst(this)

    }

  }


  def main(args: Array[String]): Unit = {

    val sc = new java.util.Scanner(System.in)
    sc.useDelimiter(System.getProperty("line.separator"))

    var tcs = Array.empty[(Int, Int)]
    val nm = sc.next().trim.split(" ").take(2).map(_.toInt)

    for {

      t <- 1 to nm(1)

    } {

      val ni = sc.next().trim.split(" ").take(2).map(_.toInt)
      tcs = tcs :+ (ni(0), ni(1))

    }


    def buildFromBuffer(array: Array[(Int, Int)], currentTree: Option[Node] = None): Node = {

      if (array.isEmpty) currentTree.get

      else {

        val h = array.head

        val noi: Node = currentTree match {
          case Some(t) => t.findNode(h._2).get
          case _ => Node(h._2)
        }

        for {

          c <- array.filter(_._2 == noi.value).map(_._1)
        } {

          noi.addChild(c)

        }

        buildFromBuffer(array.filterNot(_._2 == noi.value), if (!currentTree.isDefined) Some(noi) else currentTree)

      }
    }



    def countEven(node: Node): Int = {
      if (node.countNodes <= 2) 0
      else {
        val evens = node.childs.map(_.countNodes).count(_ % 2 == 0)
        val rs = node.childs.map(countEven(_))
        rs.sum + evens
      }
    }

    val tree = buildFromBuffer(tcs)
    println(countEven(tree))

  }


}



