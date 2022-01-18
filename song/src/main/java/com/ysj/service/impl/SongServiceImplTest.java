package com.ysj.service.impl;

import com.ysj.SongApplication;
import com.ysj.entity.Song;
import com.ysj.service.SongService;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SongApplication.class)
public class SongServiceImplTest {

	@Autowired
	SongService songService;

	@Autowired
	ElasticsearchRestTemplate elasticsearchRestTemplate;

	@Test
	public void addIndex(){
		elasticsearchRestTemplate.indexOps(Song.class);
		elasticsearchRestTemplate.save(songService.list());
		Song song = elasticsearchRestTemplate.save(songService.list().get(0));
//		elasticsearchRestTemplate.save(songService.list());
//		elasticsearchRestTemplate.idsQuery(null);
	}

	@Test
	public void printSong(){
//		System.out.println(songService.list().subList(1, 3));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.matchQuery("SongName","爱")).build();

		SearchHits<Song> songSearchHit = elasticsearchRestTemplate.search(nativeSearchQuery, Song.class);
		songSearchHit.stream().forEach(songSearchHit1 -> {
			System.out.println(songSearchHit1.getContent().getSongName());
		});
	}


}