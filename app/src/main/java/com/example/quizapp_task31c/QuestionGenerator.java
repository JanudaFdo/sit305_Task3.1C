package com.example.quizapp_task31c;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



public class QuestionGenerator {
    private static QuestionGenerator instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private QuestionGenerator(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized QuestionGenerator getInstance(Context context) {
        if (instance == null) {
            instance = new QuestionGenerator(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
