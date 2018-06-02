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
     a:纵向检查, (x,y-t)的值不为1
     b:左斜上方, (x-t,y-t)的值不为1
     c:由斜上方, (x+t,y-t)的值不为1
   4.
 */

public class EightQueen{

 	private static final int MAX_QUEEN = 8;
 	private int[][] chessBoard;

 	public EightQueen(){
 		this.chessBoard = new int[MAX_QUEEN][MAX_QUEEN];
 	}
 	


 	public static void main(String[] args) {
 		System.out.println("hello world!");


 		EightQueen queen = new EightQueen();
 		queen.setLocation2(0); //从第1个皇后开始
 		queen.printSolution();

 		//queen.putQueen();
 	}

 	//检查当前位置能否摆放皇后,true:可以放，false:不能放
 	public boolean checkLocation(int x, int y){

 		for(int i = 0; i < y; i++){
            //纵向
 			if(chessBoard[x][i] == 1){
 				return false;
 			}
 			//左斜上方
 			if(x-1-i >= 0 && chessBoard[x-1-i][y-1-i] == 1){
 				return false;
 			}
 			//右斜上方
 			if(x+1+i < MAX_QUEEN && chessBoard[x+1+i][y-1-i] == 1){
 				return false;
 			}
 		}
 		return true; 
 	}

 	//摆放
 	public boolean setLocation(int y){
 		if(y == MAX_QUEEN){
 			return true; //最后一个皇后摆放完毕
 		}

 		for(int i = 0; i < MAX_QUEEN; i++){
 			for(int x=0; x < MAX_QUEEN; x++){
 				chessBoard[x][y] = 0;
 			}

 			if(checkLocation(i,y)){
 				chessBoard[i][y]=1;
 				if(setLocation(y+1)){
 					return true;
 				}
 			}
 		}
 		return false;
 	}

 	//打印摆放方案
 	public void printSolution(){
 		for(int i = 0; i < MAX_QUEEN; i++){
 			//第i行
 			for (int j = 0; j < MAX_QUEEN ; j++) {
 				System.out.print(chessBoard[i][j]);
 			}

 			System.out.println();
 		}
 	}
 }
