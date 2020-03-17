package com.ruiyun.jvppeteer.options;

import java.util.List;

public class ChromeArgOptions {
	/**
	 * �Ƿ��� ��ͷģʽ �����������Ĭ���� true������ devtools ѡ���� true
	 * <br/>
     * Whether to run browser in headless mode.
     * @default true unless the devtools option is true.
     */
    private boolean headless = true;
    /**
     * 
     *  ���ݸ������ʵ������������  ���Կ����
     *  https://peter.sh/experiments/chromium-command-line-switches/
     * <br/>
     * Additional arguments to pass to the browser instance.
     * The list of Chromium flags can be found here.
     */
    private List<String> args ;
    /**
     * �û�����Ŀ¼ ·��
     * <br/>
     * Path to a User Data Directory.
     */
    private String userDataDir;
    /**
     * �Ƿ�Ϊÿ��ѡ��Զ���DevTools��塣������ѡ���� true��headless ѡ������ó� false��
     * <br/>
     * Whether to auto-open a DevTools panel for each tab.
     * If this option is true, the headless option will be set false.
     */
    private boolean devtools;
    
	public boolean getHeadless() {
		return headless;
	}
	
	public void setHeadless(boolean headless) {
		this.headless = headless;
	}
	
	public List<String> getArgs() {
		return args;
	}
	
	public void setArgs(List<String> args) {
		this.args = args;
	}
	
	public String getUserDataDir() {
		return userDataDir;
	}
	
	public void setUserDataDir(String userDataDir) {
		this.userDataDir = userDataDir;
	}
	
	public boolean getDevtools() {
		return devtools;
	}
	
	public void setDevtools(boolean devtools) {
		this.devtools = devtools;
	}
    
    
}
