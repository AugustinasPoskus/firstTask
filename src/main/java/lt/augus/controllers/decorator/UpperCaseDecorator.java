package lt.augus.controllers.decorator;

import lt.augus.controllers.Greetings.Greetings;
import lt.augus.controllers.Greetings.GreetingsInterface;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class UpperCaseDecorator implements GreetingsInterface {

    @Inject
    @Delegate
    @Any
    Greetings greetings;

    @Override
    public String getGreet() {
        String greet = greetings.getGreet();
        return greet.toUpperCase();
    }
}
