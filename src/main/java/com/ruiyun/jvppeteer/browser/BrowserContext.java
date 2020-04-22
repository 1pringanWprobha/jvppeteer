package com.ruiyun.jvppeteer.browser;

import com.ruiyun.jvppeteer.events.EventEmitter;
import com.ruiyun.jvppeteer.protocol.page.Page;
import com.ruiyun.jvppeteer.transport.Connection;

/**
 * �����������
 */
public class BrowserContext extends EventEmitter {

	/**
	 *  �������Ӧ��websocket client��װ�࣬���ڷ��ͺͽ�����Ϣ
	 */
	private Connection connection;

	/**
	 * ����������Ķ�Ӧ���������һ��������ֻ��һ�������������һ������������ж��������
	 */
	private Browser browser;

	/**
	 *�����������id
	 */
	private String contextId;
	
	

	public BrowserContext(Connection connection, Browser browser, String contextId) {
		super();
		this.connection = connection;
		this.browser = browser;
		this.contextId = contextId;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public String getContextId() {
		return contextId;
	}

	public void setContextId(String contextId) {
		this.contextId = contextId;
	}

	public Page newPage(){
		return browser.createPageInContext(this.contextId);
	}
	
}
