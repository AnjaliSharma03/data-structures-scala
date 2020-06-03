package tree

case class TreeNode[A](left: Option[TreeNode[A]] = None,
                       data: Int,
                       right: Option[TreeNode[A]] = None)

class TreeTraversal {

  def preOrder[A](treeNode: TreeNode[A]): Unit = {
    print(treeNode.data)
    if (treeNode.left.isDefined) preOrder(treeNode.left.get)
    if (treeNode.right.isDefined) preOrder(treeNode.right.get)
  }

  def postOrder[A](treeNode: TreeNode[A]): Unit = {
    if (treeNode.left.isDefined) postOrder(treeNode.left.get)
    if (treeNode.right.isDefined) postOrder(treeNode.right.get)
    print(treeNode.data)
  }

}

object TreeTraversal extends App {
  val treeTraversal = new TreeTraversal
  val tree: TreeNode[Int] = TreeNode(
    Some(
      TreeNode(
        Some(TreeNode(Some(TreeNode(None, 6, None)), 4, None)),
        2,
        Some(TreeNode(None, 5, None))
      )
    ),
    1,
    Some(TreeNode(None, 3, None))
  )
  println(treeTraversal.preOrder(tree))
  println(treeTraversal.postOrder(tree))
}
