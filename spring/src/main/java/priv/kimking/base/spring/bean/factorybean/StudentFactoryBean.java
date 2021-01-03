package priv.kimking.base.spring.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;
import priv.kimking.base.spring.bean.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
public class StudentFactoryBean implements FactoryBean {

    @Override
    public Object getObject() {
        Student student = new Student();
        student.setId(11);
        student.setName("kim");
        student.setAge(22);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

}
