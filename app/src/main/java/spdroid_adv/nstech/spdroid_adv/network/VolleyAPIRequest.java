package spdroid_adv.nstech.spdroid_adv.network;

import android.content.Context;
import android.content.pm.PackageManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import spdroid_adv.nstech.spdroid_adv.common.Constants;
import spdroid_adv.nstech.spdroid_adv.common.PreferenceManager;

/**
 * Created by Mahesh Nayak on 16-02-2016.
 */
public class VolleyAPIRequest<T> extends JsonRequest<T> implements Constants.HeaderKeys, Constants.AppConstants {

    private final ObjectMapper mMapper = new ObjectMapper();
    private Class<T> mClazz;
    private Map<String, String> mHeaders;
    private Response.Listener<T> mListener;
    private Context mContext;


    private VolleyAPIRequest(Builder builder) {
        super(builder.mMethod, builder.mUrl, builder.mRequestBody, builder.mListener, builder.mErrorListener);
        mClazz = builder.mClazz;
        mHeaders = builder.mHeaders;
        mListener = builder.mListener;
        mContext = builder.mContext;
        setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        try {
            mHeaders.put(Constants.HeaderKeys.API_VERSION_CODE, String.valueOf(mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            mHeaders.put(Constants.HeaderKeys.API_VERSION_CODE, "1");
        }
        mHeaders.put(X_CLIENT, PLATFORM);
        mHeaders.put(CONTENT_TYPE, CONTENT_FORMAT);
        mHeaders.put(CACHE_CONTROL, NO_CACHE);
        /*if (!LoginUtil.isUserLoggedIn(mContext) &&
                !TextUtils.isEmpty(PreferenceManager.getInstance(mContext).getGuestId()))*/
            mHeaders.put(X_SESSION, PreferenceManager.getInstance(mContext).getGuestId());
        return mHeaders;
    }

    @Override
    public String getBodyContentType() {
        return CONTENT_FORMAT;
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        if (error.networkResponse != null)
           // DialogUtil.showDebugToast(mContext, error.networkResponse.statusCode + error.getMessage());
       /* if (OAuthManager.getInstance().handleServiceResponse(mContext, error.networkResponse,
                this))*/
            super.deliverError(error);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));

            return Response.success(
                    mMapper.readValue(json, mClazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (JsonMappingException e) {
          //  DialogUtil.showDebugToast(mContext, e.getMessage());
            return Response.error(new ParseError(e));
        } catch (UnsupportedEncodingException e) {
          //  DialogUtil.showDebugToast(mContext, e.getMessage());
            return Response.error(new ParseError(e));
        } catch (JsonParseException e) {
          //  DialogUtil.showDebugToast(mContext, e.getMessage());
            return Response.error(new ParseError(e));
        } catch (IOException e) {
         //   DialogUtil.showDebugToast(mContext, e.getMessage());
            return Response.error(new ParseError(e));
        }
    }

    public static class Builder<T> {
        private final Class<T> mClazz;
        private Map<String, String> mHeaders = new HashMap<>();
        private final Response.Listener<T> mListener;
        private final Context mContext;
        private final String mUrl;
        private final Response.ErrorListener mErrorListener;
        private final int mMethod;
        private String mRequestBody;


        public Builder(Context ctx, int method, Class<T> clazz, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
            mContext = ctx;
            mMethod = method;
            mClazz = clazz;
            mUrl = url;
            mListener = listener;
            mErrorListener = errorListener;
        }

        public Builder setHeaders(Map<String, String> headers) {
            mHeaders = headers;
            return this;
        }

        public Builder setRequestBody(String requestBody) {
            mRequestBody = requestBody;
            return this;
        }

        public VolleyAPIRequest<T> build() {
            return new VolleyAPIRequest<>(this);
        }


    }
private void setCachingMachanism(Context mContext){
    RequestQueue mRequestQueue;

// Instantiate the cache
    Cache cache = new DiskBasedCache(mContext.getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
    Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
    mRequestQueue = new RequestQueue(cache, network);

// Start the queue
    mRequestQueue.start();

    String url ="http://www.example.com";

// Formulate the request and handle the response.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Do something with the response
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Handle error
                }
            });

// Add the request to the RequestQueue.
    mRequestQueue.add(stringRequest);

}
}