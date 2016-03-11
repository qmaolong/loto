package com.loto.util.httpclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.loto.util.ValidatorUtil;

/**  
 * @Description: 
 * @author Raul
 * @date 2013年12月12日 下午4:34:13    
 */
public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static final int OK 				   = 200;						// OK: Success!
	private static final int NOT_MODIFIED 		   = 304;			// Not Modified: There was no new data to return.
	private static final int BAD_REQUEST 		   = 400;				// Bad Request: The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.
	private static final int NOT_AUTHORIZED 	   = 401;			// Not Authorized: Authentication credentials were missing or incorrect.
	private static final int FORBIDDEN 			   = 403;				// Forbidden: The request is understood, but it has been refused.  An accompanying error message will explain why.
	private static final int NOT_FOUND             = 404;				// Not Found: The URI requested is invalid or the resource requested, such as a user, does not exists.
	private static final int NOT_ACCEPTABLE        = 406;		// Not Acceptable: Returned by the Search API when an invalid format is specified in the request.
	private static final int INTERNAL_SERVER_ERROR = 500;// Internal Server Error: Something is broken.  Please post to the group so the Weibo team can investigate.
	private static final int BAD_GATEWAY           = 502;// Bad Gateway: Weibo is down or being upgraded.
	private static final int SERVICE_UNAVAILABLE   = 503;// Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.

	private static final String  ENCODE_UTF8      ="UTF-8";
	/**
	 * 
	  * @description 获得httpclient
	  * @author Raul
	  * @time:2013年12月12日 下午8:06:23
	  * @return
	 */
	public  static HttpClient getHttpClient() {
		return HttpConnectionManager.getHttpClient();
	}
	
	/**
	 * 
	  * @description 请求接口后，讲对象返回指定的类型
	  * @author Raul
	  * @time:2013年12月13日 上午11:38:51
	  * @param url
	  * @param beanClass
	  * @return
	 */
	public static <T> T getObjectByGetMethod(String url,Class<T> beanClass){
		  return parseJsonResult(HttpClientUtil.get(url),beanClass);
	}
	
	/**
	 * 
	  * @description 请求接口后，讲对象返回指定的类型
	  * @author Raul
	  * @time:2013年12月13日 上午11:38:51
	  * @param url
	  * @param beanClass
	  * @return
	 */
	public static <T> T getObjectByGetMethod(String url,Map<String, Object> params,Class<T> beanClass){
		  return parseJsonResult(HttpClientUtil.get(url, params),beanClass);
	}
	
	/**
	 * 
	  * @description 请求接口后，讲对象返回指定的类型List
	  * @author Raul
	  * @time:2013年12月13日 上午11:39:10
	  * @param url
	  * @param beanClass
	  * @return
	 */
	public static <T> List<T> getObjectListByGetMethod(String url,Class<T> beanClass){
		  return parseJsonResultList(HttpClientUtil.get(url),beanClass);
	}
	
	/**
	 * 
	  * @description 请求接口后，讲对象返回指定的类型
	  * @author Raul
	  * @time:2013年12月13日 上午11:38:51
	  * @param url
	  * @param beanClass
	  * @return
	 */
	public static <T> T getObjectByPostMethod(String url,Map<String, Object> params,Class<T> beanClass){
		  return parseJsonResult(HttpClientUtil.post(url, params),beanClass);
	}
	
	/**
	 * 
	  * @description 请求接口后，讲对象返回指定的类型List
	  * @author Raul
	  * @time:2013年12月13日 上午11:39:10
	  * @param url
	  * @param beanClass
	  * @return
	 */
	public static <T> List<T> getObjectListByPostMethod(String url,Map<String, Object> params,Class<T> beanClass){
		  return parseJsonResultList(HttpClientUtil.post(url,params),beanClass);
	}
	
	/**
	 * 
	  * @description  用get方法向服务器请求 并获得响应   
	  * @author Raul
	  * @time:2013年12月12日 下午8:06:10
	  * @param url
	  * @return
	 */
    public static String get(String url) {  
    	url = url.trim();
    	logger.debug("get:"+url);
        HttpGet httpGet = new HttpGet(url);  
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        HttpResponse response = null;  
        String html = null;
        int responseCode = -1;
        try {   
        	response = getHttpClient().execute(httpGet); 
            HttpEntity httpEntity = response.getEntity();
            responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == OK && httpEntity != null) {
            	 html = readHtmlContentFromEntity(httpEntity);
            }else {
				throw new HttpClientException(getCause(responseCode),responseCode);
			} 
        } catch (Exception e) {   
            logger.error(e.getMessage(), e);
        }  finally {   
        	httpGet.abort();
        }   
        return html;   
    }  
    
    /**
     * 
      * @description 用get方法向服务器请求 并获得响应   
      * @author Raul
      * @time:2013年12月12日 下午8:10:29
      * @param url
      * @param params
      * @return
     */
    public static String get(String url, Map<String, Object> params){
		if (ValidatorUtil.isNotNull(params)) {
			String encodedParams = HttpClientUtil.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		 return get(url);
	}
    
    /**
     * @description post请求
     *
     * @author xuys
     * 
     * @time 2015年3月23日 下午4:15:59
     *
     * @param
     *
     *
     */
    public static String post(String url){
    	if (ValidatorUtil.isNull(url)) {
			return null;
		}
    	url = url.trim();
    	logger.debug("post:"+url);
        HttpPost httpPost = new HttpPost(url); 
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        HttpResponse response = null;  
        String result = null;
        int responseCode = -1;
        try {   
        	response = getHttpClient().execute(httpPost); 
            HttpEntity httpEntity = response.getEntity();
            responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == OK && httpEntity != null) {
                result = readHtmlContentFromEntity(httpEntity);
            }else {
				throw new HttpClientException(getCause(responseCode),responseCode);
			} 
        } catch (Exception e) {   
            logger.error(e.getMessage(), e);
        }  finally {   
        	httpPost.abort();
        }   
        return result;  
    }
    
    /**
     * @description 下载远程图片
     *
     * @author xuys
     * 
     * @time 2015年5月12日 下午6:13:11
     *
     * @param
     *
     */
	public static void downloadImage(String url, String path, String name){
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		FileOutputStream fops = null;
		try {
			HttpGet method = new HttpGet(url);
			
			HttpResponse response = getHttpClient().execute(method);
			HttpEntity httpEntity = response.getEntity();
			is = httpEntity.getContent();
			
			//输入流转化成字节数组
			baos = new ByteArrayOutputStream();  
			byte[] buffer = new byte[1024];  
			int len = 0;  
			while((len = is.read(buffer)) != -1 ){  
				baos.write(buffer, 0, len);  
			} 
			//转数组之前需先flush,避免流缓存着
			baos.flush();
			byte[] byteImg = baos.toByteArray();
			if (ValidatorUtil.isNotNull(byteImg)) {
			   	File headImgDir = new File(path);
			   	if (!headImgDir.exists()) {
			   		headImgDir.mkdir();
				}
				File file = new File(path + "/" + name);
				fops = new FileOutputStream(file);  
				fops.write(byteImg);  
				fops.flush();  
			}
		} catch (Exception e) {
			logger.error("下载远程图片失败！" + e.getMessage(), e);
		} finally {
			if(ValidatorUtil.isNotNull(is)){
				try {
					is.close();
				} catch (IOException e) {
					logger.error("下载远程图片->关闭Http输入流失败", e);
				}
			}
			if(ValidatorUtil.isNotNull(baos)){
				try {
					baos.close();
				} catch (IOException e) {
					logger.error("下载远程图片->关闭字节输出流失败", e);
				}
			}
			
			if(ValidatorUtil.isNull(fops)){
				try {
					fops.close();
				} catch (IOException e) {
					logger.error("下载远程图片->关闭字节文件输出流失败", e);
				}
			}
		}
	}
    
    /**
	 * 
	  * @description  用post方法向服务器请求 并获得响应   
	  * @author Raul
	  * @time:2013年12月12日 下午8:06:10
	  * @param url
	  * @return
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static String post(String url, Map<String, Object> params) {  
    	url = url.trim();
    	logger.debug("post:"+url);
        HttpPost httpPost = new HttpPost(url); 
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        HttpResponse response = null;  
        String html = null;
        int responseCode = -1;
        try {   
        	// 添加参数  
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();  
            if (params != null && params.keySet().size() > 0)  
            {  
                Iterator iterator = params.entrySet().iterator();  
                while (iterator.hasNext())  
                {  
                    Map.Entry<String, String> entry = (Entry) iterator.next();  
                    nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
                }  
            }  
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList, ENCODE_UTF8));  
        	response = getHttpClient().execute(httpPost); 
            HttpEntity httpEntity = response.getEntity();
            responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == OK && httpEntity != null) {
                html = readHtmlContentFromEntity(httpEntity);
            }else {
				throw new HttpClientException(getCause(responseCode),responseCode);
			} 
        } catch (Exception e) {   
            logger.error(e.getMessage(), e);
        }  finally {   
        	httpPost.abort();
        }   
        return html;   
    }  
    
    /**
     * @description: 直接发送参数，不带参数名称
     * 
     * @author xuys
     *
     * @time 2015年3月11日	
     * 
     * @param
     */
    public static String post(String url, String params){
    	if (ValidatorUtil.isNull(url)) {
			return null;
		}
    	String html = null;
        int responseCode = -1;
        
    	url = url.trim();
    	logger.debug("post:" + url);
    	
        HttpPost httpPost = new HttpPost(url); 
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        
        HttpResponse response = null;  
        
        try {   
        	// 添加参数  
        	StringEntity stringEntity = new StringEntity(params, ENCODE_UTF8);
        	httpPost.setEntity(stringEntity);
        	
        	response = getHttpClient().execute(httpPost); 
        	
            HttpEntity httpEntity = response.getEntity();
            
            responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == OK && httpEntity != null) {
               html = readHtmlContentFromEntity(httpEntity);
            }else {
				throw new HttpClientException(getCause(responseCode),responseCode);
			} 
        } catch (Exception e) {   
            logger.error(e.getMessage(), e);
        } finally {   
        	httpPost.abort();
        }  
        
        return html;   
    }
    
    /**
     * @description 请求并获取文件
     *
     * @author xuys
     * 
     * @time 2015年4月21日 上午10:27:23
     *
     * @param
     *
     */
    public static boolean post(String url, File file, String params){
    	boolean isSuccess = false;
    	if (ValidatorUtil.isNull(url)) {
			return isSuccess;
		}
    	url = url.trim();
    	
    	int responseCode = -1;
    	logger.debug("post:" + url);
    	
        HttpPost httpPost = new HttpPost(url); 
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        
        HttpResponse response = null;  
        OutputStream os = null;
        InputStream is = null;
        
        try {   
        	// 添加参数  
        	StringEntity stringEntity = new StringEntity(params, ENCODE_UTF8);
        	httpPost.setEntity(stringEntity);
        	
        	response = getHttpClient().execute(httpPost); 
        	
            HttpEntity httpEntity = response.getEntity();
            
            responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == OK && httpEntity != null) {
            	os = new FileOutputStream(file);
            	
            	is = httpEntity.getContent();
            	int bytesRead = 0;
            	byte[] buffer = new byte[1024];
            	while ((bytesRead = is.read(buffer, 0, 1024)) != -1) {
            		os.write(buffer, 0, bytesRead);
            	}
            	os.close();
            	is.close();
            	
            	isSuccess = true;
            }else {
				throw new HttpClientException(getCause(responseCode),responseCode);
			} 
        } catch (Exception e) {   
            logger.error(e.getMessage(), e);
        } finally {   
        	try {
				if (is != null) {
					is.close();
				}
				
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				logger.error("关闭流失败！" + e.getMessage(), e);
			}
        	httpPost.abort();
        }  
        
        return isSuccess;
    }
    
    /**
     * @description get请求下载文件
     *
     * @author xuys
     * 
     * @time 2015年4月27日 下午5:04:35
     *
     * @param
     *
     */
    public static boolean get(String url, File file){
    	boolean isSuccess = false;
    	if (ValidatorUtil.isNull(url)) {
			return isSuccess;
		}
    	url = url.trim();
    	
    	int responseCode = -1;
    	logger.debug("post:" + url);
    	
        HttpGet httpGet = new HttpGet(url); 
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        
        HttpResponse response = null;  
        OutputStream os = null;
        InputStream is = null;
        
        try {   
        	response = getHttpClient().execute(httpGet); 
        	
            HttpEntity httpEntity = response.getEntity();
            
            responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == OK && httpEntity != null) {
            	os = new FileOutputStream(file);
            	
            	is = httpEntity.getContent();
            	int bytesRead = 0;
            	byte[] buffer = new byte[1024];
            	while ((bytesRead = is.read(buffer, 0, 1024)) != -1) {
            		os.write(buffer, 0, bytesRead);
            	}
            	os.close();
            	is.close();
            	
            	isSuccess = true;
            }else {
				throw new HttpClientException(getCause(responseCode),responseCode);
			} 
        } catch (Exception e) {   
            logger.error(e.getMessage(), e);
        } finally {   
        	try {
				if (is != null) {
					is.close();
				}
				
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				logger.error("关闭流失败！" + e.getMessage(), e);
			}
        	httpGet.abort();
        }  
        
        return isSuccess;
    }
    
    /**
     * @description   发送图片
     *
     * @author xuys
     * 
     * @time 2015年3月24日 上午11:34:54
     *
     * @param
     *
     */
    public static String postImage(String filePath, String fileType, String url, Map<String, Object> params){
         if (ValidatorUtil.isNull(url)) {
             return null;
         }
         // 模拟表单上传 POST 提交主体内容
         String boundary = "-----------------------------" + new Date().getTime();
         // 待上传的文件
         File file = new File(filePath);

         if (!file.exists() || file.isDirectory()) {
             return null;
         }

         // 响应内容
         String respContent = null;
         InputStream is = null;
         OutputStream os = null;
         BufferedInputStream bis = null;
         File tempFile = null;
         CloseableHttpClient httpClient = null;
         HttpPost httpPost = null;
         try {
             // 创建临时文件，将post内容保存到该临时文件下，临时文件保存在系统默认临时目录下，使用系统默认文件名称
             tempFile = File.createTempFile(new SimpleDateFormat("yyyy_MM_dd").format(new Date()), null);
             os = new FileOutputStream(tempFile);
             is = new FileInputStream(file);

             os.write(("--" + boundary + "\r\n").getBytes());
             os.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"" + file.getName() + "\"\r\n").getBytes());
             os.write(String.format("Content-Type: %s\r\n\r\n", fileType).getBytes());

             // 读取上传文件
             bis = new BufferedInputStream(is);
             byte[] buff = new byte[8096];
             int len = 0;
             while ((len = bis.read(buff)) != -1) {
                 os.write(buff, 0, len);
             }

             os.write(("\r\n--" + boundary + "--\r\n").getBytes());

             httpClient = HttpClients.createDefault();
             // 创建POST请求
             httpPost = new HttpPost(url);

             // 创建请求实体
             FileEntity reqEntity = new FileEntity(tempFile, ContentType.MULTIPART_FORM_DATA);

             // 设置请求编码
             reqEntity.setContentEncoding("UTF-8");
             httpPost.setEntity(reqEntity);
             // 执行请求
             HttpResponse response = httpClient.execute(httpPost);
             // 获取响应内容
             HttpEntity httpEntity = response.getEntity();
             Integer responseCode = response.getStatusLine().getStatusCode();
             if (responseCode == OK && httpEntity != null) {
            	 respContent = readHtmlContentFromEntity(httpEntity);
             }
         } catch (ClientProtocolException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                if (is != null) {
                	is.close();
                }
                if (os != null) {
					os.close();
				}
                if (bis != null) {
					bis.close();
				}
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         return respContent;
    }
    
    /**
     * 
      * @description 
      * @author Raul
      * @time:2013年12月13日 下午2:33:01
      * @param url    下载地址
      * @param fileName 保存到本地文件的地址  
     */
    public static void getFile(String url, String fileName){  
        HttpGet httpGet = new HttpGet(url);  
        try  
        {  
            ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>()  
            {  
                public byte[] handleResponse(HttpResponse response)  
                        throws ClientProtocolException, IOException  
                {  
                    HttpEntity entity = response.getEntity();  
                    if (entity != null)  
                    {  
                        return EntityUtils.toByteArray(entity);  
                    } else  
                    {  
                        return null;  
                    }  
                }  
            };  
  
            byte[] charts = getHttpClient().execute(httpGet, handler);  
            FileOutputStream out = new FileOutputStream(fileName);  
            out.write(charts);  
            out.close();  
        } catch (Exception e)  {  
        	 logger.error(e.getMessage(), e);
        } finally{  
        	httpGet.abort();
        }  
    }  
    

    /**
	 * 
	  * @description 将JSON对象转为具体对象
	  * @author Raul
	  * @time:2013年12月13日 下午2:43:18
	  * @param result
	  * @param beanClass
	  * @return
	 */
	public static <T> T parseJsonResult(String result,Class<T> beanClass){
		  if (ValidatorUtil.isNotNull(result)) {
			 return JSON.parseObject(result, beanClass);
		  }
		  return null;
	}
	
	/**
	 * 
	  * @description 将JSON对象转为具体对象的LIST
	  * @author Raul
	  * @time:2013年12月13日 下午2:44:44
	  * @param result
	  * @param beanClass
	  * @return
	 */
	public static <T> List<T> parseJsonResultList(String result,Class<T> beanClass){
		  if (ValidatorUtil.isNotNull(result)) {
			 return JSON.parseArray(result, beanClass);
		  }
		  return null;
	}
	
	 /**
     * 从response返回的实体中读取页面代码
     * @param httpEntity Http实体
     * @return 页面代码
     * @throws ParseException
     * @throws IOException
     */
    public static String readHtmlContentFromEntity(HttpEntity httpEntity) throws ParseException, IOException {
        String html = "";
        Header header = httpEntity.getContentEncoding();
        if(httpEntity.getContentLength() < 2147483647L){
        	//EntityUtils无法处理ContentLength超过2147483647L的Entity
            if(header != null && "gzip".equals(header.getValue())){
                html = EntityUtils.toString(new GzipDecompressingEntity(httpEntity));
            } else {
                html = EntityUtils.toString(httpEntity, ENCODE_UTF8);
            }
        } else {
            InputStream in = httpEntity.getContent();
            if(header != null && "gzip".equals(header.getValue())){
                html = unZip(in, ContentType.getOrDefault(httpEntity).getCharset().toString());
            } else {
                html = readInStreamToString(in, ContentType.getOrDefault(httpEntity).getCharset().toString());
            }
            if(in != null){
                in.close();
            }
        }
        return html;
    }
    
    
    /**
     * 解压服务器返回的gzip流
     * @param in 抓取返回的InputStream流
     * @param charSet 页面内容编码
     * @return 页面内容的String格式
     * @throws IOException
     */
    public static String unZip(InputStream in, String charSet) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPInputStream gis = null;
        try {
            gis = new GZIPInputStream(in);
            byte[] _byte = new byte[1024];
            int len = 0;
            while ((len = gis.read(_byte)) != -1) {
                baos.write(_byte, 0, len);
            }
            String unzipString = new String(baos.toByteArray(), charSet);
            return unzipString;
        } finally {
            if (gis != null) {
                gis.close();
            }
            if(baos != null){
                baos.close();
            }
        }
    }
    
    /**
     * 读取InputStream流
     * @param in InputStream流
     * @return 从流中读取的String
     * @throws IOException
     */
    public static String readInStreamToString(InputStream in, String charSet) throws IOException {
        StringBuilder str = new StringBuilder();
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, charSet));
        while((line = bufferedReader.readLine()) != null){
            str.append(line);
            str.append("\n");
        }
        if(bufferedReader != null) {
            bufferedReader.close();
        }
        return str.toString();
    }
	
    /*
	 * 对parameters进行encode处理
	 */
	@SuppressWarnings("rawtypes")
	public static String encodeParameters(Map<String, Object> params) {
		StringBuffer buf = new StringBuffer();
		for (Entry entry : params.entrySet()) {
            Object key = entry.getKey();
            String val = nullToString(entry.getValue());
            try {
				buf.append("&").append(URLEncoder.encode(key.toString(), ENCODE_UTF8))
				.append("=").append(URLEncoder.encode(val,ENCODE_UTF8));
			} catch (UnsupportedEncodingException e) {
				 logger.error(e.getMessage(), e);
			}
        }
		return buf.toString();
	}
	
	private static String nullToString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }
	
	public static String getCause(int statusCode) {
		String cause = null;
		switch (statusCode) {
		case NOT_MODIFIED:
			break;
		case BAD_REQUEST:
			cause = "The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.";
			break;
		case NOT_AUTHORIZED:
			cause = "Authentication credentials were missing or incorrect.";
			break;
		case FORBIDDEN:
			cause = "The request is understood, but it has been refused.  An accompanying error message will explain why.";
			break;
		case NOT_FOUND:
			cause = "The URI requested is invalid or the resource requested, such as a user, does not exists.";
			break;
		case NOT_ACCEPTABLE:
			cause = "Returned by the Search API when an invalid format is specified in the request.";
			break;
		case INTERNAL_SERVER_ERROR:
			cause = "Something is broken.  Please post to the group so the Weibo team can investigate.";
			break;
		case BAD_GATEWAY:
			cause = "Weibo is down or being upgraded.";
			break;
		case SERVICE_UNAVAILABLE:
			cause = "Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.";
			break;
		default:
			cause = "";
		}
		return statusCode + ":" + cause;
	}
	
	public static void main(String[] args) throws Exception {
		String url = "";
		url="http://www.weather.com.cn/data/sk/101010100.html";
		//访问token
		System.out.println(HttpClientUtil.get("www.fengchaodata.com"));
		System.out.println(HttpClientUtil.get(url));
	}
	
}
