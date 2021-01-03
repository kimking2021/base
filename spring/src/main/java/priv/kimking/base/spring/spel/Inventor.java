package priv.kimking.base.spring.spel;

import java.util.Date;

/**
 * <p>
 *
 * @author kim
 * @date 2020/12/30
 */
public class Inventor {

    public Inventor() {
    }

    public Inventor(String name, Date birthday, String country) {
        this.name = name;
        this.birthday = birthday;
        this.country = country;
    }

    private String name;

    private Date birthday;

    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
