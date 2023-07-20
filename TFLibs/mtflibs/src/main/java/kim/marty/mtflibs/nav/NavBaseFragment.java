package kim.marty.mtflibs.nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;

public class NavBaseFragment<T extends ViewBinding>  extends Fragment {
    protected T binding;
    protected NavController navController;


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        navController  = NavHostFragment.findNavController(this);
        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
