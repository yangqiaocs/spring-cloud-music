package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.ListSong;
import com.ysj.mapper.ListSongMapper;
import com.ysj.service.ListSongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ysj
 * @since 2022-02-07
 */
@Service
public class ListSongServiceImpl implements ListSongService {

	@Autowired
	private ListSongMapper listSongMapper;

	@Override
	public void add(ListSong listSong) {
		listSongMapper.insert(listSong);
	}

	@Override
	public Page<ListSong> list() {
		Page<ListSong> page = new Page<>(1,10);
		return listSongMapper.selectPage(page,null);
	}

	@Override
	public void delete(ListSong listSong) {
		listSongMapper.deleteById(listSong.getId());
	}

}
