package com.example.network_app1.distribute.api;

import ohos.distributedschedule.interwork.DeviceInfo;

public interface SelectDeviceResultListener
{
    void onSuccess(DeviceInfo info);

    void onFail(DeviceInfo info);
}
