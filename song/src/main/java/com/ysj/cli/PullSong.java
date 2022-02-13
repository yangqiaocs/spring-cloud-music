package com.ysj.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@Service
public class PullSong {
	@Autowired
	private CrawlerConfig crawlerConfig;

	public void Search(String keyword) throws IOException {

		String cmd = "python %s --keyword %s --host %s --user %s --password %s --database %s --table %s";
		cmd = String.format(cmd,crawlerConfig.getCrawlerPath(),keyword, crawlerConfig.getHost(),crawlerConfig.getUser(),crawlerConfig.getPassword(),crawlerConfig.getDatabase(),crawlerConfig.getTable());

		log.info(cmd);
		Runtime.getRuntime().exec(cmd);
	}
}
