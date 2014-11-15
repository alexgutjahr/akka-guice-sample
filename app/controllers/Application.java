package controllers;

import akka.actor.ActorRef;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    private ActorRef actor;

    @Inject
    public Application(@Named("SampleActor") ActorRef actor) {
        this.actor = actor;
    }

    public F.Promise<Result> index(String message) {
        actor.tell(message, ActorRef.noSender());
        return F.Promise.pure(ok());
    }

}
