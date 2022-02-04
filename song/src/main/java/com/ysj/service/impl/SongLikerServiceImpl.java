package com.ysj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ysj.cache.RedisOperation;
import com.ysj.entity.SongLiker;
import com.ysj.mapper.SongLikerMapper;
import com.ysj.mapper.SongMapper;
import com.ysj.service.SongLikerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌曲与点了喜欢的用户 服务实现类
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
@Service
public class SongLikerServiceImpl extends ServiceImpl<SongLikerMapper, SongLiker> implements SongLikerService {

	@Autowired
	private SongLikerMapper songLikerMapper;

	@Autowired
	private RedisOperation cache;

	@Override
	public boolean add(Integer userId, String songId) {
		SongLiker songLiker = new SongLiker();
		songLiker.setSongid(songId);
		songLiker.setUserid(userId);
		QueryWrapper<SongLiker> queryWrapper = new QueryWrapper<>(songLiker);
		if(songLikerMapper.selectCount(queryWrapper).equals(0)){
			if (songLikerMapper.insert(songLiker) > 0){
				cache.addSongLike(songId,userId);
				return true;
			}
			return false;
		}
		return true;
	}

	@Override
	public List<String> getUserLikeSongs(Integer userId) {
		return cache.userLike(userId);
	}

	@Override
	public List<Integer> getLikeSongUsers(String songId) {
		return cache.songLiker(songId);
	}

	@Override
	public boolean delete(Integer userId, String songId) {
		SongLiker songLiker = new SongLiker();
		songLiker.setSongid(songId);
		songLiker.setUserid(userId);
		QueryWrapper<SongLiker> queryWrapper = new QueryWrapper<>(songLiker);
		if(songLikerMapper.delete(queryWrapper) > 0){
			cache.updateUserLikeSongs(userId,songId);
			return true;
		}
		return false;
	}

	@Override
	public void removeCache(String key) {

	}

	@Override
	public void init() {
		List<SongLiker> songLikerList = songLikerMapper.selectList(null);
		songLikerList.forEach(element->{
			cache.removeLikeSongUsers(element.getSongid());
			cache.removeUserLikeSongs(element.getUserid());
		});
		for(SongLiker songLiker:songLikerList){
			cache.addSongLike(songLiker
					.getSongid(),songLiker.getUserid());
		}
	}



}
