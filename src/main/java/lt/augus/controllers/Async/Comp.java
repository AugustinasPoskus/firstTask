package lt.augus.controllers.Async;

import java.util.concurrent.Future;


public interface Comp {
    public Future<String> asyncMethod();
}
