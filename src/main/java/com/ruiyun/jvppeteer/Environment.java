package com.ruiyun.jvppeteer;

/**
 * ���������Ľӿ�:����ʹ��System:getEnv��ʵ��
 */
@FunctionalInterface
public interface Environment {

	/**
	 * ����name��ȡ���������е�ֵ
	 * @param name
	 * @return
	 */
	String getEnv(String name);
	
}
