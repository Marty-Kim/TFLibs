package kim.marty.mtflibs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 3;

    public static Context Mapp;
    public static boolean getConnectivityStatus(){ //해당 context의 서비스를 사용하기위해서 context객체를 받는다.
        ConnectivityManager manager = (ConnectivityManager) Mapp.getSystemService(Mapp.CONNECTIVITY_SERVICE);

        @SuppressLint("MissingPermission") NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null){
            int type = networkInfo.getType();
            if(type == ConnectivityManager.TYPE_MOBILE){// 일반 데이터 사용
                return true;//TYPE_MOBILE;
            }else if(type == ConnectivityManager.TYPE_WIFI){//와이파이 연결된것
                return true;//TYPE_WIFI;
            }
        }
        return false;//TYPE_NOT_CONNECTED;  //연결이 되지않은 상태
    }
}