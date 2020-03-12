package com.ruiyun.jvppeteer;

import com.ruiyun.jvppeteer.launch.ChromeLauncher;
import com.ruiyun.jvppeteer.launch.FirefoxLauncher;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.util.StringUtil;

/**
 * Puppeteer Ҳ������������ Chrome ������� ������󶨵� Chromium
 * �汾��һ��ʹ��Ч����á����ܱ�֤���������κ������汾һ��ʹ�á�������ʹ�� executablePath ѡ� ��� Google
 * Chrome��������Chromium������ѡ��һ�� Chrome Canary �� Dev Channel �汾�ǽ����
 * 
 * @author fff
 *
 */
public class Puppeteer implements Constant {

	public static String _productName = null;

	private Launcher launcher;
	private Environment env = null;
//	private String projectRoot;
//
//	private String preferredRevision;

	private boolean isPuppeteerCore;

	public Puppeteer() {

	}

	public Puppeteer(boolean isPuppeteerCore) {
		super();
		this.isPuppeteerCore = isPuppeteerCore;
	}

	/**
	 * The method launches a browser instance with given arguments. The browser will
	 * be closed when the parent java process is closed.
	 */
	public Browser launch(LaunchOptions options) {
		if (_productName == null && !StringUtil.isNotBlank(options.getProduct())) {
			_productName = options.getProduct();
		}
		adapterLauncher();
		Browser browser = launcher.launch(options);
		return browser;
	}
	
	/**
	 * ����chrome or firefox �����
	 */
	public void adapterLauncher() {
		if (StringUtil.isEmpty(_productName) && !isPuppeteerCore) {
			env = System::getenv;
			for (int i = 0; i < PRODUCT_ENV.length; i++) {
				String envName = PRODUCT_ENV[i];
				_productName = env.getEnv(envName);
			}
		}
		switch (_productName) {
		case "firefox":
			launcher = new FirefoxLauncher(isPuppeteerCore);
		case "chrome":
		default:
			launcher = new ChromeLauncher(isPuppeteerCore);
		}
	}

}
