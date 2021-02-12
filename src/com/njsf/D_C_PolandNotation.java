package com.njsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D_C_PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);

        String suffixExpression = "1 2 3 + 4 * + 5 -";
        List<String> spn = getListString(suffixExpression);
        int res = calculate(spn);
        System.out.println(res);



    }
    //将中缀表达式转化为集合
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){
               ls.add(""+c);
               i++;
            }else{
                str = "";
                while(i < s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }
    //将前缀表达式字符串转化为集合
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    //对集合元素进行计算
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String s : ls) {
            if(s.matches("\\d+")){
                stack.push(s);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1= Integer.parseInt(stack.pop());
                int res = 0;
                if(s.equals("+")){
                    res = num1 + num2;
                }else if(s.equals("-")){
                    res = num1 -num2;
                }else if(s.equals("*")){
                    res = num1 * num2;
                }else if(s.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }

                stack.push(""+res);
            }
        }

        return  Integer.parseInt(stack.pop());
    }
}
