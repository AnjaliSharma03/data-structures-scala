package search

class BinarySearchRecursive {

  def binarySearch[T](list: List[T],
                      search: T)(implicit ordering: Ordering[T]): Boolean = {
    if (list.length == 1) {
      if (list.head == search) true else false
    } else if (list.isEmpty) {
      false
    } else {
      val midPoint = getMidPoint(list)
      val midElement = list.apply(midPoint)
      if (ordering.gt(search, midElement))
        binarySearch(list.drop(midPoint), search)
      else if (ordering.gt(midElement, search))
        binarySearch(list.take(midPoint), search)
      else true
    }
  }

  def getMidPoint[T](list: List[T]): Int = {
    if (list.size % 2 == 0) list.size / 2 else list.size / 2 + 1
  }

}

object BinarySearchRecursive extends App {
  val binarySearchRecursive = new BinarySearchRecursive
  val list = List(2, 3, 5, 6, 8)
  val res = binarySearchRecursive.binarySearch(list, 5)
  println(res)
}
