package com.ysj.Controller;


import com.ysj.entity.Song;
import com.ysj.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("//song")
@CrossOrigin
public class SongController {

    @Autowired
    private SongService songService;

//    @LoadBalanced
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
    @PostMapping("/getsong")
    public Song getSong(@RequestParam String songId){
        return songService.getById(songId);

    }


    /*
    得到所有歌曲信息
     */
    @RequestMapping("/getsongs")
    public List<Song> getSongs(){
        System.out.println("getsongs");
        return songService.list().subList(0,20) ;
    }
}

