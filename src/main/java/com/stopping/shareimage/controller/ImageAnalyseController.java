package com.stopping.shareimage.controller;

import com.stopping.shareimage.common.pojo.Result;
import com.stopping.shareimage.feign.ImageAnalyseServiceFeign;
import com.stopping.shareimage.pojo.ExifInfoDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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
        Result<Map<String,String>> analyse = imageAnalyseServiceFeign.analyse(file);
        log.info("result = {}",analyse);
    }


}
