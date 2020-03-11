package com.ruiyun.jvppeteer.options;


import com.ruiyun.jvppeteer.Environment;

public class LaunchOptions extends BrowserOptions {

	public LaunchOptions() {
		
	}
	/**
	 * ������ Chromium �� Chrome ��ִ���ļ���·���������ǰ󶨵� Chromium����� executablePath ��һ�����·������ô������� ��ǰ����·�� ����
	 * <br/>
	 * Path to a Chromium executable to run instead of bundled Chromium. If
	 * executablePath is a relative path, then it is resolved relative to current
	 * working directory.
	 */
	private String executablePath;
	
	/**
	 * �������е�Ĭ�ϲ���,���ѡ�������ʹ�á�Ĭ��Ϊ false��
	 * 
	 * <br/>
	 * Do not use `puppeteer.defaultArgs()` for launching Chromium.
	 * @default false
	 */
	private boolean ignoreDefaultArgs;
	/**
	 * ���˵�������Ĭ�ϲ�����
	 * <br/>
	 */
	private String[] ignoreAllDefaultArgs;
	
	/**
	 * Ctrl-C �ر���������̡�Ĭ���� true
	 * Close chrome process on Ctrl-C.
	 * @default true
	 */
	private boolean handleSIGINT = true;
	
	/**
	 * �ر� SIGTERM �ϵ���������̡�Ĭ���� true
	 * Close chrome process on SIGTERM.
	 * @default true
	 */
	private boolean handleSIGTERM = true;
	
	/**
	 * �ر� SIGHUP �ϵ���������̡�Ĭ���� true 
	 * <br/>
	 * Close chrome process on SIGHUP.
	 * @default true
	 */
	private boolean handleSIGHUP = true;
	
	/**
	 * �Ƿ���������̱�׼����ͱ�׼�������뵽 process.stdout �� process.stderr �С�Ĭ���� false��
	 * <br/>
	 * Whether to pipe browser process stdout and stderr into process.stdout and
	 * process.stderr.
	 * @default false
	 */
	private boolean dumpio ;
	  
	 /**
	  * ָ��������ɼ��Ļ���������Ĭ���� System.getEnv()
	  * <br/>
	  * Specify environment variables that will be visible to Chromium.
	  * @default `process.env`.
	  */
	private Environment env;
	
	/**
	 * ͨ���ܵ�������WebSocket���ӵ��������Ĭ���� false
	 * Connects to the browser over a pipe instead of a WebSocket.
	 * @default false
	 */
	private boolean pipe;
	
	/**
	 * �����Ĳ�Ʒ��chrome or firefox
	 */
	private String product;

	public String getExecutablePath() {
		return executablePath;
	}

	public void setExecutablePath(String executablePath) {
		this.executablePath = executablePath;
	}

	public boolean isIgnoreDefaultArgs() {
		return ignoreDefaultArgs;
	}

	public void setIgnoreDefaultArgs(boolean ignoreDefaultArgs) {
		this.ignoreDefaultArgs = ignoreDefaultArgs;
	}

	public String[] getIgnoreAllDefaultArgs() {
		return ignoreAllDefaultArgs;
	}

	public void setIgnoreAllDefaultArgs(String[] ignoreAllDefaultArgs) {
		this.ignoreAllDefaultArgs = ignoreAllDefaultArgs;
	}

	public boolean isHandleSIGINT() {
		return handleSIGINT;
	}

	public void setHandleSIGINT(boolean handleSIGINT) {
		this.handleSIGINT = handleSIGINT;
	}

	public boolean isHandleSIGTERM() {
		return handleSIGTERM;
	}

	public void setHandleSIGTERM(boolean handleSIGTERM) {
		this.handleSIGTERM = handleSIGTERM;
	}

	public boolean isHandleSIGHUP() {
		return handleSIGHUP;
	}

	public void setHandleSIGHUP(boolean handleSIGHUP) {
		this.handleSIGHUP = handleSIGHUP;
	}

	public boolean isDumpio() {
		return dumpio;
	}

	public void setDumpio(boolean dumpio) {
		this.dumpio = dumpio;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public boolean isPipe() {
		return pipe;
	}

	public void setPipe(boolean pipe) {
		this.pipe = pipe;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	 
	 
}
