package com.sundayliu.xposed.fakesysteminfo;

import android.telephony.TelephonyManager;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeSystemInfo implements IXposedHookLoadPackage{

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.startsWith("com.android")){
            return;
        }
        
        XposedHelpers.findAndHookMethod(TelephonyManager.class, "getDeviceId", new XC_MethodReplacement(){

            @Override
            protected Object replaceHookedMethod(MethodHookParam param)
                    throws Throwable {
                // TODO Auto-generated method stub
                return "IMEI:0000000";
            }
            
        });
        XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSubscriberId", new XC_MethodReplacement(){

            @Override
            protected Object replaceHookedMethod(MethodHookParam param)
                    throws Throwable {
                // TODO Auto-generated method stub
                return "SubscriberId:0000000";
            }
            
        });
        
    }

}
