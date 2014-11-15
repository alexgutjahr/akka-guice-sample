import akkaGuice.AkkaGuice;
import akkaGuice.AkkaGuiceModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.Application;
import play.GlobalSettings;
import service.DefaultLoggingService;
import service.LoggingService;

/**
 * @author Alexander Hanschke
 */
public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application application) {
        super.onStart(application);
        injector = Guice.createInjector(new AkkaGuiceModule(), new GuiceModule());
        AkkaGuice.InitializeInjector(injector);
    }

    @Override
    public <A> A getControllerInstance(Class<A> controller) throws Exception {
        return injector.getInstance(controller);
    }

    public class GuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(LoggingService.class).to(DefaultLoggingService.class);
        }
    }
}
