package com.ruiyun.jvppeteer.options;

public class DefaultViewport {
	
	/**
	 * ҳ��������
	 * <br/>
     * page width in pixels.
     */
    private Double width = 800.00;
    /**
     * ҳ��߶�����
     * <br/>
     * page height in pixels.
     */
    private Double height = 600.00;
    /**
     * �����豸�����ţ�������Ϊ�� dpr����Ĭ���� 1
     * <br/>
     * Specify device scale factor (can be thought of as dpr).
     * @default 1
     */
    private Double deviceScaleFactor = 1.00;
    /**
     * �Ƿ���ҳ���������� meta viewport ��ǩ��Ĭ���� false
     * Whether the meta viewport tag is taken into account.
     * @default false
     */
    private boolean isMobile;
    /**
     * ָ��viewport�Ƿ�֧�ִ����¼���Ĭ���� false��
     * <br/>
     * Specifies if viewport supports touch events.
     * @default false
     */
    private boolean hasTouch ;
    /**
     * ָ���ӿ��Ƿ��ں���ģʽ��Ĭ���� false��
     * <br/>
     * Specifies if viewport is in landscape mode.
     * @default false
     */
    private boolean isLandscape;
    
	public Double getWidth() {
		return width;
	}
	
	public void setWidth(Double width) {
		this.width = width;
	}
	
	public Double getHeight() {
		return height;
	}
	
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getDeviceScaleFactor() {
		return deviceScaleFactor;
	}
	
	public void setDeviceScaleFactor(Double deviceScaleFactor) {
		this.deviceScaleFactor = deviceScaleFactor;
	}
	
	public boolean isMobile() {
		return isMobile;
	}
	
	public void setMobile(boolean isMobile) {
		this.isMobile = isMobile;
	}
	
	public boolean isHasTouch() {
		return hasTouch;
	}
	
	public void setHasTouch(boolean hasTouch) {
		this.hasTouch = hasTouch;
	}
	
	public boolean isLandscape() {
		return isLandscape;
	}
	
	public void setLandscape(boolean isLandscape) {
		this.isLandscape = isLandscape;
	}

    
}
