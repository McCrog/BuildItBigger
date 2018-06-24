package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.jokesfactory.JokeActivity;

import java.io.IOException;

/**
 * Created by McCrog on 23/06/2018.
 *
 */

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi mApiService = null;
    private Context mContext;

    @Override
    protected String doInBackground(Context... contexts) {
        if (mApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://gcloud-194852.appspot.com/_ah/api/");

            mApiService = builder.build();
        }

        mContext = contexts[0];

        try {
            return mApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jokeIntentName = "JokeIntent";
        Intent intent = new Intent(mContext, JokeActivity.class);
        intent.putExtra(jokeIntentName, result);
        mContext.startActivity(intent);
    }
}
