package priv.kimking.base.compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 词
 *
 * @author kim
 * @date 2021/5/18
 */
public class Token {

    private TokenType type;

    private final List<Character> text = new ArrayList<>();

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public List<Character> getText() {
        return text;
    }

    public void append(Character ch) {
        this.text.add(ch);
    }
}
