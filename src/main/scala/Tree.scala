case class Node(child: Seq[Node])

class Tree {

  def getSize(node: Node): Int= {
    1 + node.child.foldLeft(0)((s,c) => s + getSize(c))
  }

  def getNoOfNodesWithTwoChildren(node: Node): Int ={
    @scala.annotation.tailrec
    def getNodesRecursively(node: Seq[Node], count: Int): Int = node match {
      case node if node.isEmpty  => count
      case node if node.nonEmpty =>
        val childCount = node.count(_.child.length > 1)
        println(node.flatMap(_.child))
        getNodesRecursively(node.flatMap(_.child), count + childCount)
    }
    getNodesRecursively(node.child, 0)
  }

}

object Tree extends App {
  val tree = new Tree
  val node: Node = Node(
                    List(
                        Node(List(
                          Node(List(Node(Nil), Node(Nil))),
                          Node(Nil),
                          Node(Nil))),
                        Node(List(Node(Nil))),
                        Node(List(Node(Nil), Node(Nil))),
                        Node(List(Node(Nil), Node(Nil)))
                        )
                    )
  println(tree.getSize(node))
  println(tree.getNoOfNodesWithTwoChildren(node))
}