package kim.marty.mtflibs;

import android.app.Application;

/**
 * Created by Charny on 2018-12-04.
 */
public class BaseApplication extends Application {


    public static BaseApplication RAPP;


    public static BaseApplication getRAPP() {
        return RAPP;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        RAPP = this;
    }
}
