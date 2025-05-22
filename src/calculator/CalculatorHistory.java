package calculator;
import java.util.ArrayList;
public class CalculatorHistory {
    static ArrayList<String> history = new ArrayList<>();

    public static void addHistory(String expression, float result) {
        history.add(expression + " = " + result);
    }

    public static ArrayList<String> getHistory() {
        return history;
    }

    public static void clearHistory() {
        history.clear();
    }

}
