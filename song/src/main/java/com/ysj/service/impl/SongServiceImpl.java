package com.ysj.service.impl;

import com.ysj.entity.Song;
import com.ysj.mapper.SongMapper;
import com.ysj.service.SongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {

	@Autowired
	private SongMapper songMapper;

	@Override
	public List<Song> findByKeyword(String keyword) {
		return songMapper.findByKeyword(keyword);
	}
}
