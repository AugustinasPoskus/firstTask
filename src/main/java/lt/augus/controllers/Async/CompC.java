package lt.augus.controllers.Async;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.concurrent.Future;

@Alternative
@ApplicationScoped
public class CompC implements Serializable, Comp {
    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Future<String> asyncMethod() {
        System.out.println("CompC starts working on a big task...");
        try {
            Thread.sleep(10000); // sleep for 10 seconds
        } catch (InterruptedException e) {
        }
        System.out.println("CompC: big task completed.");
        return new AsyncResult<>("BIG result from component C :)");
    }
}
