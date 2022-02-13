package com.ysj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.Song;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
public interface SongService{

	List<Song> findByKeyword(String keyword);
	Page<Song> list(Integer page, Integer pageSize);

	Song getById(String songId);
}
