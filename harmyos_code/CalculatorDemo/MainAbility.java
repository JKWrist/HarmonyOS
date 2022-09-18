package com.huawei.cookbook; 
 
import com.huawei.cookbook.slice.MainAbilitySlice; 
 
import ohos.aafwk.ability.Ability; 
import ohos.aafwk.content.Intent; 
import ohos.agp.window.service.WindowManager; 
 
/** 
 * MainAbility 
 * 
 * @since 2021-04-29 
 */ 
public class MainAbility extends Ability { 
    @Override 
    public void onStart(Intent intent) { 
        // 禁止软键盘弹出 
        getWindow().setLayoutFlags(WindowManager.LayoutConfig.MARK_ALT_FOCUSABLE_IM, 
                WindowManager.LayoutConfig.MARK_ALT_FOCUSABLE_IM); 
        super.onStart(intent); 
        super.setMainRoute(MainAbilitySlice.class.getName()); 
    } 
}