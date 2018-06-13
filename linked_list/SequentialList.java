// 顺序表用一组连续的存储单元来存放数据，数据元素的物理次序与逻辑次序一致。顺序表一般用数据来实现，具体代码如下：


public class SequentialList{

/**
* 用java实现顺序表
* @author:zhangxu
*/

  private static int[] table; //使用数组存储
  private static int MAX_SIZE = 16; //线性表最大容量
  private int listLen = 0;     //线性表长度

  //主函数，调用线性表的实现
  public static void main(String[] args){

    SequentialList seqList = new SequentialList(MAX_SIZE);

    seqList.insertElement(6,8);
    seqList.insertElement(6,9);
    seqList.insertElement(6,10);

    System.out.println(seqList.getElement(3));

    seqList.deleteElement(2);

    System.out.println(seqList.isEmpty());
    System.out.println(seqList.isFull());

    System.out.println(seqList.getLength());

    seqList.printList();
  }
  
   
  //线性表初始化
  public SequentialList(int n){
    table = new int[n];
  }
  
  //非空判断,数组长度为0时，则为空顺序表
  public boolean isEmpty(){
    return listLen == 0; 
  }
  
  //存储溢出判断
  public boolean isFull(){
    return listLen >= table.length;
  }
  
  //数组长度
  public int getLength(){
    return listLen;
  }
  
  //打印
  public void printList(){
    for (int i = 0; i < listLen; i++){
      System.out.println("第"+(i+1)+"个元素：" + table[i]);
    }
  }
  
  //获取线性表第i个元素的值(注意i是从1开始的)
  public int getElement(int i){
    if( i > 0 && i <= listLen){
      return table[i-1];
    }
    return -1; //此处能否改为报异常？
  }
  
  //查看元素是否在顺序表中
  public boolean isElement(int j){
    boolean flag = false;
    for(int i = 0; i < listLen; i++){
      if (j == table[i]){
        flag = true;
      }
      return flag;
    }

    return flag;
  }
  
  //插入元素，将元素j插入到第i个位置(注意i是从1开始的)
  public void insertElement(int i, int k){
    
    //只有当表未满时，才能存放数据
    if(!isFull()){
      //1.给定插入位置不正确
      if(i <= 0){
        i = 1;
      }
      if(i > listLen){
        i = listLen + 1; //listLen是顺序表已存数据的长度
      }
      
      //从最后一个位置到第i个位置，依次向后一位
      for(int j=listLen-1; j >= i-1; j--){
        table[j+1] = table[j];
      }
      table[i-1] = k;
      listLen++; //表长度更新    
    }
    else{
      System.out.println("顺序表空间已满"); //报异常
    }    
  }
  
  //删除元素,删除第i个位置的元素，并返回删除的元素值
  public int deleteElement(int i){
    int value = 0;

    if(!isEmpty()){

      if(i <= 0 || i >= listLen){
        System.out.println("输入不合法");
        return -1; 
      }

      value = table[i-1]; //取出i位的元素值

      for(int j = i-1; j < listLen-1; j++){
        table[j] = table[j+1];
      }

      listLen--; //表长度更新    
    }

    else{
      System.out.println("顺序表已经为空，无法执行删除操作！");
    }

    return value;  
  }


}


