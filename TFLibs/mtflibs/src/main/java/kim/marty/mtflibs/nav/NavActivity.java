package kim.marty.mtflibs.nav;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import kim.marty.mtflibs.BaseActivity;

public class NavActivity extends BaseActivity {
    protected NavController navController;

    public NavController getNavController() {
        return navController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
