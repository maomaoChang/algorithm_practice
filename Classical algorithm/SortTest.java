public class SortTest{
	
}

class SortUtil{

	//1.选择排序
	static void selectSort(int[] arr){
		int temp;

		for(int i = 0; i < arr.length-1; i++){
			for (int j = i+1; j < arr.length ; j++ ) {
				if(arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	//2.冒泡排序的实现方法之一
	static void bubbleSort(int[] arr){
		int temp;
		for(int i = 0; i < arr.length-1; i++){
			//-i可以避免不必要的比较
			for (int j = 0; j < arr.length-1-i ; j++ ) {
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	//2.冒泡排序的实现方法之二,只是循环方式发生了变化
	static void bubbleSort2(int[] arr){
		int temp;
		for(int i = arr.length - 1; i > 0; i--){ //从后往前
			//-i可以避免不必要的比较
			for (int j = 0; j < i ; j++ ) { 
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	//2.冒泡排序的实现方式之三，堆内存中交换过于频繁，可以在栈内存中先存储需要调换的下标，最终一次循环只需要调换一次即可
	static void bubbleSort3(int[] arr){
		
	}
	//3
	//4.
	//5.
}