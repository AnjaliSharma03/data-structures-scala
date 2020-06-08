import java.util

class Entry {
  var booleanValue = false
  var number = 0
  var previous: Entry = _
  var next: Entry = _
}

class LRUCache {
  var hashmap: util.HashMap[Int, Entry] = _
  hashmap = new util.HashMap[Int, Entry]
  var start: Entry = _
  var end: Entry = _
  val LRU_SIZE = 3

  def getEntry(number: Int): Boolean = {
    if (hashmap.containsKey(number)) {
      val entry = hashmap.get(number)
      removeNode(entry)
      addAtTop(entry)
      println(s"$number is prime ? " + entry.booleanValue)
      entry.booleanValue
    } else throw new Exception("Not present in LRU cache")
  }

  def putEntry(number: Int, value: Boolean): Unit = {
    if (hashmap.containsKey(number)) {
      val entry = hashmap.get(number)
      entry.booleanValue = value
      removeNode(entry)
      addAtTop(entry)
    } else {
      val newNode = new Entry
      newNode.previous = null
      newNode.next = null
      newNode.booleanValue = value
      newNode.number = number
      if (hashmap.size > LRU_SIZE) {
        hashmap.remove(end.number)
        removeNode(end)
        addAtTop(newNode)
      } else addAtTop(newNode)
      hashmap.put(number, newNode)
    }
  }

  def addAtTop(node: Entry): Unit = {
    node.next = start
    node.previous = null
    if (start != null) start.previous = node
    start = node
    if (end == null) end = start
  }

  def removeNode(node: Entry): Unit = {
    if (node.previous != null) node.previous.next = node.next
    else start = node.next
    if (node.next != null) node.next.previous = node.previous
    else end = node.previous
  }

  def isPrime(number: Int): Boolean = {
    !((2 until number - 1) exists (number % _ == 0))
  }
}

object LRUCache extends App {
  val lruCache = new LRUCache
  lruCache.putEntry(1, lruCache.isPrime(1))
  lruCache.putEntry(5, lruCache.isPrime(5))
  lruCache.putEntry(3, lruCache.isPrime(3))
  lruCache.putEntry(6, lruCache.isPrime(6))
  lruCache.putEntry(4, lruCache.isPrime(4))
  lruCache.getEntry(3)
  lruCache.getEntry(6)
  lruCache.getEntry(4)

}
