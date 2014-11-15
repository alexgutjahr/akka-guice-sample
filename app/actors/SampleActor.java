package actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import akkaGuice.annotations.Schedule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;
import service.LoggingService;

import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Hanschke
 */
@Singleton
@Schedule(initialDelay = 0, interval = 5, timeUnit = TimeUnit.SECONDS)
public class SampleActor extends AbstractActor {

    private LoggingService log;

    @Inject
    public SampleActor(LoggingService log) {
        this.log = log;
    }

    @Override
    public PartialFunction<Object, BoxedUnit> receive() {
        return ReceiveBuilder.
            match(String.class, this::handle).
            matchAny(this::unhandled).build();
    }

    private void handle(String string) {
        log.debug(string);
    }

}
