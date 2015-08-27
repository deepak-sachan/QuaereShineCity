package com.quaere.deepak.quaereshinecity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends android.support.v4.app.Fragment {

    public static final String TAG = LoginFragment.class.getSimpleName();
    private Button loginbutton;
    private EditText edname;
    private EditText edpassword;
    public  String response;
    public LoginFragment() {
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
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        edname = (EditText)view.findViewById(R.id.edt_login);
        edpassword = (EditText)view.findViewById(R.id.edt_password);
        loginbutton =(Button)view.findViewById(R.id.login_btn);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edname.getText().toString();
                String password = edpassword.getText().toString();
                if (CheckNetwork.isInternetAvailable(getActivity().getApplication())) //returns true if internet available
                {
                    String url = "http://cp.shinecityinfra.in/SCServices.svc/VendorLogin/"+userName+"/"+password;
                    Log.v(TAG, "ghhhhhhhhhk" + url);
                    new UserLoginTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);

                     // startActivity(new Intent(getActivity(), PagerslidingActivity.class));

                } else {
                    getFragmentManager().beginTransaction().replace(R.id.fragment, new NoConnectionFragment()).commit();
                    Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }

            }

        });
        return view;
    }


   public class UserLoginTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
          /*  List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair(Constants.USERNAME, params[0]));
            pairs.add(new BasicNameValuePair(Constants.PASSWORD, params[1]));
            String username= params[0];
            String password = params[1];*/

            //  String url = "http://demo8.mlmsoftindia.com/ShinePanel.svc/Shinecity/TOWJ146/business";
             response = HttpAgent.get(params[0]);
            // AuthenticationResponse authResponse = null;
            String s = response;
            if (response != null) {
             UserProfileActivity.getString(response);
                //  startActivity(new Intent(getActivity(),PagerslidingActivity.class));
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response2) {
            if (response2 != null) {
                response = response2.toString();

                super.onPostExecute(response);

                startActivity(new Intent(getActivity(), PagerslidingActivity.class));

            }else{
                Toast.makeText(getActivity(),"invalid username or password",Toast.LENGTH_LONG).show();
            }

        }
    }



}
