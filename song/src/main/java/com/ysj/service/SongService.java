package com.ysj.service;

import com.ysj.entity.Song;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
public interface SongService extends IService<Song> {

	List<Song> findByKeyword(String keyword);
}
