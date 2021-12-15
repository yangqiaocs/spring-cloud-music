package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author ysj
 * @since 2021-11-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class User implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "user_id", type = IdType.AUTO)
      private Integer userId;

    private String userPhone;

    private String userPassword;

    private String userNickname;

    private String userPhoto;


}
