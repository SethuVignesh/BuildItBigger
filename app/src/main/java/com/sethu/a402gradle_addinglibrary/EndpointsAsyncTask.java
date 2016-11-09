package com.sethu.a402gradle_addinglibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.example.sethugayu.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.sethu.mylibrary.LibActivity;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private MyApi myApiService = null;
        private Context context;
        private ProgressDialog mProgressDialog;
    private boolean showProgress;
          public  EndpointsAsyncTask(Context cxt,boolean showDialog){
           this.context=cxt;
              showProgress=showDialog;

             }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(showProgress){
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.show();}
        }

        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
//                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        // options for running against local devappserver
//                        // - 10.0.2.2 is localhost's IP address in Android emulator
//                        // - turn off compression when running against local devappserver
//                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                        .setRootUrl("https://android-app-backend.appspot.com/_ah/api/");
                        .setRootUrl("https://builditbigger-148916.appspot.com/_ah/api/");

                // end options for devappserver

                myApiService = builder.build();
            }

//            context = params[0].first;
//            String name = params[0].second;
            String name = "Sethu";

            try {
                return myApiService.sayHi(name).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if(mProgressDialog!=null && mProgressDialog.isShowing()){
                mProgressDialog.cancel();
            }
//            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
            Intent intent=  new Intent(context, LibActivity.class);
            intent.putExtra("joke",result);
            context.startActivity(intent);
        }
    }