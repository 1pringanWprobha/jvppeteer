package com.ruiyun.jvppeteer.options;

import java.util.List;

/**
 * ҳ��${@link com.ruiyun.jvppeteer.protocol.page.Page#go2}�õ�
 * ��ת������ҳ��ʱ��ѡ��Ĳ���
 */
public class PageOptions {

    /**
     * Referer header value. If provided it will take preference over the referer header value set by page.setExtraHTTPHeaders().
     */
    private String referer;

    /**
     * ��ת�ȴ�ʱ�䣬��λ�Ǻ���, Ĭ����30��, �� 0 ��ʾ���޵ȴ�������ͨ��
     */
    private int timeout;

    /**
     *  ����ʲô������Ϊҳ����ת��ɣ�Ĭ���� load �¼�����ʱ��ָ���¼����飬��ô�����¼����������Ϊ����ת��ɡ��¼�������
     * load - ҳ���load�¼�����ʱ
     * domcontentloaded - ҳ��� DOMContentLoaded �¼�����ʱ
     * networkidle0 - ��������������ʱ����������500�����
     * networkidle2 - ֻ��2����������ʱ����������500�����
     */
    private List<String> waitUntil;
}
