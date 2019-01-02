package com.afterSalesService.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.afterSalesService.common.utils.DateUtil;

@Component
public class TestTask {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*@Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    public void taskCycle() {
		logger.info("使用SpringMVC框架配置定时任务2 ["+DateUtil.getDateTime()+"]");
    }*/
}
