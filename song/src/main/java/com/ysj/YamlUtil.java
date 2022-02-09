package com.ysj;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Getter
public class YamlUtil {
	@Value("${music.upload.location}")
	private String uploadMusicLocation;
}
