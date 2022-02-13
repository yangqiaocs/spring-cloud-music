package com.ysj.cli;

import com.ysj.SongApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PullSongTest {
	@Autowired
	private PullSong pullSong;

	@Test
	public void TestSearch() throws IOException, InterruptedException {
		pullSong.Search("天下第一");
		Thread.sleep(100000);
	}

}