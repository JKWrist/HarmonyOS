package com.example.weibologin;

import com.example.weibologin.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability
{
    @Override
    public void onStart(Intent intent)
    {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
