package com.example.sixdemo.slice.bottom;

import com.bumptech.glide.Glide;
import com.example.sixdemo.slice.news.NewsBean;
import com.example.sixdemo.ResourceTable;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.zson.ZSONObject;

//Fraction 和 android 中的fragment一样
// 屏幕中一部分区域的展示内容
public class XiaoWanzi extends Fraction
{
    //鸿蒙的日志  tag是自定义的搜索关键字 可以自己设置
    private HiLogLabel hiLogLabel = new HiLogLabel(0, 0, "MainAbilitySlice日志");

    private Component component;
    //重写这个方法
    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent)
    {
        //绑定布局页面
        component = scatter.parse(ResourceTable.Layout_news_page, container, false);
        return component;
    }

    @Override
    protected void onStart(Intent intent)
    {
        super.onStart(intent);
        getData();
    }

    //定义一个方法  将解析的结果和列表进行绑定，这个方法在获取网络数据进行调用
    public void bindData(NewsBean newsBean)
    {
        getUITaskDispatcher().asyncDispatch(new Runnable()
        {
            @Override
            public void run()
            {
                ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_newslist);

                //创建工具的对象 listProvider    注意是两个入参
                ListProvider listProvider = new ListProvider(newsBean, getContext());

                //将工具和对象绑定在一起
                listContainer.setItemProvider(listProvider);

                //设置容器列表的点击事件
                listContainer.setItemClickedListener(new ListContainer.ItemClickedListener()
                {
                    @Override
                    public void onItemClicked(ListContainer listContainer, Component component, int i, long l)
                    {
                        //i
                        Intent intent = new Intent();
                        intent.setParam("url", newsBean.getData().get(i).getUrl());
//                present(new NewsDetailSlice(), intent);
                    }
                });
            }
        });

    }

    //获取网络数据
    public void getData()
    {
        //alt + enter 报错的话插入引入的库
        HttpRequest.build(this, "http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html")
                .setResponseListener(new ResponseListener()
                {
                    @Override
                    public void onResponse(String response, Exception error)
                    {
                        if (error == null)
                        {
                            HiLog.info(hiLogLabel, response);
                            //解析接口返回的json数据  鸿蒙里面是通过ZSONObject
                            NewsBean newsBean = ZSONObject.stringToClass(response, NewsBean.class);
                            //数据解析成功 后 将数据放到工具中
                            bindData(newsBean);
                            HiLog.info(hiLogLabel, newsBean.getData().get(0).getTitle());
                        }
                        else
                        {
                            HiLog.info(hiLogLabel, "网络请求失败" + error);
                        }
                    }
                })
                .doGet();
    }

    /****************************************************************
     * 函数名称：
     * 创建日期：2022-09-18 14:17:34
     * 作者：xujunze
     * 输入参数：无
     * 输出参数：无
     * 返回值：无
     * 功能：将数据显示到列表上
     ******************************************************************/
    //ListProvider
    public static class ListProvider extends BaseItemProvider
    {
        //定义一个变量，用于显示数据
        private NewsBean newsBean;

        //定义一个变量
        private Context mContext;

        //重写方法 两个参数
        public ListProvider(NewsBean newsBean, Context mContext)
        {
            this.newsBean = newsBean;
            this.mContext = mContext;
        }

        @Override
        public int getCount()
        {
            //列表长度  及数据源的长度
            return newsBean.getData().size();
        }

        @Override
        public Object getItem(int i)
        {
            return newsBean.getData().get(i);
        }

        //给每一项加一个id
        @Override
        public long getItemId(int i)
        {
            return i;
        }

        //控件
        //返回每一项的布局
        @Override
        public Component getComponent(int i, Component component, ComponentContainer componentContainer)
        {
            //找到每一项的布局
            //parse 解析  布局文件
            component = LayoutScatter.getInstance(mContext).parse(ResourceTable.Layout_news_list, null, false);

            //绑定数据到具体的项上
            Text title = (Text) component.findComponentById(ResourceTable.Id_title);
            Text desTxt = (Text) component.findComponentById(ResourceTable.Id_desTxt);
            Image image = (Image) component.findComponentById(ResourceTable.Id_image);
            Text newsTime = (Text) component.findComponentById(ResourceTable.Id_newsTime);

            //设置值
            title.setText(newsBean.getData().get(i).getTitle());
            desTxt.setText(newsBean.getData().get(i).getDigest());
            newsTime.setText(newsBean.getData().get(i).getMtime());
            //image.setImageElement(newsBean.getData().get(i).getImgsrc());
            Glide.with(mContext).load(newsBean.getData().get(i).getImgsrc()).into(image);

            return component;
        }
    }
}
