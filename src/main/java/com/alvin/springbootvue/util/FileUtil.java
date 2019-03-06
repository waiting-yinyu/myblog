package com.alvin.springbootvue.util;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年3月4日
*/
public class FileUtil {
	
	/**
	 * 将文件路径规则化，去掉其中多余的/和\，去掉可能造成文件信息泄漏的../
	 */
	public static String normalizePath(String path) {
		path = path.replace('\\', '/');
		path = replacePath(path, "../", "/");
		path = replacePath(path, "./", "/");
		if (path.endsWith("..")) {
			path = path.substring(0, path.length() - 2);
		}
		path = path.replaceAll("/+", "/");
		return path;
	}
	
	/**
	 * 重复替换文件路径
	 * 
	 * @param path
	 * @param subStr
	 * @param reStr
	 * @return
	 */
	public static String replacePath(String path, String subStr, String reStr) {
		if (path.indexOf(subStr) == -1) {
			return path;
		}
		path = StringUtil.replaceEx(path, subStr, reStr);
		return replacePath(path, subStr, reStr);
	}
}
