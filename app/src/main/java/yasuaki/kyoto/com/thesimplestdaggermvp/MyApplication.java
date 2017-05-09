package yasuaki.kyoto.com.thesimplestdaggermvp;

import android.app.Application;
import javax.inject.Inject;
import timber.log.Timber;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.ApplicationComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.DaggerApplicationComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ApplicationModule;

public class MyApplication extends Application {

  // This DataManager might be used somewhere that doesn't use presenter.
  // Where is it?
  @Inject
  DataManager mDataManager;

  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();

    mApplicationComponent.inject(this);

    //timber 使用準備
    if (BuildConfig.DEBUG) {
      Timber.uprootAll();
      Timber.plant(new Timber.DebugTree());
    }
  }

  public ApplicationComponent getApplicationComponent() {
    return mApplicationComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}