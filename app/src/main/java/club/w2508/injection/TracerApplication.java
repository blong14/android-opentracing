package club.w2508.injection;


import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;


public class TracerApplication extends Application {

  private static TracerApplication instance;

  private ApplicationComponent mAppComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    instance = this;

    mAppComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
  }

  public static TracerApplication getInstance() {
    return instance;
  }

  public static Context getAppContext(){
    return getInstance().getApplicationContext();
  }

  public static Resources getAppResources(){
    return getAppContext().getResources();
  }

  public static PackageManager getAppPackageManager(){
    return getAppContext().getPackageManager();
  }

  public ApplicationComponent getApplicationComponent() {
    return mAppComponent;
  }

}
