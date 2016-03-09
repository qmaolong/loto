package com.loto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 时间工具类
 * 
 * @author xuys
 *
 * @time 2015年3月12日	
 */
public final class DateUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
	
	/**
	 * 时间日期格式
	 */
	public static final String YYYY_MM_DD_HH_NN_SS_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_NN_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HH_FORMAT = "yyyy-MM-dd HH";
	public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
	public static final String YYYYMMDDHHNNSS_FORMAT = "yyyyMMddHHmmss";
	public static final String YYYYMMDD_FORMAT = "yyyyMMdd";
	public static final String YYYY_MM_DD_HH_NN_SS_CHINESIZE_FORMAT = "DATE_TIME_CHINESIZE"; //时间汉化格式
	public static final String YYYY_MM_DD_CHINESIZE_FORMAT = "DATE_CHINESIZE"; //日期汉化格式
	public static final String YYYY_MM_DD_HH_NN_CHINESIZE_FORMAT = "DATE_TIME_YMDHN_CHINESIZE"; //时间汉化格式
	
	/**
	 * 常用时间值常量化
	 */
	public static final Integer SIXTY_MINUTE_ONE_HOUR = 60; //60分钟
	public static final Integer TWENTY_FOUR_ONE_DAY = 24; //24小时
	public static final Integer ONE_THOUSAND_MILLISECOND = 1000; //1000毫秒
	public static final Integer THREE_KILO_SIX_HUNDRED_ONE_HOUR = 3600; //3600秒
	
	/**
	 * 格式化时间为 yyyy-MM-dd HH:mm格式
	 * @param date
	 * @return
	 */
	public static String formatToyyyyMMddHHmm(Date date){
		if(ValidatorUtil.isNull(date)){
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_NN_FORMAT);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * @description: 时间格式化成字符串
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param date 日期
	 * @param format 日期格式
	 */
	public static String formateDateToStr(Date date, String format){
		if (ValidatorUtil.isNull(date)) {
			date = new Date();
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		
		return simpleDateFormat.format(date);
	}
	
	/**
	 * @description: 格式化日期
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param
	 */
	public static Date formateDate(Date date, String format){
		if (ValidatorUtil.isNull(date)) {
			date = new Date();
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		
		String dateStr = simpleDateFormat.format(date);
		
		Date newDate = formateStrToDate(dateStr, format);

		return newDate;
	}
	
	/**
	 * @description: 字符串转化为日期
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param
	 */
	public static Date formateStrToDate(String dateStr, String format){
		if (ValidatorUtil.isNull(dateStr)) {
			dateStr = formateDateToStr(new Date(), YYYY_MM_DD_HH_NN_SS_FORMAT);
		}
		
		if (ValidatorUtil.isNull(format)) {
			format = YYYY_MM_DD_HH_NN_SS_FORMAT;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			logger.error("字符串转化日期失败！" + e.getMessage(), e);
		}
		
		return date;
	}
	
	/**
	 * @description: 重置日期时间
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param
	 */
	public static Date resetDateTime(Date date, int hour, int minute, int second){
		if (ValidatorUtil.isNull(date)) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		if (hour > -1) {
			calendar.set(Calendar.HOUR_OF_DAY, hour);
		}
		
		if (minute > -1) {
			calendar.set(Calendar.MINUTE, minute);
		}
		
		if (second > -1) {
			calendar.set(Calendar.SECOND, second);
		}
		
		date = calendar.getTime();
		
		return date;
	}
	
	/**
	 * @description: 日期加上天数
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param day 天数
	 */
	public static Date addDay(Date date, int day){
		if (ValidatorUtil.isNull(date)) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.DAY_OF_MONTH, day);
		
		return calendar.getTime();
	} 
	
	/**
	 * @description: 比较日期
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param
	 */
	public static boolean compareDate(Date fDate, Date eDate){
		if (fDate.before(eDate)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description: 比较两个日期差值
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param
	 */
	public static int differDate(Date fDate, Date eDate){
		fDate = formateDate(fDate, YYYY_MM_DD_FORMAT);
		eDate = formateDate(eDate, YYYY_MM_DD_FORMAT);
		
		Long fdateMills = fDate.getTime();
		Long edateMills = eDate.getTime();
		
		long dayDiff = (edateMills - fdateMills) / (TWENTY_FOUR_ONE_DAY * THREE_KILO_SIX_HUNDRED_ONE_HOUR * ONE_THOUSAND_MILLISECOND);
		
		return (int) dayDiff;
	}
	
	/**
	 * @description: 汉化日期
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月18日	
	 * 
	 * @param date 日期
	 * @param fType 格式化类型
	 */
	public static String chinesizeDate(Date date, String fType){
		if (ValidatorUtil.isNull(date)) {
			date = new Date();
		}
		if (ValidatorUtil.isNull(fType)) {
			fType = YYYY_MM_DD_HH_NN_SS_CHINESIZE_FORMAT;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		StringBuffer result = new StringBuffer();
		
		Integer year = calendar.get(Calendar.YEAR);
		Integer month = calendar.get(Calendar.MONTH) + 1;
		Integer day = calendar.get(Calendar.DAY_OF_MONTH);
		Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
		Integer minute = calendar.get(Calendar.MINUTE);
		Integer second = calendar.get(Calendar.SECOND);
		if (YYYY_MM_DD_HH_NN_SS_CHINESIZE_FORMAT.equals(fType)) {
			result.append(year + "年").append(month + "月").append(day + "日")
				.append(hour + "时").append(minute + "分").append(second + "秒");
		}else if(YYYY_MM_DD_CHINESIZE_FORMAT.equals(fType)){
			result.append(year + "年").append(month + "月").append(day + "日");
		}else if(YYYY_MM_DD_HH_NN_CHINESIZE_FORMAT.equals(fType)){
			result.append(year + "年").append(month + "月").append(day + "日")
			.append(hour + "时").append(minute + "分");
		}
		
		return result.toString();
	}
	
	/**
	 * @description: 主方法测试
	 * 
	 * @author xuys
	 *
	 * @time 2015年3月12日	
	 * 
	 * @param
	 */
	public static void main(String[] args) {
		System.out.println(chinesizeDate(new Date(), null));
	}
}
