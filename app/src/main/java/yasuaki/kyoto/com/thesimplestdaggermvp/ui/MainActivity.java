package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import timber.log.Timber;
import yasuaki.kyoto.com.thesimplestdaggermvp.MvpApplication;
import yasuaki.kyoto.com.thesimplestdaggermvp.R;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.ActivityComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.DaggerActivityComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ActivityModule;

public class MainActivity extends AppCompatActivity implements MvpView{

    /**
     * フィールドでアカシックレコードに手を伸ばせば、onCreate 前にそれを手にできる。
     */
    @Inject
    MvpPresenter<MvpView> mPresenter;

    /**
     * 下記のように、契約者が俺がガンダムだ、をしても、フィールドで手を伸ばさない限り、
     * onCreate の段階で mPresenter はnull。
     */
//    @Inject
//    public MainActivity(MvpPresenter<MvpView> mainPresenter) {
//        mPresenter = mainPresenter;
//    }

    public MainActivity(){}

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // 契約者は、魔法陣でメフィストフェレスと契約を結ぶ
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApplication) getApplication()).getComponent())
                .build();

        getActivityComponent().inject(this);// エロイム、エッサイム、我は求め訴えたり！
        mPresenter.onAttachMvpView(this);

        Timber.d("MainActivity:onCreate: unko");
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}
