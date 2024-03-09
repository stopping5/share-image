package com.stopping.shareimage.controller;

import com.stopping.shareimage.feign.ImageAnalyseServiceFeign;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 图片数据分析
 *
 * @author stopping
 * @date 2024/3/9 4:10 PM
 */
@RestController
@RequestMapping("/image/analyse")
@AllArgsConstructor
@Slf4j
public class ImageAnalyseController {

    private ImageAnalyseServiceFeign imageAnalyseServiceFeign;

    @GetMapping
    public void test(){
        String s = imageAnalyseServiceFeign.helloWorld();
        log.info(s);
    }

    @PostMapping
    public void analyse(@RequestParam("file") MultipartFile file){
        log.info(file.getName());
        List<String> analyse = imageAnalyseServiceFeign.analyse(file);
        log.info("result = {}",analyse);
    }


}
