package androidmvp.vinzdez.com.androidmvp.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Vicente Angcaway on 20/12/2016.
 */

public class ScreenUtil {

    private static int screenWidth = 0;
    private static int screenHeight = 0;

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getScreenHeight(Context context) {
        if (screenHeight == 0) {
            screenHeight = getSize(context).y;
        }

        return screenHeight;
    }

    public static int getScreenWidth(Context context) {
        if (screenWidth == 0) {
            screenWidth = getSize(context).x;
        }

        return screenWidth;
    }

    private static Point getSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }
}
