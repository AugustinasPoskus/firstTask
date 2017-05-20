package lt.augus.controllers.interceptor;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyInterceptorBinding
public class MyInterceptor {
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        Object target = context.proceed();
        Object[] parameters = context.getParameters();
        if (target instanceof String) {
            String message = (String) target;
            return "Hi, " + message + ", this was intercepted!";
        }
        return context.proceed();
    }
}
