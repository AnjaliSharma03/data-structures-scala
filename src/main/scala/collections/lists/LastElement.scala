package collections.lists

object LastElement extends App {

  val list = List(2, 5, 3, 6, 8, 9)

  @scala.annotation.tailrec
  def findLastElementRecursively[T](list: List[T]): T =
    list match {
      case head :: _ if list.size == 1 => head
      case _ :: tail                   => findLastElementRecursively(tail)
      case Nil                         => throw new Exception("List is empty")
    }
  println(findLastElementRecursively(list))
}
