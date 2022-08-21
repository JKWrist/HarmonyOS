package com.example.harmonyos2;

import com.example.harmonyos2.slice.MainAbilitySlice;
import com.example.harmonyos2.slice.Second_AbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

//真正的程序的页面入口
public class MainAbility extends Ability
{
    @Override
    public void onStart(Intent intent)
    {
        super.onStart(intent);
//        super.setMainRoute(MainAbilitySlice.class.getName());
        super.setMainRoute(Second_AbilitySlice.class.getName());
    }
}
