import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.kimking.base.spring.dbrouter.DBRouterTestApplication;

import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/11/2
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = {DBRouterTestApplication.class})
public class Bootstrap {

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void testBasePackage() {
        List<String> packages = AutoConfigurationPackages.get(beanFactory);
        for (String pkg: packages) {
            System.out.println(pkg);
        }
        System.out.println(AutoConfigurationPackages.has(beanFactory));
    }

}
