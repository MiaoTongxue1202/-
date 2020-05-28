package com.zhumenghci.springboot;

import com.zhumenghci.springboot.domain.Video;
import com.zhumenghci.springboot.service.VidoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={SpringbootApplication.class})//启动整个springboot工程
@AutoConfigureMockMvc
public class VideoTest {

    @Before
    public void testOne(){
        System.out.println("这个是测试 before");
    }

    @Autowired
    private  VidoService vidoService;

//    @Test
//    public void testTwo1(){
//        System.out.println("这个是测试 test1");

//        TestCase.assertEquals("1","2","3");
//    }
//
//    @Test
//    public void testTwo2(){
//        System.out.println("这个是测试 test2");
//    }

    @Test
    public void testVideoList(){

        List<Video> videoList = vidoService.listVideo();

        TestCase.assertTrue(videoList.size()>0);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListapi() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);

    }

    @After
    public void testThree(){
        System.out.println("这个是测试 after");
    }

}

