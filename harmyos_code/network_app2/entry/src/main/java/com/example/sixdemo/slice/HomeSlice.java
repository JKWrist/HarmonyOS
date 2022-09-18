package com.example.sixdemo.slice;

import com.example.sixdemo.ResourceTable;
import com.example.sixdemo.slice.bottom.Makalong;
import com.example.sixdemo.slice.bottom.ShengJian;
import com.example.sixdemo.slice.bottom.XiaoWanzi;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;

public class HomeSlice extends AbilitySlice
{
    @Override
    protected void onStart(Intent intent)
    {
        super.onStart(intent);

        //将载体和布局绑定
        setUIContent(ResourceTable.Layout_ability_home);
        chanagePage(0);
        click_event();
    }

    public void click_event()
    {
        Text xiaoWanZi_col = (Text) findComponentById(ResourceTable.Id_txt1);
        Text maKaLong_col = (Text) findComponentById(ResourceTable.Id_txt2);
        Text mshengJian_col = (Text) findComponentById(ResourceTable.Id_txt3);
        //小丸子触发事件
        DirectionalLayout xiaoWanZi = (DirectionalLayout) findComponentById(ResourceTable.Id_xiaowanzi);
        xiaoWanZi.setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                chanagePage(0);
                //修改字体颜色
//                Image xiaoWanZi_img = (Image) findComponentById(ResourceTable.Id_image1);
//                xiaoWanZi_img.setImageAndDecodeBounds(ResourceTable.Media_icon);

                xiaoWanZi_col.setTextColor(Color.BLUE);
                maKaLong_col.setTextColor(Color.BLACK);
                mshengJian_col.setTextColor(Color.BLACK);
            }
        });

        //马卡龙触发事件
        DirectionalLayout maKaLong = (DirectionalLayout) findComponentById(ResourceTable.Id_makalong);
        maKaLong.setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                chanagePage(1);
//                Image maKaLong_img = (Image) findComponentById(ResourceTable.Id_image2);
//                maKaLong_img.setImageAndDecodeBounds(ResourceTable.Media_icon);

                xiaoWanZi_col.setTextColor(Color.BLACK);
                maKaLong_col.setTextColor(Color.BLUE);
                mshengJian_col.setTextColor(Color.BLACK);
            }
        });

        //生煎触发事件
        DirectionalLayout shengJian = (DirectionalLayout) findComponentById(ResourceTable.Id_shengjian);
        shengJian.setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                chanagePage(2);
//                Image shengJian_img = (Image) findComponentById(ResourceTable.Id_image3);
//                shengJian_img.setImageAndDecodeBounds(ResourceTable.Media_icon);

                xiaoWanZi_col.setTextColor(Color.BLACK);
                maKaLong_col.setTextColor(Color.BLACK);
                mshengJian_col.setTextColor(Color.BLUE);
            }
        });
    }

    public void chanagePage(int index)
    {
        FractionAbility fractionAbility = (FractionAbility) getAbility();
        switch (index)
        {
            case 0:
                System.out.println("click 小丸子");
                //点击小丸子，上面部分为小丸子部分
                fractionAbility.getFractionManager().startFractionScheduler()
                        .replace(ResourceTable.Id_stack_layout, new XiaoWanzi()).submit();
                break;
            case 1:
                System.out.println("click 马卡龙");
                fractionAbility.getFractionManager().startFractionScheduler()
                        .replace(ResourceTable.Id_stack_layout, new Makalong()).submit();
                break;
            case 2:
                System.out.println("click 生煎");
                fractionAbility.getFractionManager().startFractionScheduler()
                        .replace(ResourceTable.Id_stack_layout, new ShengJian()).submit();
                break;
            default:
                fractionAbility.getFractionManager().startFractionScheduler()
                        .replace(ResourceTable.Id_stack_layout, new XiaoWanzi()).submit();
                break;
        }
    }
}
