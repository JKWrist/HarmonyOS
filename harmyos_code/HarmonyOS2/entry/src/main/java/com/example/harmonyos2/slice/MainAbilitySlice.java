package com.example.harmonyos2.slice;

import com.example.harmonyos2.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class MainAbilitySlice extends AbilitySlice
{
    @Override
    public void onStart(Intent intent)
    {
        super.onStart(intent);
        //布局绑定
        super.setUIContent(ResourceTable.Layout_ability_main);

        //setUIContent(ResourceTable.Layout_ability_main);
        Text text = findComponentById(ResourceTable.Id_first_text);

        //设置点击事件监听
        //ctrl + p
        text.setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                //点击之后 -》 程序会进来调用onClick

                //页面跳转
                //present
                present(new Second_AbilitySlice(), new Intent());
            }
        });
    }

    @Override
    public void onActive()
    {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent)
    {
        super.onForeground(intent);
    }
}
