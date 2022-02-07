package com.ysj.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.entity.ListSong;
import com.ysj.entity.SongList;
import com.ysj.mapper.SongListMapper;
import com.ysj.service.SongListService;
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
public class SongListServiceImpl implements SongListService {

	@Autowired
	private SongListMapper songListMapper;

	@Override
	public void add(SongList songList) {
		songListMapper.insert(songList);
	}

	@Override
	public void delete(SongList songList) {
		songListMapper.deleteById(songList.getId());
	}

	@Override
	public Page<SongList> list() {
		Page<SongList> page = new Page<>(1,10);
		return songListMapper.selectPage(page,null);
	}
}
