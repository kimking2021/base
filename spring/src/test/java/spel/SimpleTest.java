package spel;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import priv.kimking.base.spring.spel.Inventor;

import java.util.GregorianCalendar;

/**
 * <p>
 *
 * @author kim
 * @date 2020/12/30
 */
public class SimpleTest {

    @Test
    public void testParserString() {
//        String content = "'Hello World'";
//        String content = "'Hello World'.concat('!')";
        String content = "new String('hello world').toUpperCase()";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(content);
//        String message = (String) exp.getValue();
        String message = exp.getValue(String.class);
        System.out.println(message);
    }

    @Test
    public void testParseBytes() {
        String content = "'Hello World'.bytes";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(content);
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(bytes.length);

        Boolean falseValue = parser.parseExpression("true and false").getValue(Boolean.class);
        System.out.println(falseValue);
    }

    @Test
    public void testParseInteger() {
        String content = "'Hello World'.bytes.length";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(content);
        int length = exp.getValue(Integer.class);
        System.out.println(length);
    }

    @Test
    public void testParsePropertyFromObject() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

//  The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");


        // exp#1
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");
        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
//        String name = exp.getValue(tesla, String.class);
        System.out.println(name);

        // exp#2
        Expression expression = parser.parseExpression("name == 'Nikola Tesla'");
        Boolean result = expression.getValue(tesla, Boolean.class);
        System.out.println(result);
    }

    @Test
    public void testAssignment() {
        Inventor inventor = new Inventor();
        StandardEvaluationContext inventorContext = new StandardEvaluationContext(inventor);

        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("Name").setValue(inventorContext, "Alexander Seovic2");

        System.out.println(inventor.getName());
        String aleks = parser.parseExpression("name = 'Alexandar Seovic'").getValue(inventorContext,
                String.class);
        System.out.println(aleks);
    }




}
