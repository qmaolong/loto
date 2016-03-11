package com.loto.common;

/**
 * @todo:常量类
 * 
 * @author:xuys
 * 
 * @time:2015-3-9 上午10:22:44
 * 
 */
public class Constant {
	/** 全局常量值  **/
	public static final Integer GLOBAL_NO = 0;
	public static final Integer GLOBAL_YES = 1;
	
	/** 数据状态  **/
	public static final Integer DATA_STATUS_DISABLE = 0; //停用
	public static final Integer DATA_STATUS_ENABLE = 1; //启用 
	public static final Integer DATA_STATUS_DELETED = 2; //删除
	public static final Integer DATA_STATUS_DRAFT = 3; //草稿
	
	/**
	 * http请求方式
	 */
	public static String HTTP_GET = "GET"; //get
	public static String HTTP_POST = "POST"; //post
	
	/**
	 * 编码方式
	 */
	public static String ENCODE_UTF8 = "UTF-8";
	
	/** 系统用户类型  **/
	public static final Integer USER_TYPE_WX_USER = 1; //微信用户
	public static final Integer USER_TYPE_SYSTEM = 2; //系统用户
	public static final Integer USER_TYPE_MECHANIC = 3; //机械师
	
	/**
	 * 回复类型
	 */
	public static final Integer WX_REPLY_TYPE_CONCERNED = 0; //关注回复
	public static final Integer WX_REPLY_TYPE_DEFAULT = 1; //默认回复
	public static final Integer WX_REPLY_TYPE_FIRST_CONCERNED = 2; //首次关注回复
	
	/**
	 * 开发模式 
	 */
	public static final String SYS_DEV_MODE_DEV = "dev"; //开发环境
	public static final String SYS_DEV_MODE_TEST = "test";
	public static final String SYS_DEV_MODE_PRODUCT = "product"; //生产环境
	
	/** 
	 * 验证码类型
	 */
	public static final String WX_VERIFY_CODE_TYPE_DRAW_COUPON = "code.draw.coupon"; //领券验证码
	public static final String WX_VERIFY_CODE_TYPE_TAKE_PACK = "code.take.pack"; //现金红包验证码
	
	/**
	 * 订单号生成方式
	 */
	public static final String ORDER_SERVICE_TYPE_WX = "11";
	public static final String ORDER_SERVICE_TYPE_PLATFORM = "10";
	
	/**
	 * 支付入口
	 */
	public static final Integer ORDER_SOURCE_NORMAL = 0;
	public static final Integer ORDER_SOURCE_DETAIL = 1;
	public static final Integer ORDER_SOURCE_ACTIVITY = 2;
	
	/**
	 * 微信回复消息类型
	 */
	public static final Integer WX_MSG_TYPE_TEXT = 0; //文本消息
	public static final Integer WX_MSG_TYPE_IMAGE = 1; //图片消息
	public static final Integer WX_MSG_TYPE_ITEM = 2; //图文消息
	public static final Integer WX_MSG_TYPE_ACTIVITY = 3; //活动图文消息
	public static final Integer WX_MSG_TYPE_LOCATION = 4; //地理位置消息
	public static final Integer WX_MSG_TYPE_LINK = 5; //链接消息
	public static final Integer WX_MSG_TYPE_EVENT = 6; //事件消息
	public static final Integer WX_MSG_TYPE_MUSIC = 7; //语音或音乐消息
	
	/**
	 * 业务通知消息模板
	 */
	public static final Integer WX_TEMPLATE_SERVICE_ORDER_NOTIFY = 1000; //服务预约通知
	public static final Integer WX_TEMPLATE_SERVICE_ACCEPT_NOTIFY = 1010; //服务受理通知
	public static final Integer WX_TEMPLATE_DETECTION_REPORT = 1020; //车辆检测报告
	public static final Integer WX_TEMPLATE_ORDER_PAY_NOTIFY = 1030; //订单支付成功通知
	public static final Integer WX_TEMPLATE_SERVICE_INFO_REMIND = 1040; //服务信息提醒
	public static final Integer WX_TEMPLATE_SERVICE_RESERVATION_NOTIFY = 1050; //服务预约提醒
	public static final Integer WX_TEMPLATE_ORDER_MAINTENANCE_MATURITY = 1060; //保养到期
	public static final Integer WX_TEMPLATE_ORDER_SERVICE_FINISH = 1070; //订单服务完成
	public static final Integer WX_TEMPLATE_COUPON_DRAW_NOTIFY = 1080; //优惠券领取通知
	
	/**
	 * 订单相关推送通知业务类型
	 */
	public static final Integer WX_ORDER_NOTIFY_TYPE_TAKE_ORDER = 10; //下单成功
	public static final Integer WX_ORDER_NOTIFY_TYPE_ACCEPT_ORDER = 20; //受理订单 
	public static final Integer WX_ORDER_NOTIFY_TYPE_START_SERVICE = 30; //出发服务
	public static final Integer WX_ORDER_NOTIFY_TYPE_FINISH_ORDER = 40; //完成订单
	public static final Integer WX_ORDER_NOTIFY_TYPE_CANCLE_ORDER = 50; //取消订单
	public static final Integer WX_ORDER_NOTIFY_TYPE_VEHICLE_REPORT = 60; //车辆报告
	public static final Integer WX_ORDER_NOTIFY_TYPE_SERVICE_RESERVATION = 70; //服务预约
	public static final Integer WX_ORDER_MAINTENANCE_MATURITY = 80; //保养到期
	public static final Integer WX_ORDER_SERVICE_FINISH = 90; //服务完成
	public static final Integer WX_COUPON_DRAW_NOTIFY = 100; //领券通知
	public static final Integer WX_ORDER_NOTIFY_TYPE_MODIFY_ORDER = 110;//订单修改
	public static final Integer WX_ORDER_NOTIFY_TYPE_START_OFF = 120; //开始服务
	public static final Integer WX_APPOINTMENT_NOTIFY_INTEGER = 130; //预约成功
	
	/**
	 * 微信事件类型
	 */
	public static final String WX_EVENT_CLICK = "CLICK"; //菜单点击事件
	public static final String WX_EVENT_SUBSCRIBE = "SUBSCRIBE"; //关注公众号事件
	public static final String WX_EVENT_UNSUBSCRIBE = "UNSUBSCRIBE"; //取消关注公众号事件
	public static final String WX_EVENT_VIEW = "VIEW"; //菜单链接跳转事件
	public static final String WX_EVENT_LOCATION = "LOCATION"; //地理位置定位事件
	
	/**
	 * 验证码来源
	 */
	public static final Integer SYS_VERIFY_CODE_SOURCE_REGISTER = 0; //注册获取验证码
	public static final Integer SYS_VERIFY_CODE_SOURCE_LOGIN = 1; //登录获取验证码 
	public static final Integer SYS_VERIFY_CODE_SOURCE_RESET_PASSWORD = 2; //重置密码获取验证码 
	public static final Integer SYS_VERIFY_CODE_SOURCE_ORDER = 3; //下单获取验证码 
	public static final Integer SYS_VERIFY_CODE_SOURCE_ACTIVE_MEMBER = 4; //激活会员
	
	/**
	 * 保养类型
	 */
	public static final Integer WX_ORDER_TYPE_MAINTAINCE = 1; //上门保养
	public static final Integer WX_ORDER_TYPE_HAZE_FILTER = 2; //防霾滤清器
	public static final Integer WX_ORDER_TYPE_FREE_TESTING = 3; //免费检测
	public static final Integer WX_ORDER_TYPE_STERILIZATION_DEODORIZATION = 4; //杀菌除异味
	public static final Integer WX_ORDER_TYPE_NACELLE_WASH = 5; //发动机舱清洗
	public static final Integer WX_ORDER_TYPE_EXCLUSIVE_CLIENT = 6; //客户专属套餐
	public static final Integer WX_ORDER_TYPE_LEATHER_CARE = 9; //真皮清洁护理
	
	/** 套餐类型编码  **/
	public static final Integer SUITE_TYPE_BIG_MAINTENANCE_CODE = 1; //大保养
	public static final Integer SUITE_TYPE_SMALL_MAINTENANCE_CODE = 2; //小保养
	public static final Integer SUITE_TYPE_FREE_TESTING_CODE = 3; //免费检测
	public static final Integer SUITE_TYPE_FLAZE_CODE_CODE = 4; //防霾滤清器
	public static final Integer SUITE_TYPE_STERILIZATION_DEODORIZATION_CODE = 5; //杀菌除异味
	public static final Integer SUITE_TYPE_NACELLE_WASH_CODE = 6; //发动机舱清洗
	public static final Integer SUITE_TYPE_EXCLUSIVE_CLIENT_CODE = 7; //客户专属编码
	public static final Integer SUITE_TYPE_LEATHER_CARE_CODE = 9; //真皮清洁护理
	public static final Integer SUITE_TYPE_STERILIZATION_PLUS_CODE = 11;//空调清洗加氨
	public static final Integer SUITE_TYPE_BREAKE_MAINTENANCE_CODE = 12; //刹车系统养护
	public static final Integer SUITE_TYPE_VEHICLE_CLEANNING_CODE = 13; //洗车
	
	/**套餐类型名称**/
	public static final String SUITE_TYPE_BIG_MAINTENANCE_NAME = "上门保养"; //大保养
	public static final String SUITE_TYPE_SMALL_MAINTENANCE_NAME = "小保养"; //小保养
	public static final String SUITE_TYPE_FREE_TESTING_NAME = "上门检测"; //免费检测
	public static final String SUITE_TYPE_FLAZE_CODE_NAME = "防霾滤清器"; //防霾滤清器
	public static final String SUITE_TYPE_STERILIZATION_DEODORIZATION_NAME = "空调清洗"; //空调清洗
	public static final String SUITE_TYPE_NACELLE_WASH_NAME = "发动机舱精洗"; //发动机舱清洗
	public static final String SUITE_TYPE_LEATHER_CARE_NAME_STRING = "真皮保养护理";
	public static final String SUITE_TYPE_STERILIZATION_PLUS_STRING = "空调清洗加氨";
	public static final String SUITE_TYPE_BREAK_MAINTENANCE_STRING = "刹车系统养护";
	
	/**
	 * 活动专区套餐来源
	 */
	public static final Integer ACT_SOURCE_DEFAULT = 0; //默认
	public static final Integer ACT_SOURCE_EXCLUSIVE_CLIENT = 1; //专属客户
	
	/**
	 * 查询红包类型
	 */
	public static final String QUERY_PACK_TYPE = "MCHT";
	
	/** 配件类型  **/
	public static final Integer FITTING_TYPE_HOUR_COST = 1; //工时
	public static final Integer FITTING_TYPE_ENGINE_OIL = 2; //机油
	public static final Integer FITTING_TYPE_OIL_FILTER = 3; //机滤 
	public static final Integer FITTING_TYPE_HAZE_FILTER = 7; //防霾滤清器
	public static final Integer FITTING_TYPE_FREE_TEST = 6; //上门检测
	
	/** 全车型   **/
	public static final Integer FULL_VEHICLE_TYPE = 9999; //全车型
	
	/** 车辆检测类型  **/
	public static final Integer VEHICLE_DETECTION_LIGHTING_SYSTEM = 1; //灯光装置系统
	public static final Integer VEHICLE_DETECTION_ELECTRIC_SYSTEM = 2; //电器装置系统
	public static final Integer VEHICLE_DETECTION_BRAKE_SYSTEM = 3; //制动系统
	public static final Integer VEHICLE_DETECTION_ENGINE_SYSTEM = 4; //发动机系统
	public static final Integer VEHICLE_DETECTION_CHASSIS_SYSTEM = 5; //底盘系统
	public static final Integer VEHICLE_DETECTION_BODY_SYSTEM = 6; //车身系统
	
	//-------------------受理后订单状态----------------------
    public static final String ORDER_STATUS_LEAVE 			= "10";//出发服务
    public static final String ORDER_STATUS_STARTSERVICE 	= "20";//开始服务
    public static final String ORDER_STATUS_SERVICED 		= "30";//服务完成
    public static final String ORDER_STATUS_CANCELED        = "-1";//取消订单
    public static final String ORDER_STATUS_INI        = "0";//初始订单
    
    /** 素材类型  **/
    public static final String WX_MATERIAL_TYPE_NEWS = "news"; //图文素材
    public static final String WX_MATERIAL_TYPE_IMAGE = "image"; //图片素材
    public static final String WX_MATERIAL_TYPE_VIDEO = "video"; //视频素材
    public static final String WX_MATERIAL_TYPE_VOICE = "voice"; //语音素材
    public static final String WX_MATERIAL_TYPE_THUMB = "thumb"; //缩略图
    
    /** 服务车状态  **/
    public static final Integer CAR_STATUS_NORMAL = 1; //正常
    public static final Integer CAR_STATUS_REPAIR = 2; //维修
	
	/** 系统url常量 **/
    public static final String SYS_WEB_URL = "http://" + Config.SYS_DOMAIN_NAME;
	public static final String SYS_ORDER_DETAIL_URL = SYS_WEB_URL + "/customer/order-detail?id="; //订单详情url
	public static final String SYS_ORDER_ACT_LIST_URL = SYS_WEB_URL + "/preference/orderActList?orderNo="; //订单复购套餐列表
	public static final String SYS_SHARE_ENVELOPE_URL = SYS_WEB_URL + "/mobile/shareEnvelope?origin="; //领取分享红包url
	public static final String SYS_SHARE_DUMPLINGS_COUPON_URL = SYS_WEB_URL + "/mobile/shareDumplingsGame"; //分享粽仙游戏url
	public static final String SYS_DIASEN_DUMPLINGS_ACTIVITY_URL = SYS_WEB_URL + "/mobile/dumplingGame"; //粽子仙人游戏
	public static final String SYS_PUSH_ENVELOPE_URL = SYS_WEB_URL + "/mobile/sendEnvelope?origin="; //群发红包url
	public static final String SYS_SHARE_IMAGE_URL = SYS_WEB_URL + "/static/images/share/"; //分享图片库
	public static final String SYS_VEHICLE_DETECTION_REPORT_URL = SYS_WEB_URL + "/wechat/user/report?id="; //检测报告url
	public static final String SYS_ABOUT_US_URL = SYS_WEB_URL + "/mobile/aboutus"; //关于弄弄车url
	public static final String SYS_CONCERNED_DRAW_COUPON_URL = SYS_WEB_URL + "/mobile/drawConcernedCoupon";
	public static final String SYS_CONCERNED_COUPON_URL = SYS_WEB_URL + "/mobile/newEntry";
	public static final String SYS_WX_PAY_NOTIFY_URL = SYS_WEB_URL + "/pay/payNotify/"; //微信支付通知url
	public static final String SYS_MY_COUPON_LIST_URL = SYS_WEB_URL + "/wechat/user/myPackageList?id="; //优惠券列表
	public static final String SYS_ORDER_SHARE_URL = SYS_WEB_URL + "/coupon/couponInfo?couponId="; //订单分享url
	public static final String SYS_TAKE_ORDER_SHARE_URL = SYS_WEB_URL + "/mobile/order-share?";
	public static final String SYS_RP_SHARE_URL = SYS_WEB_URL + "/rp/shareRP?promotionCode=";//分销分享url
	public static final String SYS_PARTNER_BOOK_URL = SYS_WEB_URL + "/appointment/toBook";//合作商预约
	public static final String SYS_PREFERENCE_URL = SYS_WEB_URL + "/preference/orderActList?orderNo="; //复购
	public static final String SYS_LOTTORY_GULF = SYS_WEB_URL + "/lottory/gulf"; //海湾机油活动
	public static final String SYS_REPAIR_APPOINTMENT_URL = SYS_WEB_URL + "/repair/appointmentInfo?appointmentId=";//故障报修预约Url
	
	/** 订单状态变更消息内容模板  **/
	public static final String WX_TEMPLATE_TAKE_ORDER_MSG = "尊敬的车主，您已预约成功！订单号：${1}";
	public static final String WX_TEMPLATE_ACCEPT_ORDER_MSG = "尊敬的车主，您好！技术顾问已受理，${1}届时将为您服务。";  //订单受理
	public static final String WX_TEMPLATE_START_OFF_MSG = "尊敬的车主，您好！弄弄车技术顾问已出发，请耐心稍候。";  //技师出发服务
	public static final String WX_TEMPLATE_START_SERVICE_MSG = "车主您好，${1}技术顾问已开始为您服务。PS：限时特价保养套餐火热抢购中，199元起，点击开抢！";
	public static final String WX_TEMPLATE_FINISH_ORDER_MSG = "尊敬的车主，您好！订单编号${1}服务已完成，请您对本次服务进行点评！"; //订单完成
	public static final String WX_TEMPLATE_CANCLE_ORDER_MSG = "尊敬的车主，您好！订单取消成功！重新下单请返回弄弄车主页“预约”。"; //订单取消
	public static final String WX_TEMPLATE_VEHICLE_DETECTION_REPORT_MSG = "尊敬的车主，您好！弄弄车技术顾问将在3日内发送您爱车的检测报告，请注意查看。如有疑问，欢迎致电【弄弄车】云呼叫中心：400-111-5898"; //检测报告	
	public static final String WX_TEMPLATE_SERVICE_RESERVATION_MSG = "尊敬的车主，您所预约的“${1}”项目服务时间将近~技师顾问明天会准时服务，届时请保持手机畅通~"; //服务预约提醒
	public static final String WX_TEMPLATE_MAINTENANCE_MATURITY_MSG = "尊敬的车主，预计您的爱车最佳保养时间将近~建议您根据爱车情况，点击“我要预约”提前预约，弄弄车技师顾问会准时服务哦~"; //保养到期提醒
	public static final String WX_TEMPLATE_COUPON_DRAW_MSG = "尊敬的车主，恭喜您成功领取了一张弄弄车【${1}】。"; //优惠券领取通知
	public static final String WX_TEMPLATE_MODIFY_ORDER_MSG = "尊敬的车主，您的订单已修改成功！订单号：${1}";
public static final String WX_TEMPLATE_APPOINTMENT_MSG = "尊敬的车主，您的故障报修服务预约已成功！预约号：${1}";
	
	//订单状态备注模板
	public static final String WX_TEMPLATE_ORDER_REMARK = "如有任何问题，请联络我们客服：400-111-5898";
	public static final String WX_TEMPLATE_TAKE_ORDER_REMARK = "请耐心等待，服务人员将尽快为您服务。客服电话400-111-5898";
	public static final String WX_TEMPLATE_FINISH_ORDER_REMARK = "感谢您的选择。【我的订单】里可以查询本次服务记录，请您对本次的服务进行点评。客服电话：400-111-5898";
	public static final String WX_TEMPLATE_VEHICLE_DETECTION_REPORT_REMARK = "请点击查看检测报告。";
	public static final String WX_TEMPLATE_SERVICE_RESERVATION_REMARK = "致电咨询：4001115898，感谢您的支持。";
	public static final String WX_TEMPLATE_MAINTENANCE_MATURITY_REMARK = "致电咨询：4001115898，感谢您的支持。";
	public static final String WX_TEMPLATE_COUPON_DRAW_REMARK = "快下单使用吧~";
	
	/**
	 * cache key值
	 */
	public static final String SYS_CACHE_KEY_WXTOKEN = "sys_cache_key_wxtoken"; //微信接口调用凭证
	public static final String SYS_CACHE_KEY_JSAPI = "sys_cache_key_jsapi"; //微信js api接口票据缓存key值
	
	public static final String REGISTER_INDENTIFY_CODE_TIME = "5";
	public static final String PASSWORD_AUTH_KEY = "f5fbe01c";
	
	public static final String OPENID_COOKIE = "openId";
	public static final String OPENID_CODE_PARAM = "code";
	public static final String USER_ID_COOKIE = "userId";
	public static final  String CITY_ID_COOKIE = "cityIdCookie";
	public static final  String CITY_NAME_COOKIE = "cityNameCookie";
	
	/**微信页面 分页常量*/
	public static final Integer DEFAULT_PAGE = 1;
	
	public static final Integer DEFAULT_PAGESIZE = 5;
	/**注册验证码cookie  key*/
	public static final String CAPTCHA_COOKIE = "code";
	/**验证码长度*/
	public static final Integer CAPTCHA_DEFALUT_LENGTH = 4;
	/**注册验证码cookie有效时间*/
	public static final int CAPTCHA_COOKIE_AGE = 5*60;
	
	/** 图文素材存储路径  **/
	public static final String WX_ITEM_MATERIAL_PATH = "/static/images/material/";
	/** 二维码路径  **/
	public static final String WX_QRCODE_PATH = "/static/images/qrcode/";
	/** 合作商二维码存储路径 **/
	public static final String WX_PARTNER_QRCODE_PATH = "/static/images/qrcode/partner/";
	/** 微信粉丝头像存储路径  **/
	public static final String WX_HEADIMG_PATH = "/static/images/headImg/";
	
	public static final String DECTION_IMGURL_PRE = "http://120.132.32.194:1611/ggcar/static/uploadImgs/";
	public static final String APP_PUSH_URL = "http://120.132.32.194:1611/ggcar/api/push/pushNotify";
	
	/**
	 * 券类型名称
	 */
	public static final String MAINTANCE_COUPON = "保养券";
	public static final String HAZE_COUPON = "防霾券";
	public static final String STERLIZATION_COUPON = "空调清洗券";
	
	/**
	 * 券Origin值
	 */
	public static final Integer HAZE_COUPON_ORIGIN = 6;
	public static final Integer STERLIZATION_COUPON_ORIGIN = 8;
	public static final Integer STERLIZATION_COUPON_SHARE_ORIGIN = 9;
	
	/**
	 * request公共请求参数
	 */
	public static final String REQUEST_PARAM_MKTFROM = "mktFrom";

	/**
	 * banner图参数
	 */
	public static final String INDEX_BANNER = "index";

	/**
	 * 卡类型
	 */
	public static final String CARD_TYPE_MEASURE = "measuredCard";
	public static final String CARD_TYPE_PREPAID = "prepaidCard";
}
