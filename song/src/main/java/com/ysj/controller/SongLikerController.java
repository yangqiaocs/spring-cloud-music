package com.ysj.controller;


import com.ysj.service.SongLikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>
 * 歌曲与点了喜欢的用户 前端控制器
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
@RestController
@RequestMapping("/song/songLiker")
//@CrossOrigin
public class SongLikerController {

	@Autowired
	private SongLikerService songLikerService;

	@PostMapping("/")
	public boolean like(@RequestParam Integer userId,@RequestParam String songId){
		songLikerService.add(userId,songId);
		return true;
	}

	@GetMapping("/index")
	public String index(){
		return "index";
	}

	@GetMapping("/likeSongs/{userId}")
	public List<String> allLikeSongs(@PathVariable Integer userId){
		return songLikerService.getUserLikeSongs(userId);
	}

	@GetMapping("/liker/{songId}")
	public List<Integer> allSongLiker(@PathVariable String songId){
		return songLikerService.getLikeSongUsers(songId);
	}

	@DeleteMapping("/")
	public boolean notLike(@RequestParam Integer userId,@RequestParam String songId){
		return songLikerService.delete(userId,songId);
	}

	@PostConstruct
	public void init(){
		songLikerService.init();
	}
}

