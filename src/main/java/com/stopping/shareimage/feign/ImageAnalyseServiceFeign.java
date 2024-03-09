package com.stopping.shareimage.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 图片分析服务
 *
 * @author stopping
 * @date 2024/3/9 4:16 PM
 */
@FeignClient(name = "image-analyse-service",url = "http://localhost:8000")
public interface ImageAnalyseServiceFeign {

    /**
     * 调试测试
     * @return hello
     */
    @GetMapping
    String helloWorld();

    @PostMapping(value = "/image",consumes = "multipart/form-data")
    List<String> analyse(@RequestParam("image") MultipartFile image);
}
