package com.tohidur.bookService.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * The error message indicates that the browser is unable to fetch the resource at http://localhost:8080/api/books?pageNo=0 pageSize=9 because the server does not have the Access-Control-Allow-Origin header set. This header is required for cross-origin resource sharing (CORS), which is a security mechanism that prevents websites from accessing resources from other domains without permission.
     * To fix this error, you need to add the Access-Control-Allow-Origin header to the server response. The value of this header should be the origin of the website that is trying to access the resource. In this case, the origin is http://localhost:3000.
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
