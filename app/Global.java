import akkaGuice.AkkaGuice;
import akkaGuice.AkkaGuiceModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.Application;
import play.GlobalSettings;

/**
 * @author Alexander Hanschke
 */
public class Global extends GlobalSettings {

    private final Injector injector = Guice.createInjector(new AkkaGuiceModule("actors"), new GuiceModule());

    @Override
    public void onStart(Application application) {
        super.onStart(application);
        AkkaGuice.InitializeInjector(injector, "actors");
    }

    public class GuiceModule extends AbstractModule {

        @Override
        protected void configure() {

        }
    }
}
