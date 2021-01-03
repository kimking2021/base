package priv.kimking.base.spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.kimking.base.spring.demo.container.ServicesConfigure;
import priv.kimking.base.spring.demo.container.dao.JpaAccountDao;
import priv.kimking.base.spring.demo.container.services.PetStoreServiceImpl;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/25
 */
public class Demo {

    public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfigure.class);
        PetStoreServiceImpl service = ctx.getBean("petStore", PetStoreServiceImpl.class);
        JpaAccountDao dao = service.getAccountDao();
        System.out.println(dao);
    }


}
