package com.ysj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.SongList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ysj
 * @since 2022-02-07
 */
public interface SongListService{

	void add(SongList songList);

	void delete(SongList songList);

	Page<SongList> list();
}
