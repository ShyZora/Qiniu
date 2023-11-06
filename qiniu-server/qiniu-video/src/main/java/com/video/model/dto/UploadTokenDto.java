package com.video.model.dto;

/**
 * @program: Qiniu
 * @description:
 * @author: ShyZOra
 * @create: 2023-11-06 16:14
 **/

public class UploadTokenDto {
    private String token;
    private String baseUrl;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UploadTokenDto() {
    }

    public UploadTokenDto(String token, String baseUrl) {
        this.token = token;
        this.baseUrl = baseUrl;
    }
}
