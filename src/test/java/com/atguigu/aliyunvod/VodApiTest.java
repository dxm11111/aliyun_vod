package com.atguigu.aliyunvod;


import com.atguigu.aliyunvod.utils.AliyunVodAPIUtils;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;


public class VodApiTest {
    //获取视频播放凭证
    @Test
    public void testGetVideoPlayAuth() throws Exception {

        //1.组装私有参数
        // 接口私有参数列表, 不同API请替换相应参数
        Map<String, String> privateParams = new HashMap<>();
        // 视频ID
        privateParams.put("VideoId","625d89dc4ae744d69b805c1416556947");
        // API名称
        privateParams.put("Action", "GetVideoPlayAuth");

        //2.组装共有参数
        Map<String, String> publicParams = AliyunVodAPIUtils.generatePublicParamters();

        //3.生成最终的API url调用地址（包含签名字符串）
        String url = AliyunVodAPIUtils.generateOpenAPIURL(publicParams, privateParams);

        System.out.println("url = " + url);
        //4.发送HTTP GET请求
        AliyunVodAPIUtils.httpGet(url);
    }


    //获取视频播放地址

    //加密视频
    //默认情况下加密视频的地址不会被返回
    //如果想要获取加密视频的地址必须设置ResultType=Multiple， 返回m3u8文件
    //非加密视频
    //不加密视频不用设置ResultType=Multiple,拿到视频id就可以
    //如果视频没有被转码，那么会返回视频源文件的地址
    //如果视频被转码，那么会返回转码后的文件地址
    @Test
    public void testGetPlayInfo() throws Exception {

        //1.组装私有参数
        // 接口私有参数列表, 不同API请替换相应参数
        Map<String, String> privateParams = new HashMap<>();
        // 视频ID
        privateParams.put("VideoId","625d89dc4ae744d69b805c1416556947");
        //设置ResultType
        privateParams.put("ResultType","Multiple");//可选参数，可以返回加密视频流
        // API名称
        privateParams.put("Action", "GetPlayInfo");

        //2.组装共有参数
        Map<String, String> publicParams = AliyunVodAPIUtils.generatePublicParamters();

        //3.生成最终的API url调用地址（包含签名字符串）
        String url = AliyunVodAPIUtils.generateOpenAPIURL(publicParams, privateParams);

        System.out.println("url = " + url);
        //4.发送HTTP GET请求
        AliyunVodAPIUtils.httpGet(url);
    }
}
