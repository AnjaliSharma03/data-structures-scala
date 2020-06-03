case class LinkedList(var data: Int, var next: LinkedList = null)

object MyLinkedList extends App {

  var head: LinkedList = _
  def push(newData: Int): Unit = {
    val newNode = LinkedList(newData, head)
    head = newNode
  }

  def search(head: LinkedList, searchData: Int): Boolean = {
    if (head == null) false
    else if (head.data != searchData) search(head.next, searchData)
    else true
  }

  push(10)
  push(20)
  push(30)
  push(40)
  push(50)
  println(search(head, 40))

}
