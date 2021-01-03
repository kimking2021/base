package priv.kimking.base.spring.demo.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import priv.kimking.base.spring.demo.container.dao.JpaAccountDao;
import priv.kimking.base.spring.demo.container.dao.JpaItemDao;
import priv.kimking.base.spring.demo.container.services.PetStoreServiceImpl;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/25
 */
@Configuration
public class ServicesConfigure {


    @Bean
    public JpaAccountDao accountDao() {
        return new JpaAccountDao();
    }

    @Bean
    public JpaItemDao itemDao() {
        return new JpaItemDao();
    }

    @Bean
    public PetStoreServiceImpl petStore() {
        PetStoreServiceImpl service = new PetStoreServiceImpl();
        service.setAccountDao(accountDao());
        service.setItemDao(itemDao());
        return service;
    }


}
