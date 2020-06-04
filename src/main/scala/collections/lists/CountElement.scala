package collections.lists

object CountElement extends App {

  def getNumberOfElements[A](list: List[A]): Int = {
    @scala.annotation.tailrec
    def getNumberOfElementsRecursively[T](list: List[T], count: Int): Int =
      list match {
        case _ if list.isEmpty => count
        case _ :: tail         => getNumberOfElementsRecursively(tail, count + 1)
      }
    getNumberOfElementsRecursively(list, 0)
  }

  val list = List(2, 5, 3, 6, 8, 9)
  println(getNumberOfElements(list))
}
