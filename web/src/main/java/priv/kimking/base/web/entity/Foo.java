package priv.kimking.base.web.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 *
 * @author kim
 * @date 2021/4/22
 */
public class Foo {

    @JsonProperty("foo_foo")
    private String fooFoo;


    @JsonProperty("foo_bar")
    private String fooBar;

    public String getFooFoo() {
        return fooFoo;
    }

    public void setFooFoo(String fooFoo) {
        this.fooFoo = fooFoo;
    }

    public String getFooBar() {
        return fooBar;
    }

    public void setFooBar(String fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "fooFoo='" + fooFoo + '\'' +
                ", fooBar='" + fooBar + '\'' +
                '}';
    }
}
