package com.loto.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * 
 * @author xuys
 *
 * @time 2015年3月18日	
 */
public class ContentUtil {
	/**
	 * @description 替换表情
	 * @author xuys
	 * @time:2013年10月14日 下午1:39:52
	 * @param content
	 * @return
	 */
	public static String replaceEmoji(String content) {
		if (ValidatorUtil.isNull(content)) {
			return "";
		}
		//替换换行符
		content=content.replaceAll("\n", "").replaceAll("\t", "");
		content=content.replaceAll("<p>", "").replaceAll("</br>", "").replaceAll("<br/>", "").replaceAll("<br />", "");
		content=content.replaceAll("</p>", "\n").replaceAll("<p/>", "\n").replaceAll("<br>", "\n");

		Map<String, String> emojiMap = getEmojiMap();
		
		// 替换表情
		String regex = "<img.*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) { 
			String img = matcher.group().toLowerCase(); //转小写
			//匹配图片
			String imgRegex = "js"+".*?images"+".*?.gif";
			Pattern imgPattern = Pattern.compile(imgRegex);
			Matcher imgMatcher = imgPattern.matcher(img);
			while (imgMatcher.find()) {
				String gif = imgMatcher.group().toLowerCase();
				content = content.replace(img, "/"+emojiMap.get(gif));
			}
		}
		content = content.replace("<.*?>/g", "").replace("&amp;/gi", "&").replace("&lt;gi", "<").replace("&gt;gi", ">").replace("&nbsp;gi", " ").replace("&copy;gi", "©").replace("&reg;gi", "®").replaceAll("&nbsp;", " ");
		return content;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map<String, String> getEmojiMap(){
		String emoji = "[{'0': '微笑'},{'1': '撇嘴'},{'2': '色'},{ '3': '发呆'},{'4': '得意'},{'5': '流泪'},{'6': '害羞'},{'7': '闭嘴'},{'8': '睡'},{'9': '大哭'},{"
				+ "'10': '尴尬'},{ '11': '发怒'},{'12': '调皮'},{'13': '呲牙'},{ '14': '惊讶'},{ '15': '难过'},{'16': '酷'},{ '17': '冷汗'},{'18': '抓狂'},{    "
				+ "'19': '吐'},{    '20': '偷笑'},{    '21': '可爱'},{    '22': '白眼'},{    '23': '傲慢'},{    '24': '饥饿'},{    '25': '困'},{    "
				+ "'26': '惊恐'},{    '27': '流汗'},{    '28': '憨笑'},{    '29': '大兵'},{    '30': '奋斗'},{    '31': '咒骂'},{    '32': '疑问'},{   "
				+ " '33': '嘘'},{    '34': '晕'},{    '35': '折磨'},{    '36': '衰'},{    '37': '骷髅'},{    '38': '敲打'},{    '39': '再见'},{    "
				+ "'40': '擦汗'},{    '41': '抠鼻'},{    '42': '鼓掌'},{    '43': '糗大了'},{    '44': '坏笑'},{    '45': '左哼哼'},{    '46': '右哼哼'},{ "
				+ "   '47': '哈欠'},{    '48': '鄙视'},{    '49': '委屈'},{    '50': '快哭了'},{    '51': '阴险'},{    '52': '亲亲'},{    '53': '吓'},{   "
				+ " '54': '可怜'},{    '55': '菜刀'},{    '56': '西瓜'},{    '57': '啤酒'},{    '58': '篮球'},{    '59': '乒乓'},{    '60': '咖啡'},{    "
				+ "'61': '饭'},{    '62': '猪头'},{    '63': '玫瑰'},{    '64': '凋谢'},{    '65': '示爱'},{    '66': '爱心'},{    '67': '心碎'},{    "
				+ "'68': '蛋糕'},{    '69': '闪电'},{    '70': '炸弹'},{    '71': '刀'},{    '72': '足球'},{    '73': '瓢虫'},{    '74': '便便'},{    "
				+ "'75': '月亮'},{    '76': '太阳'},{    '77': '礼物'},{    '78': '拥抱'},{    '79': '强'},{    '80': '弱'},{    '81': '握手'},{    "
				+ "'82': '胜利'},{    '83': '抱拳'},{    '84': '勾引'},{    '85': '拳头'},{    '86': '差劲'},{    '87': '爱你'},{    '88': 'NO'},{    "
				+ "'89': 'OK'},{    '90': '爱情'},{    '91': '飞吻'},{    '92': '跳跳'},{    '93': '发抖'},{    '94': '怄火'},{    '95': '转圈'},{   "
				+ " '96': '磕头'},{    '97': '回头'},{    '98': '跳绳'},{    '99': '挥手'},{    '100': '激动'},{    '101': '街舞'},{    '102': '献吻'},{  "
				+ "  '103': '左太极'},{    '104': '右太极'}]";

		List<Map> emojiList = JSONObject.parseArray(emoji,Map.class);
		
		Map<String, String> emojiMap = new HashMap<String, String>();
		for (Map<String, String> map : emojiList) {
			for (Entry<String, String> entry : map.entrySet()) {  
				emojiMap.put("js/kindeditor/plugins/emoticons/images/"+entry.getKey()+".gif", entry.getValue());
			} 
		}
		
		return emojiMap;
	}
}
