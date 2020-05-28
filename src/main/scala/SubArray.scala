import java.util

class SubArray {
  def isSubSetPresent(arr: Array[Int]): Boolean = {
    val hashSet = new util.HashSet[Int]
    var sum = 0
    for (i <- arr.indices) {
      sum += arr(i)
      if (arr(i) == 0 || sum == 0 || hashSet.contains(sum)) return true
      hashSet.add(sum)
    }
    false
  }
}

object SubArray extends App {
  val subArray = new SubArray
  val arr = Array(1, 4, -2, -2, 5, -4, 3)
  println(subArray.isSubSetPresent(arr))
}
