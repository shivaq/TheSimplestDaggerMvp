package yasuaki.kyoto.com.thesimplestdaggermvp.data;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * DataManager は Db, Preferences, Remote といった データ三銃士どもを束ねる長である。
 * Db, Preferences, Remote といった データ三銃士がそれぞれガンダム化し、
 * その魂をアカシックレコードに刻む
 *
 *
 * 彼らを DataManager インターフェイス が継承することで、
 * その因縁を実装した AppDataManager が
 * 三銃士が扱う CRUD な呪術のエネルギーを固定化する
 *
 * さらに、DataManager 自身ガンダム化することで、
 * その魂をアカシックレコードに刻む
 *
 *
 *
 * Application会長は契約者である。
 * 因縁とは関係なく、アカシックレコードにある Singleton な DataManager の魂を取得する。
 *
 * Applicatioun 会長は DataManager の呪術を Presenter に配布するパイプにすぎず、
 * CRUD な呪術を UI 世界の理に組み込んでいるのは、各 Presenter たちである。
 *
 *
 *
 * Presenter は自身をガンダム化する。
 * その際、引数として DataManager を取得し、その先にある三銃士の呪術を呼び出し、
 * UI 世界の理 に組み込んで、新たな呪術を再構成する。
 *
 * mvpView は、Presenter を通じて、その新たな呪術を UI 世界に解き放つ
 *
 */
@Singleton
public class AppDataManager implements DataManager {

//    private final Context mContext;
//    private final DbHelper mDbHelper;
//    private final PreferencesHelper mPreferencesHelper;
//    private final ApiHelper mApiHelper;
//
//    @Inject
//    public AppDataManager(@ApplicationContext Context context,
//                          DbHelper dbHelper,
//                          PreferencesHelper preferencesHelper,
//                          ApiHelper apiHelper) {
//        mContext = context;
//        mDbHelper = dbHelper;
//        mPreferencesHelper = preferencesHelper;
//        mApiHelper = apiHelper;
//    }

    @Inject
    public AppDataManager() {
    }

/**
 * ▼ データ三銃士のうち、Db の呪術が UI 世界に解放されるまでの流れ
 *
 * それは、因縁と、アカシックレコードという二つのパスを使って
 * 受け継がれていく？
 *
 * 最果ての契約者が、アカシックレコードから スタンドを手に入れても、
 * 因縁が結ばれていなければ、
 * スタンドを呼び出せても、そのメソッドは呼び出せない。
 * このロジックがいまいちつかめていない。
 *
 *
 *
 * アカシックレコードは、OBJ のインスタンス化を担う ファクトリー？
 * ガンダム化してアカシックレコードに取り込まれた時、インスタンス化がなされる？
 * で、その時ガンダムが必要とする引数がアカシックレコードにあるならば、
 * インスタンス化時に利用される？
 *
 *
 *
 * DbHelper インターフェイス で宣言した呪術 getAllQuestions を
 */
//-------------------------------------------------
//    public interface DbHelper {
//        Observable<List<Question>> getAllQuestions();
//    }
//-------------------------------------------------
/**
 * AppDbHelper が実装し、かつ 自らをガンダム化してアカシックレコードに取り込まれ、
 */
//-------------------------------------------------
//    @Singleton
//    public class AppDbHelper implements DbHelper {
//
//    @Inject
//    public AppDbHelper(DbOpenHelper dbOpenHelper) {
//        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
//}
//        @Override
//        public Observable<List<Question>> getAllQuestions() {// これ
//            return Observable.fromCallable(new Callable<List<Question>>() {
//                @Override
//                public List<Question> call() throws Exception {
//                    return mDaoSession.getQuestionDao().loadAll();
//                }
//            });
//        }
//    }
//-------------------------------------------------


/**
 * DataManager インターフェイスが、データ三銃士のインターフェイス を継承し、
 * その因縁を刻み込み、
 */
//-------------------------------------------------
//public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
//}
//-------------------------------------------------

/**
 * DataManager を実装した AppDataManager は、
 * その因縁から 呪術 getAllQuestions のエネルギーを固定化し、
 * かつ自らをガンダム化し、
 */
//@Singleton
//public class AppDataManager implements DataManager {
//    private final DbHelper mDbHelper;// フィールドに
//
//    @Inject// ガンダム化で三銃士を取り込む
//    public AppDataManager(@ApplicationContext Context context,
//                          DbHelper dbHelper,
//                          PreferencesHelper preferencesHelper,
//                          ApiHelper apiHelper) {
//        mDbHelper = dbHelper;
//    }
//
//    @Override
//    public Observable<List<Question>> getAllQuestions() {// これ
//        return mDbHelper.getAllQuestions();
//    }


/**
 * DataManager の一次的マスター、Application会長 は
 * そんな DataManager をアカシックレコードを通じて取得し、
 */
//-------------------------------------------------
//    public class MvpApp extends Application {
//
//        @Inject
//        DataManager mDataManager;
//    }
//-------------------------------------------------

/**
 * ガンダム化した Presenter が、そのアカシックレコードを通じて、
 * DbHelper の実装した呪術 getAllQuestions を
 * UI 世界の理に組み込んだ呪術 onViewInitialized に再構成し、
 */
//-------------------------------------------------
//    public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
//            implements MainMvpPresenter<V> {
//
//        @Inject// ガンダム化
//        public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
//            super(dataManager, compositeDisposable);
//        }
//
//    @Override
//    public void onViewInitialized() {
//              ...
//                .getAllQuestions()// これ
//              ...
//    }
//}
//-------------------------------------------------

/**
 * その再構成された呪術は Presenter のインターフェイスで宣言済みであるため、
 */
//-------------------------------------------------
//@PerActivity
//public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
//
//    void onViewInitialized();
//}
//-------------------------------------------------


/**
 * 最果ての契約者は Presenter をアカシックレコードを通じて取得し、
 * Presenter との因縁も通じているため、呪術 onViewInitialized にアクセスし、
 * UI 世界に解き放つ
 */
//-------------------------------------------------
//    public class MainActivity extends BaseActivity implements MainMvpView {
//
//        @Inject
//        MainMvpPresenter<MainMvpView> mPresenter;
//
//        @Override
//        protected void setUp() {
//              ...
//            mPresenter.onViewInitialized();
//        }
//    }
//-------------------------------------------------

}