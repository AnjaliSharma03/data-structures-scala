import java.util

class Entry {
  var value = 0
  var key = 0
  var previous: Entry = _
  var next: Entry = _
}

class LRUCache {
  var hashmap: util.HashMap[Int, Entry] = _
  hashmap = new util.HashMap[Int, Entry]
  var start: Entry = _
  var end: Entry = _
  val LRU_SIZE = 3

  def getEntry(key: Int): Int = {
    if (hashmap.containsKey(key)) {
      val entry = hashmap.get(key)
      removeNode(entry)
      addAtTop(entry)
      entry.value
    } else throw new Exception
  }

  def putEntry(key: Int, value: Int): Unit = {
    if (hashmap.containsKey(key)) {
      val entry = hashmap.get(key)
      entry.value = value
      removeNode(entry)
      addAtTop(entry)
    } else {
      val newNode = new Entry
      newNode.previous = null
      newNode.next = null
      newNode.value = value
      newNode.key = key
      if (hashmap.size > LRU_SIZE) {
        hashmap.remove(end.key)
        removeNode(end)
        addAtTop(newNode)
      } else addAtTop(newNode)
      hashmap.put(key, newNode)
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
}

object LRUCache extends App {
  val lruCache = new LRUCache
  lruCache.putEntry(1, 10)
  lruCache.putEntry(5, 11)
  lruCache.putEntry(3, 12)
  lruCache.putEntry(5, 13)
  lruCache.putEntry(4, 14)
  println(lruCache.getEntry(1))
  println(lruCache.getEntry(5))
  println(lruCache.getEntry(3))
  println(lruCache.getEntry(5))
  println(lruCache.getEntry(4))

}
