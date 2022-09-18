package com.example.sixdemo;

import com.example.sixdemo.slice.HomeSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;

public class MainAbility extends FractionAbility
{
    @Override
    public void onStart(Intent intent)
    {
        super.onStart(intent);
        super.setMainRoute(HomeSlice.class.getName());
    }
}
