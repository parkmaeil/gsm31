package kr.gsm.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 또는 "/gsm/**"
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*");
    }
}