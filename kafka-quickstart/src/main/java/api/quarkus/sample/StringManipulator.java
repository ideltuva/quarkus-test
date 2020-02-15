package api.quarkus.sample;


import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StringManipulator {


    @Incoming("message-strings")
    @Outgoing("message-stream")
    @Broadcast
    public String process(String messageString) {
        String messageOut = messageString;
        return messageOut + " -- re-read in manipulator and sent to in-memory stream";
    }


}
