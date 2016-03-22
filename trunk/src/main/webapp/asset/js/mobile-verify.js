/**
 * 手机客户端统一校验js
 * 
 * @author : xuys
 * 
 * @time : 2015/3/16
 */
Z = {};

config = {
	info : "info",
	warn : "warn",
	success : "success",
	error : "warn"
};

Z.override = function(origclass, overrides){
    if(overrides){
       var p = origclass.prototype;
       for(var method in overrides){
           p[method] = overrides[method];
       }
    }
}

Z.extend = function(){
    // inline overrides
    var inlineOverride = function(o){
        for (var m in o) {
            this[m] = o[m];
        }
    };
    return function(subFn, superFn, overrides){
        if (typeof superFn == 'object') { 
            overrides = superFn;
            superFn = subFn;
            subFn = function(){
                superFn.apply(this, arguments);
            };
        }
        var F = function(){
        }, subFnPrototype, superFnPrototype = superFn.prototype;

        F.prototype = superFnPrototype;
        subFnPrototype = subFn.prototype = new F();
		subFnPrototype.constructor = subFn;
        subFn.superclass = superFnPrototype;
		if (superFnPrototype.constructor == Object.prototype.constructor) {
            superFnPrototype.constructor = superFn;
        }
        subFn.override = function(obj){
            Z.override(subFn, obj);
        };
        subFnPrototype.override = inlineOverride;
        Z.override(subFn, overrides);
        return subFn;
    };
}();


Z.isInt = function(str){
	return /^\-?\d+$/.test(""+str);
};

Z.isPlus = function(str){
	return /^\d+$/.test(""+str);
};

Z.isNumber = function(str){
	var t = ""+str;
	for(var i=0;i<str.length;i++){
		var chr = str.charAt(i);
		if(chr!="."&&chr!="E"&&isNaN(parseInt(chr))){
			return false;
		}
	}
	return true;
};

Z.isTime = function(str){
	var arr = str.split(":");
	if(arr.length!=3){
		return false;
	}
	var date = new Date();
	date.setHours(arr[0]);
	date.setMinutes(arr[1]);
	date.setSeconds(arr[2]);
	return date.toString().indexOf("Invalid")<0;
};

Z.isDate = function(str){
	var arr = str.split("-");
	if(arr.length!=3){
		return false;
	}
	var date = new Date();
	date.setFullYear(arr[0]);
	date.setMonth(arr[1]);
	date.setDay(arr[2]);
	return date.toString().indexOf("Invalid")<0;
};

Z.isArray = function(obj) {
	 if(!obj){
	 	 return false;
	 }
   if (obj.constructor.toString().indexOf("Array") == -1){
      return false;
   } else{
      return true;
   }
};

(function($){
	$.fn.verify = function(verify, alias, tipType){
		if(!verify || verify=='') 
			return true;
		if(typeof(tipType) === "undefined" || tipType == null || tipType == ""){
			tipType = "warn";
		}
		var msg = [];
		var sqlFlag = true;
		var Features = verify.split("\&\&");		
		var value = this.val();
		if(this.attr("ztype")&&this.attr("ztype").toLowerCase()=="select"){
		}
		for(var i = 0; i < Features.length; i++) {
			var arr = Features[i].split("\|");
			var name = "";
			var rule;
			if(arr.length==2){
				name = arr[0];
				rule = arr[1];
			}else{
				rule = Features[i];
			}
			var op = "=";
			if(rule.indexOf('>') > 0) {
				op = ">";
			}else if (rule.indexOf('<') > 0) {
				op = "<";
			}
			var f = rule.split(op);
			var fName = f[0];
			var fValue = null;
			if(f.length > 1) {
				fValue = f[1];
			}
			if(fName=="None") {
				continue;
			}
			if(fName=="Any") {
				sqlFlag = false;
			}else if (fName=="Regex") {
				fValue = rule.substring(6);
				if (value==null||value==""||!fValue) {continue;}
				var reg = fValue;
				if(!reg.startWith("^")){
					reg = "^"+reg;
				}
				if(!reg.endWith("$")){
					reg += "$";
				}
				if(!new RegExp(reg).test(value)){
					msg.push(name);
				}
			}else if (fName == "Script") {
				fValue = rule.substring(7);
				if (value==null||value==""||!fValue) {continue;}
				if(!eval(fValue)){
					msg.push(name);
				}
				tipType = config.error;
			}else if (fName=="NotNull") {
				if (value==null||$.trim(value)=="") {
					if(this.attr("ztype")&&this.attr("ztype").toLowerCase()=="select"){
						msg.push("必须选择"+name);
					}else{
						msg.push(alias + "不能为空");
					}
					tipType = config.error;
				}
			}else if (fName=="Number") {
				if (value==null||value=="") {continue;}
				if(!Z.isNumber(value)){
					msg.push(alias + "必须是数字");
				}
				tipType = config.error;
			}else if (fName=="Number2") {
				if (value==null||value=="") {continue;}
				if(!Z.isNumber(value)){
					msg.push(name+"必须是数字");
				}
				var i = value.indexOf(".");
				if(i>=0){
					var decimal = value.substring(i+1);
					if(decimal.length > 2){
						msg.push(alias + "只能小于两位小数");
					}
				}
				tipType = config.error;
			}else if (fName=="Time") {
				if (value==null||value=="") {
					continue;
				}
				var timearr = value.split(":");
				if(timearr.length != 3){
					msg.push(alias + "的值"+value+"不是正确的时间!");
				}else{
					if(!Z.isInt(timearr[0])||timearr[0]<0||timearr[0]>23){
						msg.push(alias+"的值"+value+"错误，小时数"+timearr[0]+"不正确!");
						ele.focusEx();
					}else if(!Z.isInt(timearr[1])||timearr[1]<0||timearr[1]>59){
						msg.push(alias+"的值"+value+"错误，分钟数"+timearr[1]+"不正确!");
					}
				}
				tipType = config.error;
			}else if (fName=="Int") {
				if (value==null||value=="") {continue;}
				if(!Z.isInt(value)){
					msg.push(alias + "必须是整数");
					tipType = config.error;
				}
			}else if (fName=="Date") {
				if (value==null||value=="") {
					continue;
				}
				if(!/\d{4}\-\d{2}\-\d{2}/.test(value)){
					msg.push(alias + "必须是正确的日期");
				}else{
				  var ts = value.split("-");
				  var d = new Date(ts[0],--ts[1],ts[2]);
				  if(d.getMonth()!=ts[1]||d.getDate()!=ts[2]){
					  msg.push(alias + "必须是正确的日期");
				  }
				}
				tipType = config.error;
			}else if(fName=="Email") {
				if (value==null||value=="") {continue;}
				var pattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				if(value&&value.match(pattern)==null){
					msg.push(alias + "不是正确的电子邮箱地址");
					tipType = config.error;
				}
			}else if(fName=="EmailMore") {
				if (value==null||value=="") {continue;}
				var pattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				var emailArr=value.split(',');
				for(var arrLength=0;arrLength<emailArr.length;arrLength++){
					var emailValue=emailArr[arrLength];
					if(emailValue&&emailValue.match(pattern)==null){
						msg.push(alias + "不是正确的电子邮箱地址");
						tipType = config.error;
					}
				}
			}else if(fName=="URL"){
			  if(value==null||value==""){continue;}
			  var pattern =/^((https|http|ftp|rtsp|mms)?:\/\/)+[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/i
			      if(value&&value.match(pattern)==null){
			    	  msg.push(alias + "URL地址格式不正确");
			    	  tipType = config.error;
			      }
			 }else if(fName=="PURL"){//不带协议的URL难证
			  if(value==null||value==""){continue;}
			  var pattern =/^(https?:\/\/)?[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/ 
			      if(value&&value.match(pattern)==null){
			    	  msg.push(alias + "URL地址格式不正确");
			    	  tipType = config.error;
			      }
			  }else if(fName=="Length") {
				if (value==null||value=="") {continue;}
				if(isNaN(fValue)) {
					msg.push("校验规则错误，Length后面必须是数字");
				}else{
					try{
						var len = parseInt(fValue);
						if(op=="="&&value.length!=len) {
						  msg.push(alias + "长度必须为" + len+"个字符");
						}else if (op==">"&&value.length<=len) {
							msg.push(alias + "输入必须大于" + len + "个字符");
						}else if (op=="<"&& value.length>=len) {
							msg.push(alias + "输入必须少于" + len + "个字符");
						}
					} catch (ex) {
						msg.push("校验规则错误，Length后面必须是整数"+ex.message);
					}
				}
			}else if(fName=="Plus"){
				if (value==null||value=="") {continue;}
				if(!Z.isPlus(value)){
					msg.push(name+"必须是非负整数");
				}else{
					if(parseInt(value)==0){
						msg.push(name+"必须大于0");
					}
				}
			} else if(fName=="IP") {
				if (value==null||value=="") {continue;}
				if(!Z.isPlus(value)){
					msg.push(name+"必须是非负整数");
				}else{
					if(parseInt(value)==0){
						msg.push(name+"必须大于0");
					}
					if(parseInt(value)>65535){
						msg.push(name+"必须小于65535");
					}
				}
			}else if(fName=="IPAdd"){
				if (value==null||value=="") {continue;}
				if(!/^((1?\d?\d|(2([0-4]\d|5[0-5])))\.){3}(1?\d?\d|(2([0-4]\d|5[0-5])))$/.test(value)){
					msg.push("IP地址格式不正确");
				}
			}else if(fName=="SChar"){
				if (value==null||value=="") {continue;}
				if(!/^[^{}'";,<>]*$/.test(value)){
					msg.push("不能含以下字符:\(\)\{\} \' \" \; \, < >");
				}
			}else if(fName=="maxValue") {
				if (value==null||value=="") {continue;}
				if(isNaN(fValue)) {
					msg.push("校验规则错误，maxValue后面必须是数字");
					tipType = config.error;
				}else{
					if(parseInt(value)>fValue){
						msg.push(name+"必须小于等于"+fValue);
						tipType = config.warn;
					} 
				}
			}else if(fName=="minValue") {
				if (value==null||value=="") {continue;}
				if(isNaN(fValue)) {
					msg.push("校验规则错误，minValue后面必须是数字");
				}else{
					if(parseInt(value)<fValue){
						msg.push(name+"必须大于"+(fValue-1));
					} 
				}
			}else if(fName=="phone") {
				if (value==null||value=="") {continue;}
				if(!/([0-9,，+])+$/.test(value)) {
					msg.push("包含非法字符");
				}
			}else if(fName=="mobilePhone"){
				if (value==null||value=="") {continue;}
				if(!(/^1[3|4|5|7|8][0-9]\d{8}$/.test(value))){ 
					msg.push("手机号码错误");
				}
			}else if(fName=="qqNumber"){
				if(value==null||value==""){continue;}
				if(!/^\d{5,12}$/.test(value.trim())){
					msg.push("请输入正确QQ号（5~12位数字）");
				}
			}else if(fName=="QQGNum"){
				if(value==null||value==""){continue;}
				if(!/^\d{5,9}$/.test(value.trim())){
					msg.push("请输入正确QQ群号（5~9位数字）");
				}
			}else if(fName=="ExcelSChar"){
				if(value==null||value==""){continue;}
				if(!/^[^(){}'";,:<>\\/\*\?\[\]]*$/.test(value)){
					msg.push("不能含以下字符:\(\)\{\} \' \" \; \, < >\[ \] \? \* \\ /");
				}
			}else if(fName=="taskSChar"){
				if(value==null||value==""){continue;}
				if(!/^[^<>'"]*$/.test(value)){
					msg.push("不能含以下字符: < >");
				}
			}else if(fName=="carNo"){
				if (value==null||value=="") {continue;}
				if(!/^[\u4E00-\u9FA5][a-zA-Z]{1}[\da-zA-Z]{5}$/.test(value)){
					msg.push("车牌号格式不正确");
				}
			}
		}
		if(msg.length>0){
			var txt = msg.join("<br/>");
			$.nntip({
				msg : txt,
				type : tipType, //类型：info,success,warn,error
				duration : 2000
			});
			return false;
		}else{
			return true;
		}
	}
	
	$.fn.isValid = function(){
		var rs = true;
		if($(this).attr('verify'))
			rs = rs&&$(this).verify($(this).attr('verify'), $(this).attr('alias'), $(this).attr("tipType"));
		$(this).find('[verify]').each(function(){
			//display为none的控件跳过验证
			if(($(this).css("display")!="none" || $(this).attr("needVerify") == "yes") && $(this).attr("focusVerify") != "no"){
				v = $(this).verify($(this).attr('verify'), $(this).attr('alias'), $(this).attr("tipType"));
				rs = rs&&v;
				//修改，验证不通过则增加focus事件
				if(!rs){
					$(this).focus();
					return rs;
				}
			}
		});
		return rs;
	}
	
	$(function(){
		$('form').each(function(){
			this.onsubmit = function(){
				return $(this).isValid();
			}
		});
	});
})(Zepto);
