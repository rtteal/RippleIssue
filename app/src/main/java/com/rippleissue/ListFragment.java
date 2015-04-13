package com.rippleissue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private RecyclerView rvItems;

    private RippleAdapter adapter;

    private List<Item> items = new ArrayList<>();

    public static final String FRAG = "Display Fragment";
    public static final String DIALOG_FRAG = "Display Alert";
    public static final String ACTIVITY = "Display Activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items.add(new Item(ACTIVITY));
        items.add(new Item(DIALOG_FRAG));
        items.add(new Item(FRAG));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        rvItems = (RecyclerView) v.findViewById(R.id.rvItems);
        rvItems.setHasFixedSize(true);
        rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new RippleAdapter(getActivity(), items);

        rvItems.setAdapter(adapter);
        return v;
    }

}
