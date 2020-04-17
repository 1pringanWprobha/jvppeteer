package com.ruiyun.jvppeteer.exception;

/**
 * �������µ�ҳ������ܳ������쳣
 */
public class NavigateException extends RuntimeException {

    public NavigateException() {
        super();
    }

    public NavigateException(String message) {
        super(message);
    }

    public NavigateException(String message, Throwable cause) {
        super(message, cause);
    }

    public NavigateException(Throwable cause) {
        super(cause);
    }

    protected NavigateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
