package tree

import scala.collection.mutable.ArrayBuffer

case class NewNode[T](left: Option[NewNode[T]],
                      data: Int,
                      right: Option[NewNode[T]])

object Main extends App {

  val tree1: NewNode[Int] = NewNode(
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
  val tree2: NewNode[Int] =
    NewNode(Some(NewNode(None, 2, None)), 1, Some(NewNode(None, 3, None)))

  showResult(convertToList(tree1, isBalancedBinaryTree(tree1)))
  showResult(convertToList(tree2, isBalancedBinaryTree(tree2)))

  def showResult[T](list: List[T]): Unit = list match {
    case Nil  => println("empty list")
    case list => println(list)
  }

  def isBalancedBinaryTree[T](tree: NewNode[T]): Boolean = {
    val height = heightOfLeftNode(tree) - heightOfRightNode(tree)
    if (height >= -1 && height <= 1) true
    else false
  }

  def heightOfLeftNode[T](tree: NewNode[T]): Int = {
    1 + tree.left.foldLeft(-1)(
      (height, leftNode) => height max heightOfLeftNode(leftNode)
    )
  }

  def heightOfRightNode[T](tree: NewNode[T]): Int = {
    1 + tree.right.foldLeft(-1)(
      (height, rightNode) => height max heightOfRightNode(rightNode)
    )
  }

  def convertToList[T](tree: NewNode[T],
                       isBalancedBinaryTree: Boolean): List[Int] = {
    val arr: ArrayBuffer[Int] = ArrayBuffer[Int]()
    def inorder[A](tree: NewNode[A]): Unit = {
      if (tree.left.isDefined) inorder(tree.left.get)
      arr += tree.data
      if (tree.right.isDefined) inorder(tree.right.get)
    }
    if (isBalancedBinaryTree) {
      inorder(tree)
      arr.toList
    } else arr.toList
  }
}
