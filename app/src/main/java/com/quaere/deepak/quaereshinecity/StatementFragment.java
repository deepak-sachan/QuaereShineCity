package com.quaere.deepak.quaereshinecity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.quaere.deepak.quaereshinecity.Adapter.StatementAdapter;


public class StatementFragment extends android.support.v4.app.Fragment {

    int position;
    ListView list;
    String[] itemname = {
            "Today's Transaction", "Datewise Transaction", "Debit Transaction", "Credit Transaction", "Search Privilege Card- Invoice No."
    };

    Integer[] imgid = {
            R.drawable.today_transaction,
            R.drawable.datewise_transaction,
            R.drawable.arrow_up,
            R.drawable.arrow_down,
            R.drawable.search
    };

    public StatementFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_statement, container, false);
        StatementAdapter adapter = new StatementAdapter(getActivity().getApplicationContext(), R.layout.mystatementadapter, itemname, imgid);
        list = (ListView) view.findViewById(R.id.listv_statement);
        list.setAdapter(adapter);

        return view;
    }





}
