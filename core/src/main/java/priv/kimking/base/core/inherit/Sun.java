package priv.kimking.base.core.inherit;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/16
 */
public class Sun extends Parent{

    private String bar = "SUN_BAR";

    @Override
    public void setBar(String bar) {
        this.bar = bar;
    }

    public static void main(String... args) {
        Sun p = new Sun();
        p.setBar("bar");
        System.out.println(p.getBar());
    }

}
