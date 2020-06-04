package collections.lists

object FlattenNestedList extends App {

  def flattenNestedList[A](list: List[A]): List[A] = list.flatMap {
    case list: List[A] => flattenNestedList(list)
    case element       => List(element)
  }

  val nestedList = List(List(1, 4, List(3, 4)), 2, List(3, List(5, 8)))
  println(flattenNestedList(nestedList))

}
