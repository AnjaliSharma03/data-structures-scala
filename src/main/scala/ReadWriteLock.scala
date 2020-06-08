import java.util.concurrent.locks.ReentrantReadWriteLock

class ReadWriteLock {

  private val lock = new ReentrantReadWriteLock()
  val readLock: ReentrantReadWriteLock.ReadLock = lock.readLock()
  val writeLock: ReentrantReadWriteLock.WriteLock = lock.writeLock()

  def readMatrix(matrix: Array[Array[Int]]): Unit = {
    readLock.lock()
    try {
      for {
        i <- 0 until 3
        j <- 0 until 3
      } print(matrix(i)(j))
    } finally readLock.unlock()
  }

  def writeMatrix(matrix: Array[Array[Int]]): Unit = {
    writeLock.lock()
    try {
      for {
        i <- 0 until 3
        j <- 0 until 3
      } matrix(i)(j) += 1
    } finally writeLock.unlock()
  }

}

object ReadWriteLock extends App {
  val readWriteLock = new ReadWriteLock
  val thread = new Thread()
  thread.start()
  val matrix: Array[Array[Int]] = Array.ofDim[Int](3, 3)
  readWriteLock.readMatrix(matrix)
  readWriteLock.writeMatrix(matrix)
  readWriteLock.readMatrix(matrix)
}
