package com.zhumenghci.springboot.service.impl;

import com.zhumenghci.springboot.domain.Video;
import com.zhumenghci.springboot.mapper.VidoMapper;
import com.zhumenghci.springboot.service.VidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VidoServiceimpl implements VidoService {

    @Autowired
    private VidoMapper vidoMapper;


    public List<Video> listVideo() {
        return vidoMapper.listVideo();
    }
}