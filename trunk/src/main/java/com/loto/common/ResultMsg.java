package com.loto.common;

import com.loto.util.ValidatorUtil;

/**
 * @description 通讯协议
 *
 * @author xuys
 * 
 * @time 2015年7月6日 下午3:25:01
 **/
public class ResultMsg {
	public static final String FAIL = "FAIL";
	public static final String SUCCESS = "SUCCESS";
	
	/** 协议层 **/
	private String returnCode = SUCCESS;
	
	private String returnMsg;
	
	/** 业务层   **/
	private String resultCode = SUCCESS;
	
    private String errCode;
    
    private String errCodeDesc;
    
	private Object result;
    
    private boolean success = true;
    
    public ResultMsg(){}
    
    /**
     * @description 构造通讯协议
     *
     * @author xuys
     * 
     * @time 2015年7月22日 上午11:04:29
     *
     * @param
     *
     */
    public static ResultMsg buildErrorMsg(String resultCode, String errorCode, String errorDesc){
    	ResultMsg opeMsg = new ResultMsg();
    	if (ValidatorUtil.isNull(opeMsg)) {
			opeMsg = new ResultMsg();
		}
    	opeMsg.setResultCode(resultCode);
    	opeMsg.setErrCode(errorCode);
    	opeMsg.setErrCodeDesc(errorDesc);
    	
    	return opeMsg;
    }
    
    public static ResultMsg buildResultMsg(Object result) {
		ResultMsg msg = new ResultMsg();
		msg.setResult(result);
		return msg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDesc() {
		return errCodeDesc;
	}

	public void setErrCodeDesc(String errCodeDesc) {
		this.errCodeDesc = errCodeDesc;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
    
}
