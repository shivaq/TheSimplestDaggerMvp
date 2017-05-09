package yasuaki.kyoto.com.thesimplestdaggermvp.di.component;

import android.app.Application;
import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import yasuaki.kyoto.com.thesimplestdaggermvp.MyApplication;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ApplicationContext;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // A kind of a list of contractor
    void inject(MyApplication myApplication);

    // ActivityComponent が ApplicationComponent の提供するインスタンスを
    // dependencies にて使えるようにするために、使用対象OBJを下記のように宣言する
    @ApplicationContext
    Context context();

    Application application();
    DataManager getDataManager();
}