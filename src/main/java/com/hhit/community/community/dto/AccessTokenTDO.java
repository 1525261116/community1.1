package com.hhit.community.community.dto;

import lombok.Data;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/8/25 15:11
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Data
public class AccessTokenTDO {
    private  String client_id;
    private  String client_secret;
    private  String code;
    private  String redirect_uri;
    private  String state;
}
