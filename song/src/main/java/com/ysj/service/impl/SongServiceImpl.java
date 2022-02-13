package com.ysj.service.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysj.cli.PullSong;
import com.ysj.entity.Song;
import com.ysj.mapper.SongMapper;
import com.ysj.service.SongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
	@Autowired
	private PullSong pullSong;


	@Override
	public List<Song> findByKeyword(String keyword){
		List<Song> res = songMapper.findByKeyword(keyword);
		if(res.size() == 0){
			new Thread(()->{
				try {
					pullSong.Search(keyword);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
		return res;
	}

	@Override
	public Page<Song> list(Integer pageNum, Integer pageSize) {
		Page<Song> page = new Page<>(pageNum,pageSize);
		return songMapper.selectPage(page,null);
	}

	@Override
	public Song getById(String songId) {
		return songMapper.selectById(songId);
	}
}
