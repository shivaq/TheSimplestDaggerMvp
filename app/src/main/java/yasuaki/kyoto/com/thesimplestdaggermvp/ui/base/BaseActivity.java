package yasuaki.kyoto.com.thesimplestdaggermvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.LongSparseArray;
import java.util.concurrent.atomic.AtomicLong;
import yasuaki.kyoto.com.thesimplestdaggermvp.MyApplication;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.ActivityComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.DaggerActivityComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ActivityModule;

/**
 * Created by Yasuaki on 2017/04/14.
 */

public class BaseActivity extends AppCompatActivity implements BaseMvpView {

    // Store ActivityComponent to make it configure persistent
    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ActivityComponent> sActivityComponentCache = new LongSparseArray<>();
    private long activityId;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();

        // if the specified key is not mapped, returns negative number
        if(sActivityComponentCache.indexOfKey(activityId) < 0){
            // A kind of magic square to contract with the component
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    // ApplicationComponent is daggerred at MyApplication.
                    .applicationComponent(((MyApplication)getApplication()).getApplicationComponent())
                    .build();//ActivityComponent is daggerred at here.

            sActivityComponentCache.put(activityId, activityComponent);
        } else {
            activityComponent = sActivityComponentCache.get(activityId);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, activityId);
    }

    @Override
    protected void onDestroy() {
        if(!isChangingConfigurations()){
            sActivityComponentCache.remove(activityId);
        }
        super.onDestroy();
    }

    public ActivityComponent getActivityComponent(){
        return activityComponent;
    }
}
