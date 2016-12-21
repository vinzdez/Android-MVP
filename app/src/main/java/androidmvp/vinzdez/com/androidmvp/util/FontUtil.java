package androidmvp.vinzdez.com.androidmvp.util;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Vicente Angcaway on 21/12/2016.
 */

public class FontUtil {

    private static final String fontAwesomeAsset = "fontawesome-webfont.ttf";
    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static Typeface getFontAwesome(Context c) {
        synchronized (cache) {
            if (!cache.containsKey(fontAwesomeAsset)) {
                Typeface typeface = Typeface.createFromAsset(c.getAssets(), fontAwesomeAsset);
                cache.put(fontAwesomeAsset, typeface);
            }
            return cache.get(fontAwesomeAsset);
        }
    }
}
