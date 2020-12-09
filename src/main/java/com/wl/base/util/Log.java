package com.wl.base.util;

import org.slf4j.LoggerFactory;

/**
 * 日志
 * @author wuli
 * @date 2020年5月12日上午11:59:45
 */
public class Log {

	public static void deubg(String msg, Throwable e) {
		LoggerFactory.getLogger(org.slf4j.helpers.Util.getCallingClass()).debug(msg, e);
	}

	public static void deubg(String msg) {
		LoggerFactory.getLogger(org.slf4j.helpers.Util.getCallingClass()).debug(msg);
	}

	public static void info(String msg, Throwable e) {
		LoggerFactory.getLogger(org.slf4j.helpers.Util.getCallingClass()).info(msg, e);
	}

	public static void info(String msg) {
		LoggerFactory.getLogger(org.slf4j.helpers.Util.getCallingClass()).info(msg);
	}

	public static void error(String msg) {
		LoggerFactory.getLogger(org.slf4j.helpers.Util.getCallingClass()).error(msg);
	}

	public static void error(String msg, Throwable e) {
		LoggerFactory.getLogger(org.slf4j.helpers.Util.getCallingClass()).error(msg, e);
	}
}
