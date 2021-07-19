package priv.kimking.base.compiler;

/**
 * <p>
 *
 * @author kim
 * @date 2021/5/18
 */
public class Compiler {

    public void tokenParse(Token token, Character ch) {
        DfaState newState = DfaState.Initial;
        if (isAlpha(ch)) {
            newState = DfaState.Id;
            token.setType(TokenType.Identifier);
            token.append(ch);
        } else if (isDigit(ch)) {
            newState = DfaState.IntLiteral;
            token.setType(TokenType.IntLiteral);
            token.append(ch);
        } else if (">".equals(ch)) {
            newState = DfaState.Operator;
            token.append(ch);
        }
    }

    public boolean isAlpha(Character ch) {
        return Boolean.FALSE;
    }

    public boolean isDigit(Character ch) {
        return Boolean.FALSE;
    }

}
