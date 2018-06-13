/**
 * Linked List实现
 * @author:maomaochang
 * @date: 2018-06-04
 */
import java.util.Random;
import java.util.Stack;
import java.util.Enumeration;

public class LinkedListTest{

	public static  Node  L; //单链表定义

	public static void main(String[] args) {
		//测试入口
		//LinkedListTest test = new LinkedListTest();
		//test.createList(0);
		System.out.println("生成结点过程：");
		createList2(5); //头插法创建链表
		//printList(L);
		//System.out.println("链表L的长度为：" + getLength(L));
		//System.out.println("第3个结点为：" + getNode(L,3));
		System.out.println("插入结果888至末尾：" + insertNode(new Node(888),6));
		//System.out.println("链表L的长度为：" + getLength(L));
		//System.out.println("第3个结点为：" + getNode(L,3));
		System.out.println("插入尾结点888后: ");
		printList(L);
		System.out.println("删除的结点为：" + deleteNode(0));
		System.out.println("删除首结点后: ");
		printList(L);
		//System.out.println("链表L的长度为：" + getLength(L));
		//System.out.println("清空链表是否成功： " + test.clearList(L));
		//System.out.println("清空后链表L的长度为：" + test.getLength(L));
		
		//System.out.println("用递归实现的递归打印链表：");
		
		//test.printReverse1(L);

		//System.out.println("链表反转以后为: ");
		//test.reverseList1(L);//
		//printList(reverseList2(L));

		System.out.println("倒数第" + 2 + "个结点的值为：" + findKofBack(L,2));
		
	}

	//读取第k个节点
	public static int getNode(Node  L, int k){

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
	public static int getLength(Node L){
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
	public static boolean insertNode(Node q, int k){
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
	public static int deleteNode(int k){

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
	public static void createList(int N){
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
	public static void createList2(int N){
		
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
	public static boolean clearList(Node L){

		//整表删除,不同于C++中需要free每一个结点,只要使L头结点的指针域为null即可
		L.next = null; 
		//L = null; //为什么这句就不行？
		return true;
	}
	
	//链表的冒泡排序
	
	//链表的选择排序
	
	//链表从尾到头打印,用递归实现
	public static void printReverse1(Node L){
		//L是头结点,第一个结点为L.next
		if( L.next != null){
			printReverse1(L.next);
			System.out.println(L.next.data);
		}
	}

	//链表从尾到头打印,用堆栈实现
	public static void printReverse2(Node L){

		Stack<Integer> stack = new Stack<Integer>();
		
		if(L != null){
			Node p = L.next;
			while(p != null){				
				stack.add(p.data);	
				p = p.next;		
			}			
		}

		int stackSize = stack.size();
		System.out.print("用堆栈实现的逆序打印： ");
		while(stackSize-- > 0){
			System.out.print(stack.pop()+"  ");
		}

		/*
		//打印堆栈内容
		if (stack.empty()){
		     System.out.println("堆栈是空的，没有元素");
		}
		else {
		        System.out.print("堆栈中的元素：");
		        Enumeration items = stack.elements(); // 得到 stack 中的枚举对象
		        while (items.hasMoreElements()) //显示枚举（stack ） 中的所有元素
		            System.out.print(items.nextElement()+" ");
		}
        */


	}

	//链表反转实现1(当链表没有头结点时)
	public static void reverseList1(Node L){

		if(L == null){
            System.out.println("空链表,无法反转");
        }

		Node p = L; //L若没有头结点,则p初始指向第一个结点
		Node prior = null; //p结点的前继结点
		Node pNext = null; //p结点的后继结点
		//Node newL = null;//新链表的表头 

		while( p != null){
			pNext = p.next; //先获取后继结点

			if(pNext == null){
				L = p; //L指向新链表的末尾,循环结束
				break;
			}

			p.next = prior;

			prior = p;
			p = pNext;
		}		
	}

	//链表反转实现2(当链表由头结点时)
    public static Node reverseList2(Node L){

    	if(L.next == null){
            System.out.println("空链表,无法反转");    		
    	}
		Node p = L.next; 
		Node prior = null; //p结点的前继结点
		Node pNext = null; //p结点的后继结点
		Node newHead = null; //返回新链表(如果操作才能使得L指向新链表)

		while(p != null) {

			pNext = p.next;

			if(pNext == null){
				Node endNode = new Node();
				endNode.next = p;
				newHead = endNode; //新链表的表头
				//break; //此处不能用break,因为还没定义p的前继
			}
			p.next = prior; //定义p前驱
			prior = p;      //前驱后移
			p = pNext;      //当前结点后移
		}

		return newHead;
    }

	//查找链表倒数第K个元素,先遍历获取链表长度,然后再第二次遍历
	public static int findKofBack(Node L, int k){

		if( L.next == null){
			System.out.println("空链表,无法获取第" + k + "个值");
			return -999;
		}

		int len = 0;
		Node p = L;
		while(p.next != null){
			p = p.next;
			len++;
		}

		p = L; // 遍历完成后,p重新指向表头

		if(len < k){
			System.out.println("链表总长度为" + len + " , 小于" + k);
			return -999;
		}

		for(int i = 1; i <= len+1-k; i++){
			p=p.next;
		}

		return p.data; 
	}
	
	//打印链表内容
	public static void printList(Node L){
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

