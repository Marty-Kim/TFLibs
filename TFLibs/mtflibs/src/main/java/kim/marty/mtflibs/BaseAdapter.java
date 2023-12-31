package kim.marty.mtflibs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * User: Marty
 * Date: 2018-11-02
 * Time: 오후 2:47
 * Description:
 */
public abstract class BaseAdapter<T,S extends BaseVH> extends RecyclerView.Adapter<S> {

    public ArrayList<T> arrayList = new ArrayList<>();
    private Context mCon;
    private LayoutInflater mInflater;
    private Integer mLayout;

    OnItemClickListener<T> onItemClickListener;

    public BaseAdapter(Context mCon , Integer mLayout) {
        this.mCon = mCon;
        this.mLayout = mLayout;
        mInflater = (LayoutInflater)mCon.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Context getmCon() {
        return mCon;
    }

    public void setList(ArrayList<T> t){
        arrayList = t;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addList(ArrayList<T> t){
        if (arrayList == null)
            arrayList = new ArrayList<>();
        int pos = arrayList.size();
        arrayList.addAll(t);
        notifyItemRangeChanged(pos,arrayList.size());

    }

    public void addList(T t){
        if (arrayList == null)
            arrayList = new ArrayList<>();
        arrayList.add(t);
        notifyItemInserted(arrayList.size()-1);

    }

    public void onLastItem(T t){

    };

    public void onFirstItem(T t){

    };



    @Override
    public void onBindViewHolder(@NonNull final S s, @SuppressLint("RecyclerView") final int i) {
        s.bind(arrayList.get(i),getmCon());
        if (onItemClickListener != null){
            s.itemView.setOnClickListener(new OnSingleClickListener() {
                @Override
                public void onSingleClick(View v) {
                    onItemClickListener.onItemClick(s.itemView, arrayList.get(i));
                }
            });

        }
        if (i == arrayList.size() -1){
            onLastItem(arrayList.get(i));
        }else if ( i == 0){
            onFirstItem(arrayList.get(i));
        }
    }

    @NonNull
    @Override
    public S onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return getViewHolder(mInflater.inflate(mLayout,viewGroup,false));
    }

    public abstract S getViewHolder(View view);

    @Override
    public int getItemCount() {
        return arrayList.size();
    }




}
