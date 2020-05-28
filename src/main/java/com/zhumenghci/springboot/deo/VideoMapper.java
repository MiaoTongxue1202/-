package com.zhumenghci.springboot.deo;

import com.zhumenghci.springboot.domain.Video;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {

    /**
     * 根据视频id查找视频对象
     * @param videoId
     * @return
     */
    Video selectById(@Param("video_id") int videoId);

}
