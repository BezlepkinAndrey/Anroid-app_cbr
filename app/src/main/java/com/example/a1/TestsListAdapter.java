package com.example.a1;

import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class TestsListAdapter extends ArrayAdapter<Test> {

    private List <Test> testList = null;
    private Context context;
    public TestsListAdapter(Context context, int resource,
                            List objects) {
        super(context, resource, objects);
        this.context = context;
        this.testList = objects;
    }
    @Override
    public int getCount() {
        return ((null != testList) ? testList.size() : 0);
    }

    @Override
    public Test getItem(int position) {
        return ((null != testList) ? testList.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(null == view) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item, null);
        }

        Test data = testList.get(position);

        if(null != data) {
            TextView testName = (TextView) view.findViewById(R.id.test_name);
            TextView testType = (TextView) view.findViewById(R.id.type);

            testName.setText(data.name);
            testType.setText(data.typeOfQuestion);
        }
        return view;
    }
}