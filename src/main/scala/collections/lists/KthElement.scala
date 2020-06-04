package collections.lists

object KthElement extends App {

  val list = List(2, 5, 3, 6, 8, 9)

  def findKthElement[A](list: List[A], kthPosition: Int): A = {
    @scala.annotation.tailrec
    def findKthElementRecursively[T](list: List[T], position: Int): T =
      list match {
        case head :: _ if position == kthPosition => head
        case _ :: tail                            => findKthElementRecursively(tail, position + 1)
        case Nil                                  => throw new Exception("List is empty")
      }
    findKthElementRecursively(list, 0)
  }
  println(findKthElement(list, 2))
}
