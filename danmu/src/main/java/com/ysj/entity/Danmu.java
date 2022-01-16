package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ysj
 * @since 2021-12-07
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Danmu implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "danmu_id", type = IdType.AUTO)
      private Integer danmuId;

    private Integer musicId;

    private String content;

    private Integer userId;


}
