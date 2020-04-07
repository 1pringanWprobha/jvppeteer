package com.ruiyun.jvppeteer.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * �����ļ���һЩ���淽��
 */
public class FileUtil {

	/**
	 * ���ݸ�����ǰ׺������ʱ�ļ���
	 * @param prefix
	 * @return
	 */
	public static String createProfileDir(String prefix){
		try {
			return Files.createTempDirectory(prefix).toRealPath().toString();
		} catch (Exception e) {
			throw new RuntimeException("create temp profile dir fail:",e);
		}
		
	}

	/**
	 * ����·���Ƿ��ǿ�ִ�е�exe�ļ�
	 * @param executablePath
	 * @return
	 */
	public static boolean assertExecutable(String executablePath){
		Path path = Paths.get(executablePath);
		return Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path);
	}

	/**
	 * �Ƴ��ļ�
	 * @param path
	 * @throws IOException
	 */
	public static void removeFolder(String path) throws IOException{
		Files.deleteIfExists(Paths.get(path));
	}

	/**
	 * ����һ���ļ���������ļ��ϵ���Щ�ļ���·�������ڣ����Զ������ļ��С�
	 * @param file
	 * @throws IOException
	 */
	public static final void createNewFile(File file) throws IOException {
		if(!file.exists()){
			mkdir(file.getParentFile());
			file.createNewFile();
		}
	}

	/**
	 * �ݹ鴴���ļ���
	 * @param parent
	 */
	public static final void mkdir(File parent){
		if(!parent.exists()){
			mkdir(parent.getParentFile());
			parent.mkdir();
		}
	}
}
