package com.loto.common;

import java.util.List;

import com.loto.util.ValidatorUtil;

/**
 * @description 通讯协议
 *
 * @author xuys
 * 
 * @time 2015年7月6日 下午3:25:01
 **/
public class OperationMessage {
	public static final String FAIL = "FAIL";
	public static final String SUCCESS = "SUCCESS";
	
	/** 协议层 **/
	private String returnCode = SUCCESS;
	
	private String returnMsg;
	
	/** 业务层   **/
	private String resultCode = FAIL;
	
    private String errCode;
    
    private String errCodeDesc;
    
    @SuppressWarnings("rawtypes")
	private List result;
    
    private Object obj;
    
    private boolean success = false;
    
    public OperationMessage(){}
    
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
    public static OperationMessage buildOpeMsg(OperationMessage opeMsg, String resultCode, String errorCode, String errorDesc){
    	if (ValidatorUtil.isNull(opeMsg)) {
			opeMsg = new OperationMessage();
		}
    	opeMsg.setResultCode(resultCode);
    	opeMsg.setErrCode(errorCode);
    	opeMsg.setErrCodeDesc(errorDesc);
    	
    	return opeMsg;
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

	@SuppressWarnings("rawtypes")
	public List getResult() {
		return result;
	}

	@SuppressWarnings("rawtypes")
	public void setResult(List result) {
		this.result = result;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
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
