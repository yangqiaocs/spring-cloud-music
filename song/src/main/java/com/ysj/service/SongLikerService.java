package com.ysj.service;

import com.ysj.entity.SongLiker;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 歌曲与点了喜欢的用户 服务类
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
public interface SongLikerService extends IService<SongLiker> {

	boolean add(Integer userId, String songId);

	List<String> getUserLikeSongs(Integer userId);

	void removeCache(String key);

	void init();

	List<Integer> getLikeSongUsers(String songId);

	boolean delete(Integer userId, String songId);
}
