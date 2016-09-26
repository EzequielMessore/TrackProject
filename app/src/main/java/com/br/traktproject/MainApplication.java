package com.br.traktproject;

import android.app.Application;

import com.br.traktproject.helpers.ContextHelper;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ContextHelper.getInstance().init(this);
    }
}
