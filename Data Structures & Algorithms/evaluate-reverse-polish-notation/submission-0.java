class Solution {
    private final Set<String> OPERATORS = Set.of("+", "*", "/", "-");

    public int evalRPN(String[] tokens) {
        int[] operandStack = new int[tokens.length];
        int top = -1;

        for (String token : tokens) {
            if (!isOperator(token)) {
                operandStack[++top] = Integer.parseInt(token);
                continue;
            }

            int first = operandStack[top - 1];
            int second = operandStack[top];
            int result = execute(first, second, token);

            top--;
            operandStack[top] = result;
        }

        return operandStack[top];
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private int execute(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    return 0;
                return a / b;
        }
        return -1;
    }
}
