package com.ruiyun.jvppeteer.options;

public class BrowserOptions extends ChromeArgOptions {

	/**
	 * �Ƿ��ڵ����ڼ���� HTTPS ����. Ĭ���� false
   * <br/>
   * Whether to ignore HTTPS errors during navigation.
   * 
   * @default false
   */
	private boolean ignoreHTTPSErrors;
	/**
	   *     Ϊÿ��ҳ������һ��Ĭ���ӿڴ�С��Ĭ���� 800x600�����Ϊ null �Ļ��ͽ�����ͼ�ڡ�
	 * <br/>
	 * Sets a consistent viewport for each page. Defaults to an 800x600 viewport. null disables the default viewport.
	 */
	private DefaultViewport defaultViewport = new DefaultViewport();
	/**
	 *  �� Puppeteer ��������ָ���ĺ�������������Ϳ��Կ��巢����ʲô���������
	 *  <br/>
	 *  Slows down Puppeteer operations by the specified amount of milliseconds.
	 *  Useful so that you can see what is going on.
	 */
	private int slowMo;
	  
	public boolean getIgnoreHTTPSErrors() {
		return ignoreHTTPSErrors;
	}
	
	public void setIgnoreHTTPSErrors(boolean ignoreHTTPSErrors) {
		this.ignoreHTTPSErrors = ignoreHTTPSErrors;
	}
	
	public DefaultViewport getDefaultViewport() {
		return defaultViewport;
	}
	
	public void setDefaultViewport(DefaultViewport defaultViewport) {
		this.defaultViewport = defaultViewport;
	}
	
	public int getSlowMo() {
		return slowMo;
	}
	
	public void setSlowMo(int slowMo) {
		this.slowMo = slowMo;
	}
	  
}
