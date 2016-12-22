package club.w2508.injection;

import static android.content.Context.SENSOR_SERVICE;

import android.content.Context;
import android.hardware.SensorManager;

import org.hawkular.apm.client.opentracing.APMTracer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import io.opentracing.Tracer;


@Module
public class ApplicationModule {
  private final TracerApplication application;

  public ApplicationModule(TracerApplication application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return application;
  }

  @Provides
  @Singleton
  SensorManager provideSensorManager() {
    return (SensorManager) application.getSystemService(SENSOR_SERVICE);
  }

  @Provides
  @Singleton
  Tracer provideTracer() {
    return new APMTracer();
  }

}
