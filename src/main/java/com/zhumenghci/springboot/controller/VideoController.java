package com.zhumenghci.springboot.controller;

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

    @GetMapping("list")
    public JsonData list(){

        List<Video> list = vidoService.listVideo();

        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());

        return JsonData.buildSuccess("");

    }
}
