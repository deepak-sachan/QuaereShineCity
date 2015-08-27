package com.quaere.deepak.quaereshinecity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.quaere.deepak.quaereshinecity.Adapter.AccountAdapter;


public class AccountFragment extends android.support.v4.app.Fragment {

    ListView listView;
    String[] profile = new String[]{"Profile","Change Password","Bank Detail"};
    Integer[] proileimg = new Integer[]{R.drawable.profile,R.drawable.changepassword,R.drawable.bankdetail};
    public AccountFragment() {
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
        View view= inflater.inflate(R.layout.fragment_account, container, false);
        AccountAdapter accountAdapter = new AccountAdapter(getActivity(),R.layout.myaccountadapter,profile,proileimg);
        listView = (ListView)view.findViewById(R.id.listv_account);
        listView.setAdapter(accountAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    getActivity().startActivity(new Intent(getActivity(),UserProfileActivity.class));
                }
            }
        });
        return view;
    }




}
