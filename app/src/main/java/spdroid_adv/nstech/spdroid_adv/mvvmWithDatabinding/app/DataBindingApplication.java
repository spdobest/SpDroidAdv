package spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding.app;

import android.app.Application;

import com.android.databinding.library.BuildConfig;

import spdroid_adv.nstech.spdroid_adv.mvvmWithDatabinding.model.Book;
import timber.log.Timber;

import java.util.List;


/**
 * Created by Mustafa Ali on 11/03/15.
 */
public class DataBindingApplication extends Application {
    private List<Book> mBooks;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public List<Book> getBooks() {
        return mBooks;
    }

    public void setBooks(List<Book> mResultsist) {
        this.mBooks = mResultsist;
    }
}