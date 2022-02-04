package com.ysj.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class RedisOperation {
	@Autowired
	private RedisTemplate redisTemplate;

	private static final String likeSongUsers = "likeSong%sUser";
	private static final String userLikeSongs = "user%dLikeSongs";


	public void addSongLike(String songId, Integer userId) {
		redisTemplate.opsForSet().add(getLikeSongUsers(songId),userId);
		redisTemplate.opsForSet().add(getUserLikeSongs(userId),songId);
	}

	public void deleteSongLike(String songId, Integer userId) {
		redisTemplate.opsForSet().remove(getLikeSongUsers(songId),userId);
		redisTemplate.opsForSet().remove(getUserLikeSongs(userId),songId);
	}

	public List<String> userLike(Integer userId) {
		Set set =  redisTemplate.opsForSet().members(getUserLikeSongs(userId));
		List<String> res = new ArrayList<>(set);
		return res;
	}

	public List<Integer> songLiker(String songId) {
		Set set =  redisTemplate.opsForSet().members(getLikeSongUsers(songId));
		List<Integer> res = new ArrayList<>(set);
		return res;
	}

	public String getUserLikeSongs(Integer userId){
		return String.format(userLikeSongs, userId);
	}
	public String getLikeSongUsers(String songId){
		return String.format(likeSongUsers, songId);
	}


	public void removeLikeSongUsers(String songId) {
		redisTemplate.delete(getLikeSongUsers(songId));
	}

	public void removeUserLikeSongs(Integer userId) {
		redisTemplate.delete(getUserLikeSongs(userId));
	}

	public void updateUserLikeSongs(Integer userId, String songId) {
		redisTemplate.opsForSet().remove(getLikeSongUsers(songId),userId);
		redisTemplate.opsForSet().remove(getUserLikeSongs(userId),songId);
	}
}
