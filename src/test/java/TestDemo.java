import com.demo.DemoApplication;
import com.demo.pojos.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = DemoApplication.class)
public class TestDemo {
    @Test
    public void test01(){
        Class c = User.class;
        System.out.println(c == User.class);
    }
}
