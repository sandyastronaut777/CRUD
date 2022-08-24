import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/")
    public String testAsync(){
        System.out.println("Start testAsync -" + Thread.currentThread().getName());
        AsyncTask.testAsync();
        System.out.println("End testAsync -" + Thread.currentThread().getName());
        return "Test Async";
    }
}



