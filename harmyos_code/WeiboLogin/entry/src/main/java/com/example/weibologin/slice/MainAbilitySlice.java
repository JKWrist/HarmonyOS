package com.example.weibologin.slice;

import com.example.weibologin.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;

public class MainAbilitySlice extends AbilitySlice
{
    @Override
    public void onStart(Intent intent)
    {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        TextField phoneInput = findComponentById(ResourceTable.Id_phoneTxt);
        TextField passwdInput = findComponentById(ResourceTable.Id_passwdTxt);
        Button btn = findComponentById(ResourceTable.Id_loginbtn);

        btn.setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {

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
