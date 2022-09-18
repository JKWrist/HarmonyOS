package com.example.network_app1.http;

import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.lang.reflect.Parameter;

public class HttpReq
{
    private HiLogLabel logLabel = new HiLogLabel(0, 0, "HttpReq");
    private String news_json;

    public String getNews_json()
    {
        return news_json;
    }

    public void setNews_json(String news_json)
    {
        this.news_json = news_json;
    }

    public HttpReq(Context context, String s)
    {
        HttpRequest.build(context, s)
                .addHeaders("Charset", "UTF-8")
                .addParameter("page", "1")
                .addParameter("token", "A128")
                .setResponseListener(new ResponseListener()
                {
                    @Override
                    public void onResponse(String response, Exception error)
                    {

                        if (error == null)
                        {
                            HiLog.info(logLabel, response);
                            news_json = response;
                        } else
                        {
                            //请求出错
                            HiLog.info(logLabel, "请求失败");
                        }
                    }
                })
                .doGet();
    }
}
