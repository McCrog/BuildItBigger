package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by McCrog on 23/06/2018.
 *
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private OnEventListener<String> mCallBack;
    private static MyApi mApiService = null;
    private Exception mException;

    public EndpointAsyncTask(OnEventListener<String> mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (mApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://gcloud-194852.appspot.com/_ah/api/");

            mApiService = builder.build();
        }

        try {
            return mApiService.getJoke().execute().getData();
        } catch (IOException e) {
            mException = e;
            return mException.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mCallBack != null) {
            if (mException == null) {
                mCallBack.onSuccess(result);
            } else {
                mCallBack.onFailure(mException);
            }
        }
    }
}
