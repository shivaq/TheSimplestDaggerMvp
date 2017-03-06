package yasuaki.kyoto.com.thesimplestdaggermvp.di.component;

import javax.inject.Singleton;

import dagger.Component;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}