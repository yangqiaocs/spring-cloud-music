package com.ysj.mapper;

import com.ysj.entity.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
public interface SongMapper extends BaseMapper<Song> {

	List<Song> findByKeyword(@Param("keyword") String keyword);
}
