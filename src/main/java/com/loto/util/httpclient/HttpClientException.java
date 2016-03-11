package com.loto.util.httpclient;

import com.alibaba.fastjson.JSONException;

/**
 * @description:
 * 
 * @author xuys
 *
 * @time 2015年3月10日	
 */
public class HttpClientException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5154648354914159009L;
	
	private int statusCode = -1;
    private int errorCode = -1;
    private String request;
    private String error;
    
    public HttpClientException(String msg) {
        super(msg);
    }

    public HttpClientException(Exception cause) {
        super(cause);
    }
    
    public HttpClientException(String msg , int statusCode) throws JSONException {
    	super(msg);
    	this.statusCode = statusCode;
    }

    public HttpClientException(String msg , String responseConten, int statusCode) throws JSONException {
        super(msg + "\n error:" +responseConten);
        this.statusCode = statusCode;
    }

    public HttpClientException(String msg, Exception cause) {
        super(msg, cause);
    }

    public HttpClientException(String msg, Exception cause, int statusCode) {
        super(msg, cause);
        this.statusCode = statusCode;

    }

    public int getStatusCode() {
        return this.statusCode;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public String getRequest() {
		return request;
	}

	public String getError() {
		return error;
	}
}
