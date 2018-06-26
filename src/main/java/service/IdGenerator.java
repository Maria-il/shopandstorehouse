package service;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
@Startup
public class IdGenerator {
    private final AtomicInteger id = new AtomicInteger(0);

    public int getNext(){
        return id.addAndGet(1);
    }
}
