package com.example.sixdemo.slice.news;

import com.example.sixdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;
import ohos.agp.components.webengine.WebView;

import java.util.ResourceBundle;

public class NewsDetailSlice extends AbilitySlice
{
    @Override
    protected void onStart(Intent intent)
    {
        super.onStart(intent);

        //将载体和布局绑定
        setUIContent(ResourceTable.Layout_news_detail);

        //接受上一个页面传来的数据
        String url = intent.getStringParam("url");

        //将内容显示在文本上
        Text text = (Text) findComponentById(ResourceTable.Id_text);
        text.setText(url);
//       WebView webView = new WebView(this);
//       WebView webView = (WebView) findComponentById(ResourceTable.Id_webView);
//       webView.load(url);

    }
}
