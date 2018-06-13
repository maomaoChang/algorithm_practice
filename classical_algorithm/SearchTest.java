public class SearchTest{
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,8,9,10};
		int[] array2 = {1,2,3,4,5,6,7,8,9,10};
		int k = 7;

		System.out.println("k的位置在： " + SearchUtil.BinarySearch2(array2,k) + "(-1表示在数组中未找到该值)" );
	}
}

class SearchUtil{

	static int BinarySearch(int[] arr, int k){

		int min=0,max=arr.length-1,mid;
		mid = (min + max) / 2;
		while(k != arr[mid]){
			if( k > arr[mid] ){
				min = mid + 1;
			}
			if( k < arr[mid]){
				max = mid - 1;
			}

			if(min > max){
				return -1 ; //在数组arr中没找到k，因为没找到的话，最终min和max均指向距离k最近的数，再经过一次循环，min>max
			}

			mid = (min + max ) / 2;
		}
		return mid; //返回k在数组中的位置
	}

	//二分查找的实现方式二
	static int BinarySearch2(int[] arr, int k){
		int min=0, max = arr.length-1,mid;
		mid = (min + max) / 2;

		while(min <= max){
			mid = (min + max) >> 1; //位运算比较快
			if( k > arr[mid]){
				min = mid + 1;
			}
			else if( k < arr[mid]){
				max = mid - 1;
			}
			else 
				return mid; //找到k的位置并返回 //位运算比较快
		}

		return -1; //未找到
	}
}