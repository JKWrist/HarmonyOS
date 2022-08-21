package com.example.harmonyos2.slice;

import com.example.harmonyos2.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class Second_AbilitySlice extends AbilitySlice
{
    @Override
    protected void onStart(Intent intent)
    {
        super.onStart(intent);
        //super.setUIContent(ResourceTable.Layout_second_layout);
        setUIContent(ResourceTable.Layout_second_layout);

//        //setUIContent(ResourceTable.Layout_ability_main);
//        Text text = findComponentById(ResourceTable.Layout_second_layout);
//
//        //设置点击事件监听
//        //ctrl + p
//        text.setClickedListener(new Component.ClickedListener()
//        {
//            @Override
//            public void onClick(Component component)
//            {
//                //点击之后 -》 程序会进来调用onClick
//
//                //页面跳转
//                //present
//                present(new MainAbilitySlice(), new Intent());
//            }
//        });
    }
}
