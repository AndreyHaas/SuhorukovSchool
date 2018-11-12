import com.jcourse.gaas.stackcalc.command.Addition;
import com.jcourse.gaas.stackcalc.command.Command;
import com.jcourse.gaas.stackcalc.command.Division;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcTest {
    private Stack<Double> stack = new Stack<>();
    private Map<String, Double> map = new HashMap<>();

    @Test
    @DisplayName("Test for additional")
    void addTest() {
        Command add = new Addition();
        double firstValue = 5.0;
        stack.push(firstValue);
        double secondValue = 4.0;
        stack.push(secondValue);
        add.execute(stack, map, new String[0]);
        assertEquals(9.0, stack.peek(), .000001);
    }

    @RepeatedTest(2)
    @DisplayName("Test for division")
    void divTest() {
        Command div = new Division();
        double firstValue = 4.0;
        stack.push(firstValue);
        double secondValue = 4.0;
        stack.push(secondValue);
        div.execute(stack, map, new String[0]);
        assertEquals(1.0, stack.peek(), .000001);
    }
}
