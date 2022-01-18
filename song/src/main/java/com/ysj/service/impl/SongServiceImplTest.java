package com.ysj.service.impl;

import com.ysj.SongApplication;
import com.ysj.entity.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SongApplication.class)
public class SongServiceImplTest {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	@Test
	public void addIndex(){
		boolean res = elasticsearchTemplate.createIndex(Song.class);
		System.out.println(res);
		elasticsearchTemplate.putMapping(Song.class);
	}


}