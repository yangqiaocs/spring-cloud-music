package com.ysj.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ysj
 * @since 2022-02-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

      private String songId;

    private String songName;

    private String songSinger;

    private String songIntroduction;

    private String musicLyrics;

    private String musicPicture;

    private String musicMusic;

    private LocalDateTime uploadTime;


}
