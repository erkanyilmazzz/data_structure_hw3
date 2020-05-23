package com.company;

import java.util.Scanner;

public class Postfix_eval {
    private StringBuilder _infix;
    private StringBuilder _postFix;

    public static String convert(String infix) {
        String postFix = "";
        Stack<Character> stack = new Stack<Character>();
        char temp ;
        int i = 0;
        for (i = 0; i < infix.length(); ++i) {
            temp=infix.charAt(i);
           // System.out.println(postFix);
            //System.out.println("girdi 0");

            if(Character.isLetterOrDigit(temp)||temp=='.'){
                if(temp!='s'&&temp!='c'&&temp!='a'){

                    postFix+=temp;
                  //  System.out.println("girdi 1");
                }
            }else if(temp=='('){
                stack.push(temp);
                //System.out.println("girdi 2");

            }else if(temp==')'){
                while(!stack.empty()&&stack.peek()!='('){
                    postFix+=stack.pop();
                  //  System.out.println("girdi 3");

                }
                if(stack.empty()){
                    return"ex not valid";
                }
                else{
                    stack.pop();
                   // System.out.println("girdi 4");

                }
            }

             if (isOp(temp)){//if is a op
                //System.out.println("girdi 5");

                while (!stack.empty()&&precedence(temp)<=precedence(stack.peek())){
                    postFix+= stack.pop();
                }
                stack.push(temp);
            }

        }
        while (!stack.empty()){
            postFix+=stack.pop();
            //System.out.println("girdi son");
        }
    return postFix;
    }

    private static int precedence(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case 's':
            case 'c':
                return 3;
            case 'a':
                return 4;

        }
    return -1;
    }

    public   static boolean isOp(char op) {
        switch (op) {
            case '+':
            case '-':
            case '*':
            case '/':
            case 's':
            case 'c':
            case 'a':
                return true;


        }
    return false;
    }
    public static double result(String post_fix){
        int i=0;
        Stack<Double> stack=new Stack<>();
        Scanner s=new Scanner(post_fix);

        double num1,num2;
        StringBuilder op=new StringBuilder();
        String temp=new String();
/*
        temp=s.next();
        System.out.println(temp);
        op=new StringBuilder(temp);
        System.out.println("double :"+next_double(op));
*/

/*
        while (s.hasNext()){
                temp=s.next();
                if(temp.charAt(0)=='+'){
                    num1=stack.pop();
                    num2=stack.pop();
                    stack.push(num1+num2);
                }else if(temp.charAt(0)=='-'){
                    num1=stack.pop();
                    num2=stack.pop();
                    stack.push(num1-num2);
                }else if(temp.charAt(0)=='*'){
                    num1=stack.pop();
                    num2=stack.pop();
                    stack.push(num1*num2);
                }else if(temp.charAt(0)=='/'){
                    num1=stack.pop();
                    num2=stack.pop();
                    stack.push(num1/num2);
                }
                StringBuilder temp1=new StringBuilder(temp);
                Double d=next_double(temp1);
                System.out.println(d);
                stack.push(d);
            }

*/



    return 142;
    }




    private static Double next_double(StringBuilder str) {
        String temp=new String();

        String num1=new String();
        String num2=new String();
        double d1,d2;
        int i = 0;
        while(i<str.length()){
            temp+=str.charAt(i);
            ++i;
        }
        //System.out.println("------"+temp +"------");
        i=0;
        StringBuilder t=new StringBuilder(temp);

        boolean flag=false;
        while(i<t.length()){
            if(t.charAt(i)=='.'){
                t.delete(i,i+1);
                t.insert(i,' ');
                flag=true;
            }
        ++i;
        }
        if(flag){
            System.out.println(t);
            String t1=new String(t);
            Scanner s=new Scanner(t1);
            d1=new Double(s.next());
            d2=new Double(s.next());

            return  d1+(d2+1/10);
        }
        return new Double(temp);
    }
}
