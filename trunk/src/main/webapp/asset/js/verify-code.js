/**
 * 获取验证码js
 */

var VerifyCode = {
	init : function(object){//初始化
		VerifyCode.disableGetButton = object.disableGetButton;
		VerifyCode.activeGetButton = object.activeGetButton;
		VerifyCode.disableVoiceButton = object.disableVoiceButton;
		VerifyCode.activeVoiceButton = object.activeVoiceButton;
		VerifyCode.showVoiceArea = object.showVoiceArea;
		VerifyCode.params = object.params;
		VerifyCode.msgButtonId = object.msgButtonId;
		VerifyCode.voiceButtonId = object.voiceButtonId;
		VerifyCode.mobileNoId = object.mobileNoId;

		$("#" + VerifyCode.msgButtonId).on("click", function(){
			VerifyCode.getMsgCode();
		})
		$("#" + VerifyCode.voiceButtonId).on("click", function(){
			VerifyCode.getVoiceCode();
		})
	},
	countTime : 60,//倒计时秒数
	sendingFlag : false,//是否正在发送标志
	params : {},//获取验证码传参
	globalTimer : null,
	msgButtonId : "",//短信验证码按钮id
	voiceButtonId : "",//语言验证码按钮id
	mobileNoId : "",//手机号输入框id
	disableGetButton : function(){//获取按钮不可用

	},
	activeGetButton : function(){//获取按钮可用

	},
	disableVoiceButton : function(){//语音按钮不可用

	},
	activeVoiceButton : function(){//语音按钮可用

	},
	showVoiceArea : function(){//开启语言验证码区域

	},
	getMsgCode : function(){
		if(!$("#" + VerifyCode.mobileNoId).isValid()){
			return;
		}
		VerifyCode.params.mobileNo = $("#" + VerifyCode.mobileNoId).val();

		var checkFlag = VerifyCode.disableGetButton(); //发送成功，按钮失效，倒计时开始
		if(checkFlag){
			return;
		}

		$.ajax({
			url : url + "/wechat/verifyCode",
			type : "post",
			data : VerifyCode.params,
			dataType : "json",
			success : function(data){
				if(data == "success"){
					//关闭语音验证码倒数
					window.clearInterval(VerifyCode.globalTimer);

					VerifyCode.activeVoiceButton();//语言验证码可用

					var countTime = VerifyCode.countTime;
					VerifyCode.globalTimer = setInterval(function() {
						countTime--;
						$("#" + VerifyCode.msgButtonId).text(countTime + "秒后重新获取");
						if(countTime <= 0){
							window.clearInterval(VerifyCode.globalTimer);

							VerifyCode.activeGetButton();//发送验证码按钮重新可用
							return false;
						}
						if(countTime == 30){
							VerifyCode.showVoiceArea();
						}
					},1000);
				}
			}
		});
	},
	getVoiceCode : function(){
		if(!$("#" + VerifyCode.mobileNoId).isValid()){
			return;
		}
		VerifyCode.params.mobileNo = $("#" + VerifyCode.mobileNoId).val();

		//获取验证码
		$.ajax({
			url : url + "/wechat/voiceCode",
			type : "post",
			data : VerifyCode.params,
			dataType : "json",
			success : function(data){
				if(data == "success"){
					//关闭验证码倒计时
					window.clearInterval(VerifyCode.globalTimer);

					VerifyCode.activeGetButton();//短信验证码可用

					VerifyCode.disableVoiceButton();

					var countTime = VerifyCode.countTime;
					VerifyCode.globalTimer = setInterval(function() {
						countTime--;
						$("#" + VerifyCode.voiceButtonId).text(countTime+"秒后重新获取");
						if(countTime <= 0){
							window.clearInterval(VerifyCode.globalTimer);
							VerifyCode.activeVoiceButton();
							return;
						}
					},1000);
				}
			}
		});
	}
}