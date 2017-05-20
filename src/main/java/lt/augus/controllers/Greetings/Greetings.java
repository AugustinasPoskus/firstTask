package lt.augus.controllers.Greetings;

import lt.augus.controllers.interceptor.MyInterceptorBinding;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
@MyInterceptorBinding
public class Greetings implements GreetingsInterface {
    private String greet = "This is second laboratory work";

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet){
        this.greet = greet;
    }
}
