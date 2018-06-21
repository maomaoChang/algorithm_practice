/**
 * 字典序算法
 * 应用：给定一个正整数,求出离该整数最近的大于自身的换位数
 * 步骤：1.从后向前,查找逆序区域,并标记逆序左侧边界index
 *      2.将逆序区域中的最小数和[index-1]位置的元素互换位置
 *      3.将逆序区域转为顺序排列
 */
public class DictorySequence{
	public static void main(String[] args) {
		//1.以int型数组标示待排列数组
		int[] array = new int[]{1,2,3,4,9,8,7,6,5};

		//2.查找边界index
		int index = findBoundaryIndex(array);
		if(index == 0){
			System.out.println("序列已经是完全逆序数,无法找到符合要求的换位数！");
		}
		//3.位置转换
		exchangePosition(array,index);
		//4.原逆序区域排序
		reSortArray(array,index);

		System.out.println("字典序处理后的结果为：");
		for(int x : array){
			System.out.print(x + "\t");
		}		

	}


	//步骤1.求逆序左侧边界
	public static int findBoundaryIndex(int[] array){
		int index = 0;

		for(int i = array.length-1; i > 0; i--){
			if(array[i-1] < array[i]){
				index = i;
				break;
			}
		}

		return index; //index等于0,表示原序列已经是最大的数,如54321,无法再找到满足要求的换位数
	}

	//步骤2.将array[index-1] 与 逆序区域的最小数交换
	public static void exchangePosition(int[] array, int index){
		int temp = array[index-1];
		for(int j = array.length-1; j > 0; j--){
			if(temp < array[j]){ //从后往前,找到第一个比temp大的数
				array[index-1] = array[j];
				array[j] = temp;
				break; 
			}
		}
	}


	//步骤3.逆序区域重新排列
	public static void reSortArray(int[] array, int index){
		for(int i=index,j=array.length-1; i<j; i++,j--){
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

	}
}