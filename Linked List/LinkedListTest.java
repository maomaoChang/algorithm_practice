/**
 * Linked List实现
 * @author:maomaochang
 * @date: 2018-06-04
 */
import java.util.Random;

public class LinkedListTest{

	public static Node  L; //单链表定义

	public static void main(String[] args) {
		//测试入口
		LinkedListTest test = new LinkedListTest();
		//test.createList(0);
		test.createList2(5); //头插法创建链表
		test.printList(L);
		System.out.println("链表L的长度为：" + test.getLength(L));
		System.out.println("第3个结点为：" + test.getNode(L,3));
		System.out.println("插入结果：" + test.insertNode(new Node(888),6));
		System.out.println("链表L的长度为：" + test.getLength(L));
		System.out.println("第3个结点为：" + test.getNode(L,3));
		test.printList(L);
		System.out.println("删除的结点为：" + test.deleteNode(0));
		test.printList(L);
		System.out.println("链表L的长度为：" + test.getLength(L));
		System.out.println("清空链表是否成功： " + test.clearList(L));
		System.out.println("清空后链表L的长度为：" + test.getLength(L));
		
	}

	//读取第k个节点
	public int getNode(Node  L, int k){

		int value; //返回值定义
		int j = 1; //从第一个结点开始
		Node  p = L.next; //定义p从头结点不断后移

		//添加判断,k<=0,应返回第一个结点
		if(k <= 0) k=1;

		while ( p.next != null && j < k){
			p = p.next;
			j++ ;
		}
		
		if( j < k){ //到链表末尾了,仍旧未到k
			return -1; //没有第k个结点
		}

		value = p.data;
		return value;
	}

	//获取链表长度
	public int getLength(Node L){
		if(L.next == null){
			return -1; //空链表
		}

		int len = 0;
		Node p = L;
		while(p.next != null){
			len++;
			p = p.next;
		}
		return len;
	}

	//插入结点,为k位置
	public boolean insertNode(Node q, int k){
		if(k <= 0){ //插入首部
			k=1;
		}

		Node p = L;
		int j = 1; //从第一个结点开始
		//注意条件里写j++和在循环里写j++的区别
		while( p != null && j < k){ 
			p = p.next;
			j++;
		}
		//System.out.println(j);
		if( p == null || j < k){
			return false; //插入位置不正确
		}

		q.next = p.next;
		p.next = q;

		return true; 
	}
	//删除结点
	public int deleteNode(int k){

		//1.判断k是否合法 
		if(k <= 0){
			k = 1; //默认删除第一个结点
		}
		//2.遍历链表,找到第k个结点
		Node p = L;
		int j = 1;
		int value;
		while ( p != null && j < k){
			p = p.next;
			j++;
		}
		//3.删除该结点,并返回第k个结点的value
		if( p.next == null || j < k){ //这里能否和插入结点保持统一？
			return -1; //表示无第k个结点
		}

		value = p.next.data;
		p.next = p.next.next;
		return value;
	}
	
	//整表创建,长度为N的单链表(新)
	public void createList(int N){
		//1.声明结点P和计数器变量i
		//2.初始化空链表L
		//3.L的指针域设为空，即建立一个带头结点的单链表
		//4.循环
		//	生成新结点赋值给p
		//	随机生成的数字赋值给p.data
		//	将p插入到头结点与前一个新结点之间
		Node  p = new Node ();
		p.next = null; //头结点
		L = p;         //初始化L为带头结点的单链表
		int temp; //用于存放每次传入的值,并打印

		Random random = new Random(); //随机数生成器

		for( int i = 0; i < N; i++){ //初始化N个结点，实际上算上头结点，共N+1个结点
			temp = random.nextInt(100);
			System.out.println("第"+(i+1)+"次生成的结点为："  + temp);
			p = new Node (temp);
			p.next = L.next; //使p接管L的后继
			L.next = p;      //成为L后的第一个结点
		}
	}
	//整表创建2,将新增结点放入尾部，而非头部
	public void createList2(int N){
		
		L = new Node(); //空链表定义
		L.next = null;

		Node q = L, p; //定义q为指向尾部的指针
		int temp;

		Random random = new Random();
		for( int i = 0; i < N; i++){
			temp = random.nextInt(100);
			System.out.println("第"+(i+1)+"次生成的结点为："  + temp);
			p = new Node (temp);
			p.next = q.next; //使p得next为null
			q.next = p;     //q为p之前得结点
			q = p;          //q变为尾巴结点
		}
		//如果此前不指定L为空链表,则此处需要定义q的next为空,表示链表结束
		//q.next = null;

	}


	//整表删除
	public boolean clearList(Node L){

		//整表删除,不同于C++中需要free每一个结点,只要使L头结点的指针域为null即可
		L.next = null; 
		//L = null; //为什么这句就不行？
		return true;
	}
	
	//链表的冒泡排序
	
	//链表的选择排序
	
	//打印链表内容
	public void printList(Node L){
		int i = 0;
		Node p = L;
		/*do {
			p = p.next; //应添加判断,防止L为空链表
			System.out.println("第"+((i++)+1)+"个结点的值为: " + p.data);
		}while( p.next != null);*/

		while(p.next != null){ //如果L只包含一个头结点，则没有值供打印
			p = p.next;
			System.out.println("第"+((i++)+1)+"个结点的值为: " + p.data);
		}
	}
	
}


//内部类,链表结点定义
class Node {
	int  data;  //数据域
    Node next; //指针域

    Node(){ //保留空构造函数

    }
    Node(int data){
    	this.data = data;
    }
}

