package tangren.szxb.com.theme;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class SpUtils {

    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getIntence());
        }
        return sharedPreferences;
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key, boolean def) {
        return getSharedPreferences().getBoolean(key, def);
    }
}
