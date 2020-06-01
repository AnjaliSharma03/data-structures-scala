case class NewNode(left: Option[NewNode], data: Int, right: Option[NewNode])

object Main extends App {
  val tree1 = NewNode(
    Some(
      NewNode(
        Some(NewNode(Some(NewNode(None, 6, None)), 4, None)),
        2,
        Some(NewNode(None, 5, None))
      )
    ),
    1,
    Some(NewNode(None, 3, None))
  )
  val tree2 =
    NewNode(Some(NewNode(None, 2, None)), 1, Some(NewNode(None, 3, None)))
  println(isBalancedBinaryTree(tree2))

//  showResult(convertToList(tree1, isBalancedBinaryTree(tree1)))
//  showResult(convertToList(tree2, isBalancedBinaryTree(tree2)))

  def showResult(list: List[Int]): Unit = list match {
    case Nil  => println("empty list")
    case list => println(list)
  }

  def isBalancedBinaryTree(tree: NewNode): Boolean = {
    val height = heightOfLeftNode(tree) - heightOfRightNode(tree)
    if (height >= -1 && height <= 1) true
    else false
  }

  def heightOfLeftNode(tree: NewNode): Int = {
    1 + tree.left.foldLeft(-1)(
      (height, leftNode) => height max heightOfLeftNode(leftNode)
    )
  }

  def heightOfRightNode(tree: NewNode): Int = {
    1 + tree.right.foldLeft(-1)(
      (height, rightNode) => height max heightOfRightNode(rightNode)
    )
  }

  def convertToList(tree: NewNode, isBalancedBinaryTree: Boolean): List[Int] =
    ???

}
