sealed trait LinkedList[+A] {
  def data: A
  def next: LinkedList[A]
}

case class MyList[+A](data: A, next: LinkedList[A]) extends LinkedList[A] {
  override def toString = s"head: $data, next: $next"
}

object NilList extends LinkedList[Nothing] {
  def data = throw new NoSuchElementException("head of empty list")
  def next = throw new UnsupportedOperationException("tail of empty list")
}

object MyLinkedList extends App {
  val c1 = MyList(1, NilList)
  val c2 = MyList(2, c1)
  val c3 = MyList(3, c2)
  println(c1)
  println(c2)
  println(c3)
}
