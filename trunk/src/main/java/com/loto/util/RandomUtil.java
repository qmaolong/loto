package com.loto.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
  * @Description: 随机数工具类
  * @author xuys
  * @date 2013年10月3日 下午7:53:17
 */
public class RandomUtil {
	/**
	  * @description 获得指定范围内的随机数
	  * @author xuys
	  * @time:2013年10月3日 下午7:53:29
	  * @param max
	  * @param min
	  * @return
	 */
	public static int genRandomNumber(int max, int min) {
		int num = 1;

		if (min > max) {
			return min;
		}

		Random random = new Random();

		num = random.nextInt(max - min + 1) + min;

		return num;
	}

	/**
	  * @description 获得指定位数的的随机数字符串
	  * @author xuys
	  * @time:2013年10月3日 下午7:53:42
	  * @param len
	  * @return
	 */
	public static String genRandomNumberString(int len) {
		String str = "";
		if (len > 0) {
			while (len > 0) {
				str = str + genRandomNumber(9, 0);
				len--;
			}
		}
		return str;
	}
	
	/**
	  * @description 获得概率随机数
	  * @author xuys
	  * @time:2013年10月31日 上午10:51:50
	  * @param randomMap
	  * @return
	 */
	public static Integer generateProbabilityNumber(Map<Integer, Double> randomMap){
		if (ValidatorUtil.isNull(randomMap)) {
			return 0;
		}
		//迭代map
		Iterator<Integer> iterator = randomMap.keySet().iterator();
		Double randomRate = Math.random();
		Double totalRate = 0d;
		while (iterator.hasNext()) {
			Integer rateKey = iterator.next();
			Double rate = randomMap.get(rateKey);
			if (randomRate >= totalRate && randomRate < totalRate + rate) {
				return rateKey;
			}
			totalRate = totalRate + rate;
		}
		return 0;
	}

	/**
	 * 作者: xuys
	 * 
	 * 版本: 2012-12-06 v1.0
	 * 
	 * 日期: 2012-12-06
	 * 
	 * 描述: 主方法测试
	 */
	public static void main(String[] args) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		map.put(1, 0.02);
		map.put(2, 0.35);
		map.put(3, 0.24);
		map.put(4, 0.05);
		map.put(5, 0.03);
		map.put(6, 0.01);
		
		for (int i = 0; i < 100; i++) {
			System.out.print(RandomUtil.generateProbabilityNumber(map)+" ");
			if((i+1)%10 == 0){
				System.out.println();
			}
		}
		
		//System.out.println(RandomUtil.genRandomNumberString(18));
	}
}
