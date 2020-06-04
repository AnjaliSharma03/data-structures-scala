package collections.lists

object SecondLastElement extends App {

  val list = List(2, 3, 5, 4, 9)

  @scala.annotation.tailrec
  def getElementRecursively[T](list: List[T]): T = list match {
    case _ if list.size == 1 =>
      throw new Exception("Second last element not present")
    case head :: _ if list.size == 2 => head
    case _ :: tail                   => getElementRecursively(tail)
    case Nil                         => throw new Exception("List is empty")
  }
  println(getElementRecursively(list))

}
