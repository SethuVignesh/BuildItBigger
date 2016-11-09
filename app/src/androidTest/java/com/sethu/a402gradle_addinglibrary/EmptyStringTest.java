package com.sethu.a402gradle_addinglibrary;

import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class EmptyStringTest extends ApplicationTestCase<Application> {
    public EmptyStringTest() {
        super(Application.class);

        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(),false);
        endpointsAsyncTask.execute(new Pair<Context, String>(null, null));
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}