/**
 * 微信抢红包算法实现
 * @author maomaoChang
 * 方法1：每个人抢到的金额由(0,剩余金额)随机,最后一个人抢到剩下的。(缺点在于每个人的得到的金额期望值逐次递减)
 * 方法2：二倍均值法,每个人抢到的金额由(0,人均剩余金额*2)随机,最后一个人扫尾。(缺点在于除最后一次外，任何一次抢到的金额都要小于人均金额的2倍)
 * 方法3：线段切割法,将红包总额比作绳子,假设N个人抢总金额为M的红包,则将红包提前随机分成M份(M-1个切割点),每次依次取一段即可
 * 方法4：多线程实现
 */

import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;

public class GrabRedPackage{
	public static void main(String[] args) {
		int totalAmount = 10000; //100块钱，等会除以100,得到两位小数
		int totalPerson = 10;

		System.out.println("方法1的结果为：");
		method1(totalAmount,totalPerson);
	}

	public static void method1(int M, int N){
		ArrayList<Integer> list = new ArrayList<>(); //存放已抢到的红包
		int    restAmount = M;
		int    restPerson = N;
		int    temp = 0;
		Random random = new Random();

		for(int i = 0; i < N-1; i++){
			temp = random.nextInt(restAmount / restPerson * 2 - 1) + 1;
			restAmount -= temp;
			restPerson--;
			list.add(temp);
		}
		list.add(restAmount);


		for(Integer d : list){
			System.out.print(new BigDecimal(d).divide(new BigDecimal(100)) + "\t");
		}

	}


}