/**
 * 八皇后问题：经典递归回溯算法
 * 问题描述：在8*8的棋盘上放置8个皇后，使其不能互相攻击(任意两个皇后都不能处于同一行、同一列、或者同一条斜线)
 * 解题思路：
 * 1.所谓递归回溯，本质上是一种枚举法。这种方法从棋盘的第一行开始尝试摆放第一个皇后，摆放成功后，递归一层，再遵循规则在棋盘第二行来摆放第二个皇后。
     如果当前位置无法摆放，则向右移动一格再次尝试，如果摆放成功，则继续递归一层，摆放第三个皇后......

     如果某一层看遍了所有格子，都无法成功摆放，则回溯到上一个皇后，让上一个皇后右移一格，再进行递归。如果八个皇后都摆放完毕且符合规则，
     那么就得到了其中一种正确的解法。
   2.定义二位数组A[8][8],int型。0表示没有摆放皇后，1表示已经摆放皇后
   3.如何检查拟摆放皇后的位置(x,y)是否符合要求：
     a:纵向检查, (x-t,y)的值不为1
     b:左斜上方, (x-t,y-t)的值不为1
     c:由斜上方, (x+t,y-t)的值不为1
   4.
 */

public class EightQueen{

 	private static final int MAX_QUEEN = 8; //后期适度扩展至多皇后(>8)问题，并测试该写法的性能
 	private static int[][] chessBoard;
 	private static int count=0;            //结果计数器

 	public EightQueen(){
 		this.chessBoard = new int[MAX_QUEEN][MAX_QUEEN];
 	}
 	


 	public static void main(String[] args) {
 		//对象初始化
 		EightQueen queen = new EightQueen();

 		queen.setLocation(0); //从第1个皇后开始
 		/* 
 		 //调试checkLocation方法
 		chessBoard[0][0] = 1;
 		chessBoard[1][2] = 1;
 		chessBoard[2][4] = 1;
 		chessBoard[3][1] = 1;
 		chessBoard[4][3] = 1;
 		int t = 5;
 		for (int m = 0; m < MAX_QUEEN; m++){
 			System.out.println(t+","+m+" : "+queen.checkLocation(t,m));	
 		} 		
	    */
 		queen.printSolution();


 		
 	}

    //摆放皇后
 	public boolean setLocation(int x){

 		if(x == MAX_QUEEN){
 			return true; //最后一个皇后摆放完毕
 		}

 		for(int i = 0; i < MAX_QUEEN; i++){
 			//
 			for(int j=0;  j < MAX_QUEEN; j++){
 				chessBoard[x][j] = 0; //清空之前该行的摆放结果，并重新计算
 			}

 			if(checkLocation(x,i)){

 				chessBoard[x][i]=1;
 				//(x,i)位置已符合要求，置为1，并开始安排下一行，即x+1
 				if(setLocation(x+1)){
 					return true; 	
 				}
 			} 			
 		}

 		return false; //返回false,表示该行无论如何摆放都无法满足要求,回溯到上一层,重新评估月上一层的(x,i+1)位置
 	} 

 	//检查当前位置能否摆放皇后,true:可以放，false:不能放
 	public boolean checkLocation(int x, int y){

 		for(int i = 1; i <= x; i++){
            //纵向
 			if(x-i >= 0 && chessBoard[x-i][y] == 1){
 				return false;
 			}
 			//左斜上方
 			if(y-i >= 0 && chessBoard[x-i][y-i] == 1){
 				return false;
 			}
 			//右斜上方
 			if(y+i < MAX_QUEEN && chessBoard[x-i][y+i] == 1){
 				return false;
 			}
 		}
 		return true; 
 	} 	


 	//打印摆放方案
 	public void printSolution(){
 		for(int i = 0; i < MAX_QUEEN; i++){
 			for (int j = 0; j < MAX_QUEEN ; j++) {
 				System.out.print(chessBoard[i][j] + " ");
 			}

 			System.out.println();
 		}
 	}
 }
