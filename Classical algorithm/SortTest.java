public class SortTest{
	public static void main(String[] args) {
		int[] array = {7,4,2,8,4,5,9,10};
		int[] array2 = {5,7,3,2,6,8,4};
		SortUtil.quickSort(array2);
		SortUtil.printArray(array2);
	}
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

	//1.选择排序的实现方式之二，堆内存中交换过于频繁，可以在栈内存中先存储需要调换的下标，最终一次循环只需要调换一次即可
	static void selectSort2(int[] arr){
		int temp,k;

		for(int i = 0; i < arr.length-1; i++){
			k = i;
			for (int j = i+1; j < arr.length ; j++ ) {
				if(arr[k] > arr[j]){
					k = j;
				}
			}
			if(k!=i){
				temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;	
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


	//3-1.快速排序入口
	static void quickSort(int[] arr){
		if(arr.length > 0){
			quickSortImpl(arr, 0, arr.length -1);
		}
	}

	//3-2. 快速排序具体实现
	static void quickSortImpl(int[] arr, int low, int high){
		if(low < high){
			int middle = getMiddle(arr,low,high);
			quickSortImpl(arr,0,middle-1); //前半部分数组再排序
			quickSortImpl(arr,middle+1,high);//后半部分
		}
	}

	//3-3. 快排中间过程,找基准值
	private static int getMiddle(int[] arr, int low, int high) {
		int temp = arr[low];//基准元素
		while(low<high){
		    //找到比基准元素小的元素位置
		    while(low<high && arr[high]>=temp){
		        high--;
		    }
		    arr[low] = arr[high]; //将低于基准元素的high位置元素放到前面去
		    while(low<high && arr[low]<=temp){
		        low++;
		    }
		    arr[high] = arr[low]; //将在low位,但值大于基准元素的数据放到high位置
		}
		arr[low] = temp; //此时low=high
		return low;
	}


	//4.
	//5.
	//
	
	static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}


}