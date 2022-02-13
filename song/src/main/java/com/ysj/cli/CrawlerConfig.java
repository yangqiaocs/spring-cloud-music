package com.ysj.cli;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CrawlerConfig {
	@Value("${music.mysql.host}")
	private String host;
	@Value("${music.mysql.database}")
	private String database;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.name}")
	private String table;
	@Value("${music.crawler}")
	private String crawlerPath;
}
