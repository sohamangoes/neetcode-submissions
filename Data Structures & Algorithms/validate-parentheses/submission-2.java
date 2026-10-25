class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (top == -1 && isClosing(c))
                return false;

            if (isOpening(c)) {
                stack[++top] = c;
                continue;
            }

            if (isClosing(c)) {
                char o = stack[top--];
                if (!isPair(o, c))
                    return false;
            }
        }

        return top == -1;
    }

    private boolean isOpening(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private boolean isClosing(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    private boolean isPair(char o, char c) {
        if (o == '[' && c == ']')
            return true;
        if (o == '{' && c == '}')
            return true;
        if (o == '(' && c == ')')
            return true;

        return false;
    }
}
