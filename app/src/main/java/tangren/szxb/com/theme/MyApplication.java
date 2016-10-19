package tangren.szxb.com.theme;

import android.app.Application;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
public class MyApplication extends Application {

    private static MyApplication application;

    private static boolean isNight;

    private static String THEME_KEY = "theme_mode";

    public static MyApplication getIntence() {
        if (application == null) {
            application = new MyApplication();
        }
        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        this.application=this;
        init();

    }

    private void init() {
        isNight = SpUtils.getBoolean(THEME_KEY, false);
        if (isNight)//夜间模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        else//默认为白天模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public static void setThemeModel(AppCompatActivity activity, boolean model) {
        if (isNight == model)
            return;
        if (!model)//白天模式
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            activity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            activity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        isNight = model;
        SpUtils.putBoolean(THEME_KEY, isNight);
        activity.recreate();

    }

    public static void refershResource(AppCompatActivity activity) {
        isNight = SpUtils.getBoolean(THEME_KEY, false);
        if (isNight)
            updateConfig(activity, Configuration.UI_MODE_NIGHT_YES);
        else
            updateConfig(activity, Configuration.UI_MODE_NIGHT_NO);
    }


    private static void updateConfig(AppCompatActivity activity, int uiNightModel) {
        Configuration configuration = new Configuration(activity.getResources().getConfiguration());
        configuration.uiMode &= ~Configuration.UI_MODE_NIGHT_MASK;
        configuration.uiMode |= uiNightModel;
        activity.getResources().updateConfiguration(configuration, null);
    }


}
