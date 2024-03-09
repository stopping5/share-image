package com.stopping.shareimage.feign;

import com.stopping.shareimage.common.pojo.Result;
import com.stopping.shareimage.pojo.ExifInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<Map<String,String>> analyse(@RequestPart("file") MultipartFile file);
}
