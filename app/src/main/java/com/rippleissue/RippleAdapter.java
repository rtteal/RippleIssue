package com.rippleissue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RippleAdapter extends RecyclerView.Adapter<RippleAdapter.VH> {
    private List<Item> items;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void displayFrag();
        void displayAlert();
        void displayActivity();
    }

    public RippleAdapter(Context context, List<Item> items){
        this.items = items;
        inflater = LayoutInflater.from(context);
        listener = (OnItemClickListener) context;
    }
    @Override
    public RippleAdapter.VH onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(RippleAdapter.VH vh, int position) {
        final Item i = items.get(position);
        vh.tvText.setText(i.text);
        vh.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i.text){
                    case ListFragment.FRAG:
                        listener.displayFrag();
                        break;
                    case ListFragment.DIALOG_FRAG:
                        listener.displayAlert();
                        break;
                    case ListFragment.ACTIVITY:
                        listener.displayActivity();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private TextView tvText;
        private View rootView;

        public VH(View itemView) {
            super(itemView);
            rootView = itemView;
            tvText = (TextView) itemView.findViewById(R.id.tvText);
        }
    }
}
