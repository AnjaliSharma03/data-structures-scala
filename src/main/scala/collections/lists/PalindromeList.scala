package collections.lists

object PalindromeList extends App {

  def reverseList[A](list: List[A]): List[A] = {
    @scala.annotation.tailrec
    def reverseListRecursively[T](list: List[T], newList: List[T]): List[T] =
      list match {
        case head :: tail => reverseListRecursively(tail, head +: newList)
        case Nil          => newList
      }
    reverseListRecursively(list, List())
  }

  def checkPalindrome[A](list: List[A]): Boolean = {
    if (list.equals(reverseList(list))) true
    else false
  }

  val list = List(1, 2, 3, 2, 1)
  println(checkPalindrome(list))

}
