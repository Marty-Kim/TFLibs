package kim.marty.mtflibs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;



public class LoadingDlg extends ProgressDialog {
    public LoadingDlg(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setCancelable(false);
    }
}
