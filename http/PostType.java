package com.moblor.http;

import okhttp3.MediaType;
/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public class PostType {
    public static MediaType TYPE_STRING = MediaType.parse("text/plain;charset=utf-8");
    public static MediaType TYPE_JSON=MediaType.parse("application/json; charset=utf-8");
}
