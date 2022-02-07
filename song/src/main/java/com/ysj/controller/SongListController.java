package com.ysj.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.ListSong;
import com.ysj.entity.SongList;
import com.ysj.service.ListSongService;
import com.ysj.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ysj
 * @since 2022-02-07
 */
@RestController
@RequestMapping("/song/songList")
public class SongListController {

	@Autowired
	private SongListService songListService;

	@GetMapping
	public Page<SongList> list(){
		return songListService.list();
	}

	@PostMapping
	public void add(@RequestBody SongList songList){
		songListService.add(songList);
	}

	@DeleteMapping
	public void delete(@RequestBody SongList songList){
		songListService.delete(songList);
	}
}

