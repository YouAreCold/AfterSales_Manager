package com.afterSalesService.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.afterSalesService.common.constants.Constants;
import com.afterSalesService.common.support.CacheManager;
import com.afterSalesService.common.support.RedisHelper;

@Configuration
public class CacheUtil {

	private static final Logger logger = LoggerFactory.getLogger(CacheUtil.class);

	private static CacheManager cacheManager;

	@Bean
	public CacheManager setCache() {
		cacheManager = getCache();
		return cacheManager;
	}

	public static CacheManager getCache() {
		if (cacheManager == null) {
			synchronized (CacheUtil.class) {
				if (cacheManager == null) {
					cacheManager = new RedisHelper();
				}
			}
		}
		return cacheManager;
	}

	/** 获取锁 */
	public static boolean getLock(String key) {
		try {
			if (!getCache().exists(key)) {
				synchronized (CacheUtil.class) {
					if (!getCache().exists(key)) {
						if (getCache().setnx(key, String.valueOf(System.currentTimeMillis()))) {
							return true;
						}
					}
				}
			}
			int expires = 1000 * 60 * 3;
			String currentValue = (String) getCache().get(key);
			if (currentValue != null && Long.parseLong(currentValue) < System.currentTimeMillis() - expires) {
				unlock(key);
				return getLock(key);
			}
			return false;
		} catch (Exception e) {
			logger.error("{} 获取锁发生异常",Constants.Exception_Head, e);
			return false;
		}
	}

	public static void unlock(String key) {
		getCache().del(key);
	}
}
