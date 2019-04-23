import scala.collection.mutable

/** 146. LRU Cache
  * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
  * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
  * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
  * Follow up: Could you do both operations in O(1) time complexity?
  * Example:
  * LRUCache cache = new LRUCache( 2 /* capacity */ );
  * cache.put(1, 1);
  * cache.put(2, 2);
  * cache.get(1);       // returns 1
  * cache.put(3, 3);    // evicts key 2
  * cache.get(2);       // returns -1 (not found)
  * cache.put(4, 4);    // evicts key 1
  * cache.get(1);       // returns -1 (not found)
  * cache.get(3);       // returns 3
  * cache.get(4);       // returns 4
  *
  * * Your LRUCache object will be instantiated and called as such:
  * * var obj = new LRUCache(capacity)
  * * var param_1 = obj.get(key)
  * * obj.put(key,value)
  */
class LRUCache(_capacity: Int) {

  protected class Node(val k: Int, var v: Int) {
    var pre: Node = _
    var after: Node = _
  }

  var _recent: Node = _
  var _least: Node = _
  var _num = 0

  val _cache = new mutable.HashMap[Int, Node]()

  def get(key: Int): Int = {
    if (_capacity <= 0 || _num == 0) {
      -1
    } else if (_capacity == 1) {
      if (_recent.k == key) _recent.v else -1
    } else {
      val o = _cache.get(key)
      if (o.isEmpty) {
        -1
      } else {
        val node = o.get
        if (_recent.k != node.k) {
          removeNode(node)
          addHead(node)
        }
        node.v
      }
    }
  }

  def put(key: Int, value: Int): Unit = {
    if (_capacity > 0) {
      if (_capacity == 1) {
        _num = 1
        _recent = new Node(key, value)
      } else if (_num == 0) {
        val node = new Node(key, value)
        addHead(node)
        _cache.put(key, node)
        _num = 1
      } else {
        val o = _cache.get(key)
        if (o.isDefined) {
          val old = o.get
          removeNode(old)
          old.v = value
          addHead(old)
        } else if (_num == _capacity) {
          val last = removeLast()
          _cache.remove(last.k)
          val node = new Node(key, value)
          addHead(node)
          _cache.put(key, node)
        } else {
          val node = new Node(key, value)
          addHead(node)
          _cache.put(key, node)
          _num += 1
        }
      }
    }
  }

  private def removeLast(): Node = {
    val t = _least
    _least = _least.pre
    _least.after = null
    t.pre = null
    t
  }

  private def removeNode(node: Node): Unit = {
    val pre = node.pre
    val after = node.after
    node.pre = null
    node.after = null
    if (pre != null) {
      pre.after = after
    } else {
      _recent = after //remove head
    }
    if (after != null) {
      after.pre = pre
    } else {
      _least = pre //remove last
    }
  }

  private def addHead(node: Node): Unit = {
    if (_recent == null) {
      _recent = node
      _least = node
    } else {
      _recent.pre = node
      node.after = _recent
      _recent = node
    }
  }
}
