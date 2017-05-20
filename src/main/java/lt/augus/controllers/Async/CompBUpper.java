package lt.augus.controllers.Async;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.transaction.Transactional;
import java.util.concurrent.Future;

@ApplicationScoped
//@Specializes
public class CompBUpper { //extends CompB

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Future<String> asyncMethod() {
        System.out.println("COMPB STARTS WORKING ON A BIG TASK...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        System.out.println("COMPB: BIG TASK COMPLETED.");
        return new AsyncResult<>("BIG RESULT FROM COMPONENT B :)");
    }
}
