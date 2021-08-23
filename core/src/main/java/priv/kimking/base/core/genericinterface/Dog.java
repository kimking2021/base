package priv.kimking.base.core.genericinterface;

import java.lang.reflect.Type;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/23
 */
public class Dog implements Eat<Food>, Run{

    @Override
    public void eat(Food food) {

    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Class<?> dog = Dog.class;
        Type[] genericInterfaces = dog.getGenericInterfaces();
        Class<?>[] interfaces = dog.getInterfaces();

        System.out.println("hh");
    }
}
