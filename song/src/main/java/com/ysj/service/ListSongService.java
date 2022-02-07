package com.ysj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.ListSong;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ysj
 * @since 2022-02-07
 */
public interface ListSongService{

	void add(ListSong listSong);
	Page<ListSong> list();
	void delete(ListSong listSong);
}
