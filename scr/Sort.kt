//https://gist.github.com/bnyu/e70fed1f80d060926e7c0bb2ae4e9e22

//快排
fun quickSort(x: Array<Int>, a: Int, b: Int) {
    var i = a
    var j = b
    val mid = x[i]
    while (i < j) {
        while (mid <= x[j] && i < j)
            j--
        if (i < j) {
            x[i] = x[j]
            i++
        }
        while (mid >= x[i] && i < j)
            i++
        if (i < j) {
            x[j] = x[i]
            j--
        }
        x[i] = mid
    }
    if (a < i)
        quickSort(x, a, i - 1)
    if (b > i)
        quickSort(x, i + 1, b)
}
//选择
fun selectSort(x: Array<Int>, a: Int, b: Int) {
    var min: Int
    var index: Int
    for (i in a..b) {
        min = x[i]
        index = i
        for (j in i + 1..b) {
            if (x[j] < min) {
                index = j
                min = x[j]
            }
        }
        x[index] = x[i]
        x[i] = min
    }
}
//插入
fun insertSort(x: Array<Int>, a: Int,b: Int) {
    var temp: Int
    var j: Int
    for (i in a..b) {
        temp = x[i]
        j = i - 1
        while (j >= a && temp < x[j]) {
            x[j + 1] = x[j]
            j--
        }
        x[j + 1] = temp
    }
}
//冒泡
fun bubbleSort(x: Array<Int>, a: Int, b: Int) {
    var temp: Int
    var flag = true
    var j = b
    while (flag) {
        flag = false
        for (i in a + 1..j) {
            if (x[i - 1] > x[i]) {
                temp = x[i]
                x[i] = x[i - 1]
                x[i - 1] = temp
                flag = true
            }
        }
        j--
    }
}


class Lnode constructor(var data: Any){
    //尾节点指向尾节点自身
    var next: Lnode = this
    //尾部插入
    fun tInsert(data: Any){
        val point = Lnode(data)
        var temp: Lnode = this
        while (temp.next != temp)
            temp = temp.next
        temp.next = point
    }
    //头部插入
    fun hInsert(data: Any): Lnode {
        val point = Lnode(data)
        point.next = this
        return point
    }
}


class Bnode(val data: Any){
    var lchild: Bnode = this
    var rchild: Bnode = this
    //前序遍历
    fun preorder(t: Bnode){
        print(t.data.toString()+" ")
        if (t.lchild != t)
            preorder(t.lchild)
        if (t.rchild != t)
            preorder(t.rchild)
    }
    //中序遍历
    fun inorder(t: Bnode){
        if (t.lchild != t)
            inorder(t.lchild)
        print(t.data.toString()+" ")
        if (t.rchild != t)
            inorder(t.rchild)
    }
    //后序遍历
    fun postorder(t: Bnode){
        if (t.lchild != t)
            postorder(t.lchild)
        if (t.rchild != t)
            postorder(t.rchild)
        print(t.data.toString()+" ")
    }
}
