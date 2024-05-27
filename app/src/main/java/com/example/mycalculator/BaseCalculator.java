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
            /*   +   -   ×   /    */
            /* + */ {'>', '>', '<', '<', '>'},
            /* - */ {'>', '>', '<', '<', '>'},
            /* × */ {'>', '>', '>', '>', '>'},
            /* / */ {'>', '>', '>', '>', '>'},
    };//存储不同运算符之间的优先级关系

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
                    return Double.MAX_VALUE; //处理异常
                }
                return a / b;
            default:
                return 0;
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
        if (math.length() == 0) {
            return Double.MAX_VALUE;//输入为空
        } else {
            if (!hasOper(math.substring(1, math.length())) || math.contains("E-")) {
                return Double.parseDouble(math);//不含运算符号
            }

            Stack<Character> operStack = new Stack<>();//oper栈
            Stack<Double> numStack = new Stack<>();//num栈
            operStack.push('#'); //设置栈底元素
            math += "#";
            String tempNum = "";//暂存数字str


            for (int i = 0; i < math.length(); i++) {
                char charOfMath = math.charAt(i); //遍历math中的char

                //num进栈
                if (!isOper(charOfMath)) {//不是oper
                    tempNum += charOfMath;//暂存数字内容
                    //获取下一个char
                    i++;
                    charOfMath = math.charAt(i);
                    if (isOper(charOfMath)) {//此条件成功时下次for循环就直接跳到else语句
                        double num = Double.parseDouble(tempNum);
                        numStack.push(num); //push num 数字进栈
                        tempNum = ""; //重置tempNum
                    }
                    i--;//回退，防止下次循环for语句i++使得跳过了下个char
                }

                //oper进栈
                else {
                    //运算符按优先级入栈
                    switch (getPrior(operStack.peek(), charOfMath)) {//比较栈顶符号和新符号

                        //栈顶oper优先级低，新oper入栈
                        case '<':
                            operStack.push(charOfMath);
                            break;

                        //栈顶oper优先级高，oper出栈，并将num运算结果push进numStack
                        case '>':
                            char oper = operStack.pop();
                            double b = numStack.pop();
                            double a = numStack.pop();
                            if (operate(a, oper, b) == Double.MAX_VALUE)
                                return Double.MAX_VALUE;
                            numStack.push(operate(a, oper, b));
                            i--; //继续比较该oper与栈顶oper的关系
                            break;
                    }
                }
            }
            return numStack.peek(); //最后的math变成一个num了
        }

    }
    double cal(String math, int precision) {
        if (math.length() == 0) {
            return Double.MAX_VALUE;
        } else {
            double result = calSubmath(math);
            return Double.parseDouble(String.format("%." + precision + "f", result));
        }
    }
}
