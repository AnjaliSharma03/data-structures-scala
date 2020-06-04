package collections.lists

// Consecutive duplicates of list elements
object EliminateDuplicates extends App {

  def eliminateDuplicateElements[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case head :: tail =>
      head :: eliminateDuplicateElements(tail.dropWhile(_ == head))
  }

  val list = List(1, 1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 5, 5)
  println(eliminateDuplicateElements(list))

}
