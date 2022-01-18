package com.ysj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "song",createIndex = true)
public class Song implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Field(type = FieldType.Keyword)
      @TableId("SongID")
      private String SongID;

    @Field(type = FieldType.Keyword)
    @TableField("SongName")
    private String SongName;

    @TableField("Singer")
    @Field(type = FieldType.Text)
    private String Singer;

    @TableField("Intro")
    @Field(type = FieldType.Text)
    private String Intro;

    @TableField("Lyrics")
    @Field(type = FieldType.Text)
    private String Lyrics;

    @TableField("Picture")
    @Field(type = FieldType.Text)
    private String Picture;

    @TableField("Music")
    @Field(type = FieldType.Text)
    private String Music;

    @TableField("SongCommentIDSet")
    @Field(type = FieldType.Text)
    private String SongCommentIDSet;

    @TableField("UploadTime")
    @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
    private LocalDateTime UploadTime;
}
