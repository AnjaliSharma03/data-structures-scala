package queue

import scala.collection.mutable.Stack

class Queue {
  var stack1: Stack[Int] = _
  var stack2: Stack[Int] = _
}

object QueueUsingStacks {

  def push(stack: Stack[Int], new_data: Int): Unit = {
    stack.push(new_data)
  }

  def pop(stack: Stack[Int]): Int = {
    if (stack.isEmpty) {
      println("Stack is empty")
      System.exit(0)
    }
    stack.pop
  }

  def enQueue(q: Queue, x: Int): Unit = {
    push(q.stack1, x)
  }

  def deQueue(q: Queue): Int = {
    var element = 0
    if (q.stack1.isEmpty && q.stack2.isEmpty) {
      println("Queue is empty")
      System.exit(0)
    }
    if (q.stack2.isEmpty) while ({
      q.stack1.nonEmpty
    }) {
      element = pop(q.stack1)
      push(q.stack2, element)
    }
    element = pop(q.stack2)
    element
  }

  def main(args: Array[String]): Unit = {
    val queue = new Queue
    queue.stack1 = new Stack[Int]
    queue.stack2 = new Stack[Int]
    enQueue(queue, 5)
    enQueue(queue, 3)
    enQueue(queue, 8)
    println(deQueue(queue))
    println(deQueue(queue))
    println(deQueue(queue))
  }
}
