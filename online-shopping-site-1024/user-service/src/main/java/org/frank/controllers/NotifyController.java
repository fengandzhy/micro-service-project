package org.frank.controllers;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Api(tags = "notification module")
@Slf4j
@RestController
@RequestMapping("/api/user/v1")
public class NotifyController {
    
    private Producer producer;
    
    /**
     * 获取图形验证码
     * */
    @ApiOperation("create captcha")
    @RequestMapping("captcha")
    public void getCaptcha(@NonNull HttpServletRequest request, 
                           @NonNull HttpServletResponse response){
        String captcha = producer.createText();
        log.info("captcha is {}",captcha);
        BufferedImage bufferedImage = producer.createImage(captcha);
        ServletOutputStream outputStream;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("create captcha error:{}",e.getMessage());
        }
    }

    @Autowired
    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
