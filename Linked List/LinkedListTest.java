/**
 * Linked List实现
 * @author:maomaochang
 * @date: 2018-06-04
 */
import java.util.Random;

public class LinkedListTest{

	public LinkedListImpl L;

	class LinkedListImpl{
		int data;            //数据域
	    LinkedListImpl next; //指针域
	}	

	public static void main(String[] args) {
		//测试入口
		LinkedListTest test = new LinkedListTest();

		test.createList(8);
		
	}

	//读取第k个节点
	public int getNode(LinkedListImpl L, int k){

		int value; //返回值定义
		int j = 0;
		LinkedListImpl p = L; //定义p指向头结点

		while ( p.next==null && j < k){
			p = p.next;
			j++ ;
		}

		if( p.next!=null || j > k){
			return -1; //没有第k个结点
		}
		value = p.data;
		return value;
	}

	//遍历
	//插入
	//删除
	//整表创建,长度为N的单链表
	public void createList(int N){
		//1.声明结点P和计数器变量i
		//2.初始化空链表L
		//3.L的指针域设为空，即建立一个带头结点的单链表
		//4.循环
		//	生成新结点赋值给p
		//	随机生成的数字赋值给p.data
		//	将p插入到头结点与前一个新结点之间
		LinkedListImpl p = new LinkedListImpl();
		p.next = null; //头结点
		L = p;        //初始化L为空指针

		Random random = new Random(); //随机数生成器

		for( int i = 0; i < N; i++){
			p = new LinkedListImpl();
			p.data = random.nextInt();
			p.next = L.next;
			L.next = p;
		}
	}


	//整表删除 
	
}

