package com.example.mycalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class BaseCalculator {

    private final char[] operSet = {'+', '-', '×', '/'};

    //Map结构方便后面取运算符的下标
    private final Map<Character, Integer> operMap = new HashMap<Character, Integer>() {
        {
            put('+', 0);
            put('-', 1);
            put('×', 2);
            put('/', 3);
        }//规定符号映射
    };

    //运算符优先级表
    private final char[][] operPrior = {
            /*   +   -   ×   /  */
            /* + */ {'>', '>', '<', '<', '>'},
            /* - */ {'>', '>', '<', '<', '>'},
            /* × */ {'<', '<', '>', '>', '>'},
            /* / */ {'<', '<', '>', '>', '>'},
    };

    private char getPrior(char oper1, char oper2) {
        return operPrior[operMap.get(oper1)][operMap.get(oper2)]; //Map.get方法获取运算符的下标
    }

    private boolean hasOper(String s) {//是否有运算符
        return s.contains("+") || s.contains("-") || s.contains("×") || s.contains("/");
    }

    private double operate(double a, char oper, double b) {
        switch (oper) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '×':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + oper);
        }
    }

    private boolean isOper(char c) {
        for (char oper : operSet) {
            if (c == oper) {
                return true;
            }
        }
        return false;
    }

    private double calSubmath(String math) {
        // 将表达式按空格分割（假设表达式元素之间由空格分隔）
        String[] elements = math.split(" ");

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String element : elements) {
            if (element.isEmpty()) {
                continue; // 忽略空字符串
            }

            // 检查元素是否为数字
            if (element.matches("-?\\d+(\\.\\d+)?")) {
                numbers.push(Double.parseDouble(element));
            } else if (isOper(element.charAt(0))) {
                // 如果是运算符，处理栈中的运算符和数字
                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), element.charAt(0))) {
                    char op = operators.pop();
                    double right = numbers.pop();
                    double left = numbers.pop();
                    numbers.push(operate(left, op, right));
                }
                operators.push(element.charAt(0));
            } else {
                // 无效的输入
                throw new IllegalArgumentException("Invalid character in expression: " + element);
            }
        }

        // 处理栈中剩余的运算符
        while (!operators.isEmpty()) {
            numbers.push(operate(numbers.pop(), operators.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    // 检查运算符是否有更高的优先级
    private boolean hasHigherPrecedence(char op1, char op2) {
        return (op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/');
    }

    // 执行运算


    double cal(String math, int precision) {
        if (math.length() == 0) {
            return Double.MAX_VALUE;
        } else {
            double result = calSubmath(math);
            return Double.parseDouble(String.format("%." + precision + "f", result));
        }
    }
}
