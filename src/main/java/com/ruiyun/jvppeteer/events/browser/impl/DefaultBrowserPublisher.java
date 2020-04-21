package com.ruiyun.jvppeteer.events.browser.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.ruiyun.jvppeteer.Constant;
import com.ruiyun.jvppeteer.events.browser.definition.BrowserEventPublisher;
import com.ruiyun.jvppeteer.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Ĭ���¼������⣬��Ψһʵ�������{@link com.ruiyun.jvppeteer.util.Factory}
 */
public class DefaultBrowserPublisher implements BrowserEventPublisher, Constant {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBrowserPublisher.class);

	private Map<String, Set<DefaultBrowserListener>> listenerMap = new ConcurrentHashMap<>();

	/**
	 * �����¼�
	 * @param method �¼���Ӧ�ķ���
	 * @param event Ҫ�������¼�
	 */
	@Override
	public void publishEvent(String method, Object event) {
		Set<DefaultBrowserListener> browserListeners = listenerMap.get(method);
		synchronized (DefaultBrowserPublisher.class){
			browserListeners = new LinkedHashSet(browserListeners);
		}
		for (DefaultBrowserListener listener : browserListeners) {
			executor.execute(() -> invokeListener(listener, event));
		}
	}

	/**
	 * ����һ��������
	 * @param method ��������Ӧ�ķ���
	 * @param listener Ҫ���ӵļ�����
	 */
	public void addListener(String method,DefaultBrowserListener listener){
		Set<DefaultBrowserListener> browserListeners = listenerMap.get(method);
		if (browserListeners == null) {
			Set<DefaultBrowserListener> listeners = getConcurrentSet();
			listenerMap.putIfAbsent(method,listeners);
			listeners.add(listener);
		}else{
			browserListeners.add(listener);
		}

	}

	/**
	 * ִ�м�������������û��ļ����������û��Ĵ�����ȥ������Ȼִ��onBrowserEvent����
	 * @param listener ������
	 * @param event �¼�
	 */
	public void invokeListener(DefaultBrowserListener listener, Object event){
		if(listener.getHandler() != null){
			listener.getHandler().onEvent(event);
		}else{
			listener.onBrowserEvent(event);
		}
	}

	/**
	 * �����¼�
	 * @param method ����
	 * @param params �¼� event
	 */
	public void publishEvent2(String method, JsonNode params) {
		ValidateUtil.notNull(method, "method must not be null");
		Set<DefaultBrowserListener> browserListeners = listenerMap.get(method);
		if (ValidateUtil.isNotEmpty(browserListeners)) {
			try {
				Class<?> resolveType = null;
				DefaultBrowserListener listener = browserListeners.stream().findFirst().get();
				Type genericSuperclass = listener.getClass().getGenericSuperclass();
				if(genericSuperclass instanceof ParameterizedType){
					ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
					Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
					if(actualTypeArguments.length == 1){
						resolveType = (Class)actualTypeArguments[0];
					}
				}else{
					resolveType = listener.getResolveType();
				}
				Object event = readJsonObject(resolveType, params);
				this.publishEvent(method, event);
			} catch (IOException e) {
				LOGGER.error("publish event error:", e);
			}
		}
	}

	/**
	 * ���clazz����JsonNode.class����ת�����ͣ�������ǣ���jsonNodeת����clazz���Ͷ���
	 * @param clazz Ŀ������
	 * @param jsonNode event
	 * @param <T>  ��������
	 * @return T
	 * @throws IOException ת��ʧ���׳����쳣
	 */
	private <T> T readJsonObject(Class<T> clazz, JsonNode jsonNode) throws IOException {
		if (jsonNode == null) {
			throw new IllegalArgumentException(
					"Failed converting null response to clazz " + clazz.getName());
		}
		if(JsonNode.class.isAssignableFrom(clazz)){
			return (T)jsonNode;
		}
		return OBJECTMAPPER.readerFor(clazz).readValue(jsonNode);
	}

	private Set<DefaultBrowserListener> getConcurrentSet() {
		return new CopyOnWriteArraySet<>();
	}

	/**
	 * �Ƴ�����ĳ��������
	 * @param mothod ��������Ӧ�ķ���
	 * @param listener Ҫ�Ƴ��ļ�����
	 */
	public void  removeListener(String mothod ,DefaultBrowserListener listener){
		Set<DefaultBrowserListener> defaultBrowserListeners = listenerMap.get(mothod);
		if (ValidateUtil.isNotEmpty(defaultBrowserListeners)) {
			defaultBrowserListeners.remove(listener);
		}
	}

}
