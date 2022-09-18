package com.example.sixdemo.slice.news;

public class NewsDetail
{
    //定义
    public String source;
    public String title;
    public String digest;
    public String imgsrc;
    public String mtime;
    public String url;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    //方法
    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDigest()
    {
        return digest;
    }

    public void setDigest(String digest)
    {
        this.digest = digest;
    }

    public String getImgsrc()
    {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc)
    {
        this.imgsrc = imgsrc;
    }

    public String getMtime()
    {
        return mtime;
    }

    public void setMtime(String mtime)
    {
        this.mtime = mtime;
    }
}
