package com.loto.common;

/**
 * @todo 调用第三方API设计的常量
 * 
 * @author xuys
 *	
 * @time 2015-03-09
 */
public class APIConstants {
	/** 获取用户粉丝信息类型  **/
	public static final String WX_AUTH2_SCOPE_BASE = "snsapi_base"; //基本信息，只获取openId
	public static final String WX_AUTH2_SCOPE_ADVANCE = "snsapi_userinfo"; //获取用户的详细信息
	
	/**
	 * 二维码类型
	 */
	public static final String WX_TEMPORATY_TICKET = "QR_SCENE"; //临时二维码
	public static final String WX_EVERLASTING_TICKET = "QR_LIMIT_SCENE"; //永久二维码
	public static final String WX_EVERLASTING_STR_TICKET = "QR_LIMIT_STR_SCENE"; //永久二维码
	
	/** 群发消息类型  **/
	public static final String SEND_MASS_MESSAGE_TYPE_NEWS = "mpnews"; //图文消息
	public static final String SEND_MASS_MESSAGE_TYPE_TEXT = "text"; //文本消息
	public static final String SEND_MASS_MESSAGE_TYPE_VOICE = "voice"; //语音消息
	public static final String SEND_MASS_MESSAGE_TYPE_IMAGE = "image"; //图片消息
	public static final String SEND_MASS_MESSAGE_TYPE_VIDEO = "mpvideo"; //视频消息
	
	/**
	 * 获得基础支持access_token
	 */
	public static final String WEI_XIN_ACCESS_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"; //通用接口获取凭证url
	
	/**
	 * 获取网页授权access_token 
	 */
	public static final String WEI_XIN_AUTH2_ACCESS_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code"; //获取网页授权access_token
	public static final String WEI_XIN_AUTH2_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token"; //刷新access_token
	public static final String WEI_XIN_GET_SNS_USERS_URL = "https://api.weixin.qq.com/sns/userinfo"; //拉取授权用户基本信息
	public static final String WEI_XIN_AUTH2_GET_OPENID = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Config.WEIXIN_APPID
			+ "&redirect_uri=redirectUrl" + "&response_type=code&scope=authScope&state=state#wechat_redirect";
		
	/**
	 * 自定义菜单
	 */
	public static final String WEI_XIN_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/"; //微信定义菜单url
	public static final String WEI_XIN_MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	
	/**
	 * 高级接口
	 */
	//客服接口
	public static final String WEI_XIN_SEND_CUSTOMER_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send"; //发送客服消息
	
	/**
	 * 分组管理(可以使用接口，对公众平台的分组进行查询、创建、修改操作，也可以使用接口在需要时移动用户到某个分组。)
	 */
	//查询分组
	public static final String WEI_XIN_GET_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
	//创建分组
	public static final String WEI_XIN_CREATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
	//修改分组名
	public static final String WEI_XIN_UPDATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
	//移动用户分组
	public static final String WEI_XIN_UPDATE_GROUP_MEMBER_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
	//批量移动用户分组
	public static final String WEI_XIN_BATCH_UPDATE_GROUP_MEMBER_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=";
	//删除分组
	public static final String WEI_XIN_DELETE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=";
	
	/**
	 * 获取用户基本信息
	 */
	public static final String WEI_XIN_GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN&access_token=";
	
	/**
	 * 获取关注者列表
	 */
	public static final String WEI_XIN_GET_USERS_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";
	
	/**
	 * 发送模板消息
	 */
	public static final String WEI_XIN_SEND_TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	
	/** 群发消息  **/
	//预览接口
	public static final String WEI_XIN_MESSAGE_PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token="; //预览发送消息接口
	//群发消息接口
	public static final String WEI_XIN_SEND_MASS_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";
	//上传图文素材
	public static final String WEI_XIN_UPLOAD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";
	
	/**
	 * 推广支持（生成带参数的 二维码）
	 */
	//创建二维码ticket
	public static final String WEI_XIN_CREATE_QRCODE_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="; 
	//通过ticket换取二维码
	public static final String WEI_XIN_SHOW_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="; 
	
	/**
	 * 上传下载多媒体文件
	 */
	public static final String WEI_XIN_UPLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE"; //上传文件
	public static final String WEI_XIN_DOWNLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get"; //下载文件 
	
	/** 素材管理  **/
	public static final String WEI_XIN_MATERIAL_LIST_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
	/** 获取永久素材  **/
	public static final String WEI_XIN_GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
	
	/**
	 * js接口
	 */
	//获得js微信接口临时票据
	public static final String WEI_XIN_JS_API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/** 
	 * 微信支付api列表  
	 * 
	 **/
	//生成预支付订单
	public static final String WEI_XIN_UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	//查询订单
	public static final String WEI_XIN_QUERY_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	
	//关闭订单
	public static final String WEI_XIN_CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
	
	//被扫支付API
	public static final String WEI_XIN_PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

	//被扫支付查询API
	public static final String WEI_XIN_PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//退款API
	public static final String WEI_XIN_REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//退款查询API
	public static final String WEI_XIN_REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//撤销API
	public static final String WEI_XIN_REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//下载对账单API
	public static final String WEI_XIN_DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//统计上报API
	public static final String WEI_XIN_REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";
	
	//转换短连接
	public static final String WEI_XIN_SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
	
	/**
	 * 红包接口
	 */
	//现金红包接口
	public static final String WEI_XIN_SEND_RED_PACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	//红包查询接口
	public static final String WEI_XIN_SEARCH_RED_PACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";
	
	//企业付款接口
	public static final String WEI_XIN_PAY_TRANSFER = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
}
