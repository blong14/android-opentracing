package club.w2508.injection;

import android.content.Context;

import javax.inject.Singleton;

import club.w2508.MainActivity;
import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  void inject(MainActivity activity);

  Context context();

}
