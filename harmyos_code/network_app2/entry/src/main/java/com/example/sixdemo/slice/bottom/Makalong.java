package com.example.sixdemo.slice.bottom;

import com.example.sixdemo.ResourceTable;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;

//Fraction 和 android 中的fragment一样
// 屏幕中一部分区域的展示内容
public class Makalong extends Fraction
{
    //重写这个方法
    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent)
    {
        //绑定布局页面
        Component component = scatter.parse(ResourceTable.Layout_ma_ka_long, container, false);
        return component;
    }
}
