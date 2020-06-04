package collections.lists

class ReverseList {
  def reverseList[A](list: List[A]): List[A] = {
    @scala.annotation.tailrec
    def reverseListRecursively[A](list: List[A], newList: List[A]): List[A] =
      list match {
        case head :: tail => reverseListRecursively(tail, head +: newList)
        case Nil          => newList
      }
    reverseListRecursively(list, List())
  }
}

object ReverseList extends App {
  val reverseList = new ReverseList
  val list = List(2, 5, 3, 6, 8, 9)
  println(reverseList.reverseList(list))
}
