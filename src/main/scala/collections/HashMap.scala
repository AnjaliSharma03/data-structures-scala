package collections

case class Entry[K, V](key: K, value: V)

class HashMap[K, V](entries: Vector[Vector[Entry[K, V]]]) {

  def add(key: K, value: V): HashMap[K, V] = {
    val index = indexFor(key)

    if (entries.isEmpty) init.add(key, value)
    else {
      val chain = entries(index)
      chain.indexWhere(_.key == key) match {
        case -1 =>
          val e = Entry(key, value)
          new HashMap(entries.updated(index, e +: chain))
        case i =>
          val replaced = chain(i).copy(value = value)
          new HashMap(entries.updated(index, chain.updated(i, replaced)))
      }
    }
  }

  private def init: HashMap[K, V] = {
    new HashMap(Vector.fill(10)(Vector.empty))
  }

  private def indexFor(key: K): Int = {
    key.hashCode() & entries.length
  }

  def remove(key: K): HashMap[K, V] = {
    val index = indexFor(key)
    val updated = entries.updated(index, entries(index).filter(_.key != key))
    new HashMap(updated)
  }

  def get(key: K): Option[V] = {
    val index = indexFor(key)
    entries(index).find(_.key == key).map(_.value)
  }

}

object HashMap extends App {
  val hashMap = new HashMap[Int, String](Vector.empty)
  val first = hashMap.add(1, "first")
  val second = first.add(2, "second")
  val third = second.add(3, "third")
  val res = first.get(1)
  println(res)
}
