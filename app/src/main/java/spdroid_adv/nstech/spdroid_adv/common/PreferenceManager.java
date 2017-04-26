package spdroid_adv.nstech.spdroid_adv.common;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Mahesh Nayak on 19-02-2016.
 */
public class PreferenceManager {

    public interface Keys {
        String TOKEN = "token";
        String CUSTOMER_ID = "customer_id";
        String GUEST_SESSION_ID = "guest_id";
        String GCM_TOKEN = "gcm_token";
        String CUSTOMER_PIN = "customer_pin";
        String CUSTOMER_CART_COUNT = "customer_cart_count";
    }

    private static PreferenceManager sInstance;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private PreferenceManager(Context ctx) {
        mPrefs = ctx.getApplicationContext().getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public static PreferenceManager getInstance(Context ctx) {
        if (sInstance == null) {
            sInstance = new PreferenceManager(ctx);
        }
        return sInstance;
    }

    public void setToken(String token) {
        mEditor.putString(Keys.TOKEN, token).commit();
    }

    public String getToken() {
        return mPrefs.getString(Keys.TOKEN, Constants.EMPTY_TEXT);
    }

    public void setCustomerId(String token) {
        mEditor.putString(Keys.CUSTOMER_ID, token).commit();
    }

    public String getCustomerId() {
        return mPrefs.getString(Keys.CUSTOMER_ID, Constants.EMPTY_TEXT);
    }

    public void setGuestId(String token) {
        mEditor.putString(Keys.GUEST_SESSION_ID, token).commit();
    }

    public String getGuestId() {
        return mPrefs.getString(Keys.GUEST_SESSION_ID, Constants.EMPTY_TEXT);
    }

    public void setGcmToken(String token) {
        mEditor.putString(Keys.GCM_TOKEN, token).commit();
    }

    public String getGcmToken() {
        return mPrefs.getString(Keys.GCM_TOKEN, Constants.EMPTY_TEXT);
    }

    public void setCustomerPin(String pin) {
        mEditor.putString(Keys.CUSTOMER_PIN, pin).commit();
    }

    public String getCustomerPin() {
        return mPrefs.getString(Keys.CUSTOMER_PIN, Constants.EMPTY_TEXT);
    }

    public void setCustomerCartCount(int count) {
        mEditor.putInt(Keys.CUSTOMER_CART_COUNT, count).apply();
    }

    public int getCustomerCartCount() {
        return mPrefs.getInt(Keys.CUSTOMER_CART_COUNT, 0);
    }
}