package com.zhumenghci.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhumenghci.springboot.domain.Video;
import com.zhumenghci.springboot.service.VidoService;
import com.zhumenghci.springboot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VidoService vidoService;

    /**
     *
     * @return
     */
    @GetMapping("list")
    public JsonData list() throws JsonProcessingException {

        List<Video> list = vidoService.listVideo();

        ObjectMapper objectMapper = new ObjectMapper();

        String jsStr = objectMapper.writeValueAsString(list);
        System.out.println(jsStr);

        List<Video> temp = objectMapper.readValue(jsStr,List.class);

        return JsonData.buildSuccess(temp);
    }

    /**
     *
     * @param video
     * @return
     */
    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());

        return JsonData.buildSuccess("");

    }
}
