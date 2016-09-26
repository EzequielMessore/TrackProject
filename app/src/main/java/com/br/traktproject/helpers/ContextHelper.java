package com.br.traktproject.helpers;

import android.content.Context;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class ContextHelper {

    private static Context sApplicationContext;

    private ContextHelper() {
        super();
    }

    public static ContextHelper getInstance() {
        return LazyHolder.sInstance;
    }

    public Context getApplicationContext() {
        return sApplicationContext;
    }

    public void init(final Context context) {
        if (sApplicationContext == null) {
            sApplicationContext = context;
        }
    }

    private static class LazyHolder {
        private static final ContextHelper sInstance = new ContextHelper();
    }
}
