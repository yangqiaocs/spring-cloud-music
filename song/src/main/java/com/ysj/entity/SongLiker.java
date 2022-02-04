package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 歌曲与点了喜欢的用户
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SongLiker implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String songid;

    private Integer userid;

    private LocalDateTime updateTime;


}
