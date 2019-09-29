package com.example.a1;


import android.os.Bundle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.app.PendingIntent;
import java.util.List;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.TaskStackBuilder;
import java.util.ArrayList;
import android.media.MediaRecorder;
import android.support.v4.app.NotificationCompat;
import android.media.MediaPlayer;


public class show_list extends ListActivity {

    private List <Test> applist = null;
    private TestsListAdapter listadapter = null;
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        // appList = (ListView) findViewById(R.id.appList);

        //PackageManager pm = getPackageManager();
        //List<ApplicationInfo> packages = pm
        //      .getInstalledApplications(PackageManager.GET_META_DATA);

        //AppListAdapter appListAdapter = new AppListAdapter(this, pm, packages);
        //appList.setAdapter(appListAdapter);

       // Intent notificationIntent = new Intent(this, RecognationStart.class);
       // showNotification2(this, "jhjk", "jhjh,m", notificationIntent);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

       Test app = applist.get(position);


       // Intent intent = new Intent(this, SpeechRecognition.class);
       // intent.putExtra("packageName", app.packageName);
       // startActivity(intent);

    }

    private List <Test> checkForLaunchIntent(List <Test> list) {

        ArrayList <Test> appList = new ArrayList <Test> ();

        for(Test info : list) {
            try{
                    appList.add(info);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return appList;
    }

    private class LoadApplications extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progress = null;

        @Override
        protected Void doInBackground(Void... params) {

           // applist = checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));

            listadapter = new TestsListAdapter(show_list.this, R.layout.list_item, applist);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            setListAdapter(listadapter);
            progress.dismiss();
            super.onPostExecute(result);
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(show_list.this, null, "Loading apps info...");
            super.onPreExecute();
        }
    }
}
