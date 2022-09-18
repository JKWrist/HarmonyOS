package com.example.sixdemo.slice.news;

import com.bumptech.glide.Glide;
import com.example.sixdemo.ResourceTable;
import ohos.agp.components.*;
import ohos.app.Context;


// 这个 ListProvider 工具的功能 就是将数据显示到列表上，继承系统工具类
public class ListProvider  extends BaseItemProvider {

    //定义一个变量，用于显示数据
    private NewsBean newsBean;

// 定义一个变量
    private Context mContext;

    //重写方法  一个参数
    public ListProvider(Context mContext)  {

        this.mContext =mContext;
    }

    //重写方法 两个参数
    public ListProvider(NewsBean newsBean, Context mContext) {
        this.newsBean = newsBean;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {

       // return 100;
        //  列表长度  及数据源的长度
        return newsBean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return newsBean.getData().get(i);
    }
// 给每一项加一个id
    @Override
    public long getItemId(int i) {
        return i;
    }
// 控件
    // 返回每一项的布局
    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {

       //找到每一项的布局
        //parse 解析  布局文件
        component  = LayoutScatter.getInstance(mContext).parse(ResourceTable.Layout_news_list,null,false);

        //绑定数据到具体的项上
        Text  title =(Text) component.findComponentById(ResourceTable.Id_title);
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
