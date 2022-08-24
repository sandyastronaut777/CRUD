import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    @Async
    static void testAsync(){
        System.out.println("Async executed by thread" + Thread.currentThread().getName());
    }
}
