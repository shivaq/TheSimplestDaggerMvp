package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

import android.content.Context;
import android.os.Bundle;
import butterknife.ButterKnife;
import javax.inject.Inject;
import yasuaki.kyoto.com.thesimplestdaggermvp.R;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ApplicationContext;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.ActivityComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView{

    // Inject Presenter from an object graph
    @Inject
    MainPresenter mainPresenter;
    @Inject
    @ApplicationContext
    Context context;

    public MainActivity(){}

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // inject to retrieve components from object graph
        getActivityComponent().inject(this);

        mainPresenter.onAttachMvpView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDetachMvpView();
    }

}
