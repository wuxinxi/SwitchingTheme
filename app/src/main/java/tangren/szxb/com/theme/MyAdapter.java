package tangren.szxb.com.theme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private List<Bean> list;
    private Context context;

    public MyAdapter(Context context, List<Bean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Bean bean = list.get(position);
        if (bean == null)
            return;
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        bindData(bean, myViewHolder.textView);
    }

    private void bindData(Bean bean, TextView textView) {
        textView.setText(bean.getString());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
