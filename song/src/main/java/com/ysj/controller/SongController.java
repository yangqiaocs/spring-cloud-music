package com.ysj.controller;


import com.ysj.entity.Song;
import com.ysj.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ysj
 * @since 2021-11-29
 */
@RestController
@RequestMapping("/song")
//@CrossOrigin
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/list")
    public List<Song> List(){
        return songService.list();
    }

    @GetMapping("/nums")
    public int Nums(){
        return songService.list().size();
    }

    /*
     *根据某首歌的id得到此首歌曲的信息
     */
    @PostMapping("/{songId}")
    public Song getSong(@PathVariable String songId){
        return songService.getById(songId);
    }


    /*
    得到所有歌曲信息
     */
    @GetMapping("/getsongs")
    public List<Song> getSongs(){
        return songService.list().subList(0,20) ;
    }

    @PostMapping("/search")
    public List<Song> searchSong(@RequestParam String keyword){
        return songService.findByKeyword(keyword);
    }

//    @PostMapping("/search")
//    public List<Song> searchSong(@RequestBody String keyword){
////        elasticsearchTemplate.createIndex(Song.class);
////        elasticsearchTemplate.putMapping(Song.class);
//        return songService.list().subList(0,20);
//    }



}

