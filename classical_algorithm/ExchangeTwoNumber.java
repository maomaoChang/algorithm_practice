
public class ExchangeTwoNumber{
	public static void main(String[] args) {
		int x = 9, y = 8;

		swap2(x,y);

		//怎么才能保证实参也跟着变化？
		System.out.println("x: " + x + "\ny: " + y);
	}

	public static void swap1(int x, int y){
		int tmp;

		tmp = x;
		x = y;
		y = tmp;
	}

	public static void swap2(int x, int y){
		x = x + y;
		y = x - y;
		x = x - y;
	}

	public static void swap3(int x, int y){
		//A异或B两次，结果还是A
		x = x^y;
		y = x^y;
		x = x^y;		
	}	
}