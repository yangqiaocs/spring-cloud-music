package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ysj
 * @since 2021-11-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("Song")
public class Song implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("SongID")
      private String SongID;

    @TableField("SongName")
    private String SongName;

    @TableField("Singer")
    private String Singer;

    @TableField("Intro")
    private String Intro;

    @TableField("Lyrics")
    private String Lyrics;

    @TableField("Picture")
    private String Picture;

    @TableField("Music")
    private String Music;

    @TableField("SongCommentIDSet")
    private String SongCommentIDSet;

    @TableField("UploadTime")
    private LocalDateTime UploadTime;


}
