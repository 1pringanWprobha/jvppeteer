package com.ruiyun.jvppeteer;

import com.ruiyun.jvppeteer.browser.Browser;
import com.ruiyun.jvppeteer.launch.ChromeLauncher;
import com.ruiyun.jvppeteer.launch.FirefoxLauncher;
import com.ruiyun.jvppeteer.launch.Launcher;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.OptionsBuilder;
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

	public String productName = null;

	private Launcher launcher;
	
	private Environment env = null;
//	private String projectRoot;
//
//	private String preferredRevision;

	private boolean isPuppeteerCore;

	public Puppeteer() {

	}

	/**
	 * ��Ĭ�ϲ������������
	 * <br/>
	 * launch Browser by default options
	 * @return
	 */
	public static Browser launch(){
		return Puppeteer.rawLaunch();
	}

	public static  Browser launch(boolean headless) {
		return Puppeteer.rawLaunch(headless);
	}

	public static  Browser launch(LaunchOptions options) {
		Puppeteer puppeteer = new Puppeteer();
		return Puppeteer.rawLaunch(options,puppeteer);
	}

	private static Browser rawLaunch() {
		return Puppeteer.rawLaunch(true);
	}
	
	private static Browser rawLaunch(boolean headless) {
		Puppeteer puppeteer = new Puppeteer();
		return Puppeteer.rawLaunch(new OptionsBuilder().withHeadless(headless).build(),puppeteer);
	}
	
	/**
	 * The method launches a browser instance with given arguments. The browser will
	 * be closed when the parent java process is closed.
	 */
	private static Browser rawLaunch(LaunchOptions options,Puppeteer puppeteer) {
		if (!StringUtil.isNotBlank(options.getProduct())) {
			puppeteer.setProductName(options.getProduct()) ;
		}
		adapterLauncher(puppeteer);
		Browser browser = puppeteer.getLauncher().launch(options);
		return browser;
	}
	
	/**
	 * ����chrome or firefox �����
	 */
	public static void adapterLauncher(Puppeteer puppeteer) {
		String productName = null;
		Launcher launcher = null;
		Environment env;
		if (StringUtil.isEmpty(productName = puppeteer.getProductName()) && !puppeteer.getIsPuppeteerCore()) {

			if((env = puppeteer.getEnv()) == null){
				puppeteer.setEnv(env = System::getenv);
			}
			for (int i = 0; i < PRODUCT_ENV.length; i++) {
				String envProductName = PRODUCT_ENV[i];
				productName = env.getEnv(envProductName);
				if(StringUtil.isNotEmpty(productName)){
					puppeteer.setProductName(productName);
					break;
				}
			}
		}
		if(StringUtil.isEmpty(productName)){
			productName = "chrome";
			puppeteer.setProductName(productName);
		}
		switch (productName) {
		case "firefox":
			launcher = new FirefoxLauncher(puppeteer.getIsPuppeteerCore());
		case "chrome":
		default:
			launcher = new ChromeLauncher(puppeteer.getIsPuppeteerCore());
		}
		puppeteer.setLauncher(launcher);
	}

	public  String getProductName() {
		return productName;
	}

	public  void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean getIsPuppeteerCore() {
		return isPuppeteerCore;
	}

	public void setIsPuppeteerCore(boolean puppeteerCore) {
		isPuppeteerCore = puppeteerCore;
	}

	public Launcher getLauncher() {
		return launcher;
	}

	public void setLauncher(Launcher launcher) {
		this.launcher = launcher;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}
}
