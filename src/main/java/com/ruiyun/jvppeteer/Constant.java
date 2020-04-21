package com.ruiyun.jvppeteer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ������õ��ĳ���
 */
public interface Constant {

	/**
	 * �Ѳ�Ʒ��ŵ��������������п����ֶ�
	 */
	String[] PRODUCT_ENV = {"PUPPETEER_PRODUCT","java_config_puppeteer_product","java_package_config_puppeteer_product"};

	/**
	 * �������ִ��·����ŵ��������������п����ֶ�
	 */
	String[] EXECUTABLE_ENV = {"PUPPETEER_EXECUTABLE_PATH","java_config_puppeteer_executable_path","java_package_config_puppeteer_executable_path"};

	/**
	 * ��������汾��ŵ������������ֶ�
	 */
	String PUPPETEER_CHROMIUM_REVISION_ENV = "PUPPETEER_CHROMIUM_REVISION";

	/**
	 * websocket clinet �������ݵ������أ�����Ŀǰû�����ý�ȥ��ʹ����Ĭ��ֵ
	 */
	long DEFAULT_PAYLOAD  = 256 * 1024 * 1024;

	/**
	 * ���websoketʹ��tyrus�Ļ��������õ�����ֶΣ���{@link Constant#DEFAULT_PAYLOAD} һ�����ʹ��
	 */
	String INCOMING_BUFFER_SIZE_PROPERTY = "org.glassfish.tyrus.incomingBufferSize";

	/**
	 * ���������ʱ�����û��ָ��·������ô�������·��������ִ�е�·��
	 */
	String[] PROBABLE_CHROME_EXECUTABLE_PATH =
		      new String[] {
		        "/usr/bin/chromium",
		        "/usr/bin/chromium-browser",
		        "/usr/bin/google-chrome-stable",
		        "/usr/bin/google-chrome",
		        "/Applications/Chromium.app/Contents/MacOS/Chromium",
		        "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
		        "/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary",
		        "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"
		      };
	/**
	 * �ȸ������Ĭ����������
	 */
	List<String> DEFAULT_ARGS = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{addAll(Arrays.asList( 
					"--disable-background-networking",
	                "--disable-background-timer-throttling",
	                "--disable-breakpad",
	                "--disable-browser-side-navigation",
	                "--disable-client-side-phishing-detection",
	                "--disable-default-apps",
	                "--disable-dev-shm-usage",
	                "--disable-extensions",
	                "--disable-features=site-per-process",
	                "--disable-hang-monitor",
	                "--disable-popup-blocking",
	                "--disable-prompt-on-repost",
	                "--disable-sync",
	                "--disable-translate",
	                "--metrics-recording-only",
	                "--no-first-run",
	                "--safebrowsing-disable-auto-update",
	                "--enable-automation",
	                "--password-store=basic",
	                "--use-mock-keychain"));}
	};

	/**
	 * fastjson��һ��ʵ��
	 */
	ObjectMapper OBJECTMAPPER = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).setSerializationInclusion(Include.NON_NULL);

	/**
	 * ���������websocket���ܵ���Ϣ����������Щ�ֶΣ��ڴ�����Ϣ�õ���Щ�ֶ�
	 */
	String RECV_MESSAGE_METHOD_PROPERTY = "method";
	String RECV_MESSAGE_PARAMS_PROPERTY = "params";
	String RECV_MESSAGE_ID_PROPERTY = "id";
	String RECV_MESSAGE_RESULT_PROPERTY = "result";
	String RECV_MESSAGE_SESSION_ID_PROPERTY = "sessionId";
	String RECV_MESSAGE_TARGETINFO_PROPERTY = "targetInfo";
	String RECV_MESSAGE_TYPE_PROPERTY = "type";
	String RECV_MESSAGE_ERROR_PROPERTY = "error";
	String RECV_MESSAGE_ERROR_MESSAGE_PROPERTY = "message";
	String RECV_MESSAGE_ERROR_DATA_PROPERTY = "data";
	String RECV_MESSAGE_TARFETINFO_TARGETID_PROPERTY = "targetId";
	String RECV_MESSAGE_STREAM_PROPERTY = "stream";
	String RECV_MESSAGE_STREAM_EOF_PROPERTY = "eof";
	String RECV_MESSAGE_STREAM_DATA_PROPERTY = "data";
	String RECV_MESSAGE_BASE64ENCODED_PROPERTY = "base64Encoded";

	/**
	 * ִ���¼��������̳߳�
	 */
	ThreadPoolExecutor executor = getThreadPoolExecutor();

	static ThreadPoolExecutor getThreadPoolExecutor() {
		Runtime runtime = Runtime.getRuntime();

		int processorNum = runtime.availableProcessors();

		if(processorNum < 3){
			processorNum = 3;
		}
		return  new ThreadPoolExecutor(processorNum,processorNum,30, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
	}

	/**
	 * Ĭ�ϵĳ�ʱʱ�䣺���������ʵ����ʱ��websocket������Ϣ��ʱ��
	 */
	int DEFAULT_TIMEOUT = 30000;

	/**
	 * ׷����Ϣ��Ĭ�Ϸ���
	 */
	Set<String> DEFAULTCATEGORIES = new LinkedHashSet<String>(){
		private static final long serialVersionUID = -5224857570151968464L;

		{
			add("-*");
			add("devtools.timeline");
			add("v8.execute");
			add("disabled-by-default-devtools.timeline");
			add("disabled-by-default-devtools.timeline.frame");
			add("toplevel");
			add("blink.console");
			add("blink.user_timing");
			add("latencyInfo");
			add("disabled-by-default-devtools.timeline.stack");
			add("disabled-by-default-v8.cpu_profiler");
			add("disabled-by-default-v8.cpu_profiler.hires");
		}
	};
}
