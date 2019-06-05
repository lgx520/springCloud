package swagger.test;

import org.junit.Test;

public class NumTest {
	
	/**
	 * 算 法： 找出数组中第二大的数
	 * 
	 *思路解析： 如果数组当前元素大于最大数，则更新第二大的数为当前最大数，更新最大数为当前元素；
	 * 如果当前元素小于最大数，则与第二大的数比较，如果大于第二大的数，则更新第二大的数为当前元素。
	 * @author Neil
	 */
	@Test
	public void countMaxMin() {
		int[] array = {7,11,2,59,60};
		//最大数 max
		//第二大数 min
		Integer max = array[0], min = Integer.MIN_VALUE;

		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) { 
				min = max;  
				max = array[i]; 
			} else {  
				if (array[i] > min) {  
					min = array[i]; 
				}
			}
		}
		System.out.println(min);
	}
	
	/**
	 * 公鸡5元一只，母鸡3元一只，小鸡1元三只，问100元怎样可以买100鸡？
	 * 思路解析： 先算出公鸡、母鸡最大可买多少只，然后进行循环，最后进行判断和是否为100，
	 * 并且是否小鸡%3能等于0
	 */
	@Test
	public void test() {
		int cock, hen, small = 0; //1次
		for (cock = 0; cock <=19; cock++) { //20次
			for (hen = 0; hen <= 33; hen++) {  //20*33次
				small = 100 - cock - hen; //20*33次
				
				if ((cock * 5 + hen * 3 + small / 3) == 100 && small % 3 == 0 ) {
					System.out.println("可买公鸡:"+cock);
					System.out.println("可买母鸡:"+hen);
					System.out.println("可买小鸡:"+small);
				}
			}
		}
	}
	
	@Test
	public void test1() {

	}
}
