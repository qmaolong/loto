/**
 * 维修预约
 */

$(function(){
	repair.init();
	
	$("#appointmentSubmit").on("click", function(){
		if(!$("form").isValid()){
			return;
		}
		
		plugin.Loading.getInstance().show();
		
		repair.uploador.upload();
	})
	
})

var repair = {
	uploador : null,
	uploadingImgs : [],
	retryTime : 0,//重复次数
	//初始化
	init : function(){
		//初始化验证码
		VerifyCode.init({
			disableGetButton : function(){
				$("#getVerifyCode").addClass("disable");
				$("#getVerifyCode").text("60秒后重新获取");
				$("#getVoiceCode").text("获取语音验证码");
			},
			activeGetButton : function(){
				$("#getVerifyCode").removeClass("disable");
				$("#getVerifyCode").text("获取验证码");
				$("#getVerifyCode").on("click", function(){VerifyCode.getMsgCode()});
			},
			disableVoiceButton : function(){
				$("#getVoiceCode").addClass("disable");
				$("#getVoiceCode").text("60秒后重新获取");
				$("#getVerifyCode").text("获取验证码");
			},
			activeVoiceButton : function(){
				$("#getVoiceCode").removeClass("disable");
				$("#getVoiceCode").text("获取语音验证码");
				$("#getVoiceCode").on("click", function(){VerifyCode.getVoiceCode()});
			},
			showVoiceArea : function(){
				$(".voice-panel").css("display", "block")
			},
			params : {type : 3},
			msgButtonId : "getVerifyCode",
			voiceButtonId : "getVoiceCode",
			mobileNoId : "mobileNo"
		});
		
		//初始化车型插件
		components.repair.order.init({
	        carInfo:{
	            brandURL:url+"/order/getBrandsByCity",
	            serialURL:url+"/order/getSeriesByBrand",
	            modelURL:url+"/order/getModelBySeries",
	            onSelectCar:function(data){
//	                plugin.Loading.getInstance().show();
	            	$("#carInfo").text(data.brandName + "-" + data.seriesName);
	            	$("#brandId").val(data.brandId);
	            	$("#seriesId").val(data.seriesId);
	            	$("#modelId").val(data.modelId);
	            	$("#brandName").val(data.brandName);
	            	$("#seriesName").val(data.seriesName);
	            	$("#modelName").val(data.modelName);
	            },
	            brandParam:{
	                city:""
	            }
	        }
	    });
		
		//初始化上传组件
		repair.uploador = components.uploader.init({
	    	picker : "#filePicker",
	    	picListEl : "#dndArea",
	    	server : url + "/cmn/upload/imgbin",
	    	uploadFinished:function(){
	    		repair.appointSubmit();//提交预约单
	    	},
	    	uploadSuccess : function(file,reason){
	    		if(reason.code == 0){
	    			repair.uploadingImgs.push(reason.imgUrl);
	    		}else{
	    			alert(reason.msg);
	    			repair.uploador.retry();
	    		}
	    	},
	    	uploadError : function(file,reason){
	    		if(repair.retryTime >=3){//上传失败，自动进行重传，次数达到3次后提示失败。
	    			alert("图片上传失败，请检查网络并重试！")
	    			return;
	    		}
	    		repair.uploador.retry();
	    		repair.retryTime ++;
	    	}
	    });

	},
	//预约提交
	appointSubmit : function(){
		
		var appointment = {};
		appointment.brandId = $("#brandId").val();
		appointment.brandName = $("#brandName").val();
		appointment.seriesId = $("#seriesId").val();
		appointment.seriesName = $("#seriesName").val();
		appointment.modelId = $("#modelId").val();
		appointment.modelName = $("#modelName").val();
		appointment.description = $("#faultDesc").val();
		appointment.cusPhone = $("#mobileNo").val();
		var verifyCode = $("#verifyCode").val();
		
		if(!isNull(repair.uploadingImgs)){
			$.each(repair.uploadingImgs, function(i, img){
				switch(i){
				case 0 : appointment.imgUrl1 = img; break;
				case 1 : appointment.imgUrl2 = img; break;
				case 2 : appointment.imgUrl3 = img; break;
				case 3 : appointment.imgUrl4 = img; break;
				case 4 : appointment.imgUrl5 = img; break;
				}
			})
		}
		
		$.ajax({
			url : url+"/repair/appointmentSubmit",
			type : "post",
			data : {appointmentStr : JSON.stringify(appointment), verifyCode : verifyCode},
			dataType : "json",
			success : function(data){
				if(data.isSuccess == 1){
					location.href = url + "/repair/appointmentSuccess?appointmentId=" + data.id + "&userStatus=" + data.userStatus;
				}else{
					popTip(data.msg);
					plugin.Loading.getInstance().hide();
				}
			},  
		    error:function(){
		    	popTip("预约失败~");
		    }
		})
	}
}