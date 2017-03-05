package yasuaki.kyoto.com.thesimplestdaggermvp.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import yasuaki.kyoto.com.thesimplestdaggermvp.MvpApplication;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ApplicationContext;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApplication mvpApplication);

    @ApplicationContext
    Context context();

    Application application();
//    DataManager getDataManager();

}