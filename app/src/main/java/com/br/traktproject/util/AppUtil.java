package com.br.traktproject.util;

import android.content.Context;
import android.widget.ImageView;

import com.br.traktproject.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class AppUtil {

    public static String getStringFromResourceWithText(Context context, int idResource, String text) {
        return context.getResources().getString(idResource, text);
    }

    public static String getStringFromResource(Context context, int idResource) {
        return context.getResources().getString(idResource);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br"));
        return dateFormat.format(date);
    }

    public static String formatNumber(Double value) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(value);
    }

}
