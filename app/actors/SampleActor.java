package actors;

import akka.actor.UntypedActor;
import akkaGuice.annotations.Schedule;
import com.google.inject.Singleton;
import play.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Hanschke
 */
@Singleton
@Schedule(initialDelay = 0, interval = 5, timeUnit = TimeUnit.SECONDS)
public class SampleActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        Logger.debug(getSelf() + " received " + message);
    }
}
