package kim.marty.mtflibs.web;

import android.content.Context;
import android.webkit.WebChromeClient;

public class BChromClient extends WebChromeClient {
    Context mCon;


    public BChromClient(Context mCon) {
        super();
        this.mCon = mCon;
    }
}
