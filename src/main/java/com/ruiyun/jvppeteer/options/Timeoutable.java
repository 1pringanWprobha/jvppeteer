package com.ruiyun.jvppeteer.options;

public class Timeoutable {
	
	/**
	 * �ȴ������ʵ���������ʱ�䣨�Ժ���Ϊ��λ����Ĭ���� 30000 (30 ��). ͨ�� 0 �����ó�ʱ��
	 * <br/>
     * Maximum navigation time in milliseconds, pass 0 to disable timeout.
     * @default 30000
     */
	private int timeout = 30000;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	
}
