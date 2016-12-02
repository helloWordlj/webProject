package com.yxw.interfaces.service;

import com.alibaba.dubbo.container.logback.LogbackContainer;
import com.alibaba.dubbo.container.spring.SpringContainer;
import com.yxw.framework.config.SystemConfig;

/**
 * 启动程序
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年5月13日
 */

public class ProgramStartUp {
	public static void main(String[] args) {
		SystemConfig.loadSystemConfig();
		SpringContainer.SPRING_CONFIG_PATH = SystemConfig.getStringValue("spring_config_path");
		LogbackContainer.LOGBACK_FILE_PATH = SystemConfig.getStringValue("logback_config_path");
		com.alibaba.dubbo.container.Main.main(args);
	}
}
