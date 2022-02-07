package com.ysj.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.ListSong;
import com.ysj.service.ListSongService;
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
@RequestMapping("/song/listSong")
public class ListSongController {

	@Autowired
	private ListSongService listSongService;

	@GetMapping
	public Page<ListSong> list(){
		return listSongService.list();
	}

	@PostMapping
	public void add(@RequestBody ListSong listSong){
		listSongService.add(listSong);
	}

	@DeleteMapping
	public void delete(@RequestBody ListSong listSong){
		listSongService.delete(listSong);
	}
}

