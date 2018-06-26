package com.udacity.gradle.builditbigger;

/**
 * Created by alex on 27/06/2018.
 */

public interface OnEventListener<T> {
    void onSuccess(T object);
    void onFailure(Exception e);
}
