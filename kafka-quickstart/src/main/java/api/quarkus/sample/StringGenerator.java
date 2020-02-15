package api.quarkus.sample;


import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class StringGenerator {


    private Random random = new Random();


    @Outgoing("generated-message-strings")
    public Flowable<String> generate() {

        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> "test message " + Integer.toString(random.nextInt(1000)));
    }


}
