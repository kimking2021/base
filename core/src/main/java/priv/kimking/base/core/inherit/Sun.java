package priv.kimking.base.core.inherit;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/16
 */
public class Sun extends Parent{

    public String BAR = "SUN_BAR";


    @Override
    public String plus() {
        return FOO + BAR;
    }

    public static void main(String... args) {
        Sun p = new Sun();
        String r = p.plus();
        System.out.println(r);
    }

}
