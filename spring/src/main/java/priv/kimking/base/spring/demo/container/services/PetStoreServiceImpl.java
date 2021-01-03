package priv.kimking.base.spring.demo.container.services;

import priv.kimking.base.spring.demo.container.dao.JpaAccountDao;
import priv.kimking.base.spring.demo.container.dao.JpaItemDao;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/25
 */
public class PetStoreServiceImpl {

    public void setItemDao(JpaItemDao itemDao) {
        this.itemDao = itemDao;
    }

    private JpaItemDao itemDao;

    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private JpaAccountDao accountDao;

    public JpaAccountDao getAccountDao() {
        return accountDao;
    }

}
