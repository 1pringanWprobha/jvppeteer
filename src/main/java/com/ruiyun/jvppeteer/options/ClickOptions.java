package com.ruiyun.jvppeteer.options;

/**
 * ��${@link com.ruiyun.jvppeteer.protocol.page.frame.Frame#click(String, ClickOptions)}
 */
public class ClickOptions {

    private int delay;

    /**
     * "left"|"right"|"middle" ������ѡ��
     */
    private String button;

    private int clickCount;

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }
}
