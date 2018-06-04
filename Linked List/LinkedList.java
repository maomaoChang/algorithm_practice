/**
 * Linked List实现
 * @author:maomaochang
 * @date: 2018-06-04
 */

publis class LinkedList{

	public static void main(String[] args) {
		//测试入口
		
	}

	//读取第k个节点
	public int getNode(LinkedListImpl L, int k){

		int value; //返回值定义
		int j = 0;
		LinkedListImpl p = L; //定义p指向头结点

		where ( p.next && j < k){
			p = p.next;
			j++
		}

		if(!p || j > k){
			return -1; //没有第k个结点
		}
		value = p.data;
		return value;
	}

	//遍历
	//插入
	//删除
	//整表创建
	//整表删除 
}

class LinkedListImpl{
	int data;            //数据域
    LinkedListImpl next; //指针域

    String toString(){
    	return this.data + "";
    }
}