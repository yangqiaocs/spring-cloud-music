package com.ysj.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.YamlUtil;
import com.ysj.entity.Song;
import com.ysj.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private YamlUtil yamlUtil;

    @GetMapping("/list")
    public Page<Song> List(@RequestParam Integer page, @RequestParam Integer pageSize){
        return songService.list(page,pageSize);
    }

    /*
     *根据某首歌的id得到此首歌曲的信息
     */
    @PostMapping("/{songId}")
    public Song getSong(@PathVariable String songId){
        return songService.getById(songId);
    }

    @GetMapping("/search/{keyword}")
    public List<Song> searchSong(@PathVariable String keyword){
        return songService.findByKeyword(keyword);
    }

//    @PostMapping("/search")
//    public List<Song> searchSong(@RequestBody String keyword){
////        elasticsearchTemplate.createIndex(Song.class);
////        elasticsearchTemplate.putMapping(Song.class);
//        return songService.list().subList(0,20);
//    }

    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file) throws IOException {
        UUID uuid = UUID.randomUUID();
        String fatherDir = yamlUtil.getUploadMusicLocation();
        Path path = Paths.get(fatherDir+uuid);
        Files.createDirectories(path);
        String filepath = fatherDir+uuid+"/music.mp3";
        Files.write(Paths.get(filepath),file.getBytes());
    }
}

