package com.br.traktproject.service.configuration;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class ApiConfiguration {

    private static final String API_BASE_URL = API.BASE_URL_API;
    private static ExecutorService mExecutorService = Executors.newCachedThreadPool();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    static {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(API.environment.equals(API.ENV.PRODUCTION) ? HttpLoggingInterceptor.Level.NONE : HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
    }

    public static <T> T createService(Class<T> serviceClass) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder();
                requestBuilder.addHeader("Accept", "application/json");
                requestBuilder.addHeader("trakt-api-key","979f89d298de90751736d22e419582a35b5a0827c79da35cc467ec079eaec68c");
                requestBuilder.addHeader("trakt-api-version","2");

                Request request = requestBuilder.build();

                return chain.proceed(request);
            }
        });

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public void stopAll() {
        List<Runnable> pendingAndOngoing = mExecutorService.shutdownNow();
    }

    public static class API {

        final public static ENV environment = ENV.PRODUCTION;
        final public static String BASE_URL = environment.get();
        final public static String BASE_URL_API = BASE_URL;

        public enum ENV {

            PRODUCTION("https://api.trakt.tv/");

            private String env;

            ENV(String env) {
                this.env = env;
            }

            public String get() {
                return env;
            }
        }
    }
}
