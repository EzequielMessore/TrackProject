package com.br.traktproject.exceptions;

import com.br.traktproject.R;
import com.br.traktproject.helpers.ContextHelper;
import com.br.traktproject.util.AppUtil;

/**
 * Created by ZiCa e Thatha on 25/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class NotAvailableServer extends Exception {
    public NotAvailableServer() {
        super(AppUtil.getStringFromResource(ContextHelper.getInstance().getApplicationContext(), R.string.server_error));
    }
}
