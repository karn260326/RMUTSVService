package app.rmutsv.karn.rmutsvservice.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import app.rmutsv.karn.rmutsvservice.MyServiceActivity;
import app.rmutsv.karn.rmutsvservice.R;
import app.rmutsv.karn.rmutsvservice.utility.GetAllData;
import app.rmutsv.karn.rmutsvservice.utility.ListViewAdapter;
import app.rmutsv.karn.rmutsvservice.utility.Myconstant;

/**
 * Created by lenovo on 9/11/2560.
 */

public class ServiceFragment extends Fragment{

    public  static ServiceFragment serviceInstance(String[] strings) {

        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", strings);
        serviceFragment.setArguments(bundle);

        return serviceFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] strings = getArguments().getStringArray("Login");
        Log.d("9novV1", "Login(1) on ServiceFragment ==> " + strings[1]);

//        create Toolbar
        createToolbar(strings[1]);

//        Create ListView
        createListView();

    }

    private void createListView() {
        ListView listView = getView().findViewById(R.id.livUser);
        Myconstant myconstant = new Myconstant();

        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myconstant.getUrlGetAlluser());
            String resultJSON = getAllData.get();
            Log.d("9novVi", "JSON ==> " + resultJSON);

            JSONArray jsonArray = new JSONArray(resultJSON);

            String[] nameString = new String[jsonArray.length()];
            String[] catString = new String[jsonArray.length()];
            String[] userString = new String[jsonArray.length()];
            String[] passwordString = new String[jsonArray.length()];

            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameString[i] = jsonObject.getString("Name");
                catString[i] = jsonObject.getString("Category");
                userString[i] = jsonObject.getString("User");
                passwordString[i] = jsonObject.getString("Password");

            }   // for

            ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(),
                    nameString, catString, userString, passwordString);
            listView.setAdapter(listViewAdapter);


        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void createToolbar(String strTitle) {
        Toolbar toolbar = getView().findViewById(R.id.toolbarService);
        ((MyServiceActivity)getActivity()).setSupportActionBar(toolbar);
        ((MyServiceActivity) getActivity()).getSupportActionBar().setTitle(strTitle);
        ((MyServiceActivity)getActivity()).getSupportActionBar().setSubtitle("Who Loged");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_service, container, false);

        return view;
    }
}   // Main Class
