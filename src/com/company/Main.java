package com.company;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;



public class Main {

    public static void main(String[] args) {
/*        Stack<Integer> stack=new  Stack<Integer>();
        stack.push(5);

      //  System.out.println(stack.peek());
        stack.push(4);
    //    System.out.println(stack.peek());
        stack.push(8);
  //      System.out.println(stack.peek());
        stack.push(10);
//        System.out.println(stack.peek());
        stack.push(12);
   //
        //      System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
*/

        try {

            /**
             * to calculate size of row and colums*/

          
           File f=new File(String.valueOf(args[0]));
            FileReader fin=new FileReader(f);

           int i=0;
           int j=0;
           int  k= fin.read();
            while(k!=-1){
                k=  fin.read();
                if((char)k=='\n')
                    ++i;
                else
                    ++j;
            }
            int row=0;
            int col=0;
            row=i+1;
            col=(j+1)/(2*i+2);
            //System.out.print("Satır sayısı:"+row);
            //System.out.print("Sutun sayısı:"+col);

            fin.close();

            /**
             * to read a file
             * */
            f=new File("C:\\Users\\erkan\\IdeaProjects\\HW3\\src\\com\\company\\test_file_1.txt");
            fin=new FileReader(f);

            point [][] points=new point[col][row];

            i=0;
            j=0;
            k= fin.read();

            while(k!=-1){
                if((char)k=='\n'){
                    j++;
                    i=0;
                }
                if((char)k=='1'){
                    points[i][j]=new point(true,i,j);
                    ++i;

                }else if((char)k=='0'){
                    points[i][j]=new point(false,i,j);
                  ++i;
                }
                k=  fin.read();
            }
            fin.close();


            Stack<point> stack=new Stack<>();


            /**
             * genişlik öncelikli
             * */
            int counter=0;
            int hold_i,hold_j;
            point temp=new point(false,0,0);
            for(i=0;i<col;++i){
                for(j=0;j<row;j++){
                    if(points[i][j].isOne()==true){
                        //System.out.println("-------i ve j "+i+" "+j);

                        hold_i=i;
                        hold_j=j;
                        do{
                            //System.out.println("stak size:"+stack.get_size());

                            if(stack.get_size()>0)
                                temp=stack.peek();

                            if(points[i][j].isOne()){
                                stack.push(points[i][j]);
                                //System.out.println("stak size:"+stack.get_size());
                                //System.out.println("eklediğim nokta"+points[i][j].getX()+" "+points[i][j].getY());
                                points[i][j].setValue(false);

                                //System.out.println(0);
                            }else
                            if(col>temp.getX()+1&&points[temp.getX()+1][temp.getY()].isOne()){//
                                i=i+1;
                                //System.out.println(1);
                            }else
                            if(temp.getX()-1>=0&&points[temp.getX()-1][temp.getY()].isOne()){
                                i=i-1;
                                //System.out.println(2);
                            }else
                            if(row>temp.getY()+1&&points[temp.getX()][temp.getY()+1].isOne()){//
                                j=j+1;
                                //System.out.println(3);
                            }else
                            if(temp.getY()-1>=0&&points[temp.getX()][temp.getY()-1].isOne()){
                                j=j-1;
                                //System.out.println(4);

                            }else{
                                //System.out.println(5);
                                //System.out.println("stak size:"+stack.get_size());
                                stack.pop();
                                if(stack.get_size()>0){
                                    i=stack.peek().getX();
                                    j=stack.peek().getY();
                                }else{
                                    counter++;
                                    //System.out.println("-------------------------------------------------------------------------");
                                }
                                //System.out.println("stak size:"+stack.get_size());
                            }
                        }while (!stack.empty());

                        i=hold_i;
                        j=hold_j;
                    }
                }

            }
            System.out.println("ada sayısı :"+counter);
            System.out.println("----------------------------------------------------------------------------------");
            /////////////////////////////////////////////////////////////////////////////////////////////////////////

            f=new File("C:\\Users\\erkan\\IdeaProjects\\HW3\\src\\com\\company\\test_file_2.txt");
            fin=new FileReader(f);
            k= fin.read();



            StringBuilder vars_text=new StringBuilder();
            StringBuilder pri_fix=new StringBuilder();
            counter=0;
            while(k!='('){
                vars_text.append((char)k);
                if(k=='\n'){
                    counter++;
                }
                k= fin.read();
            }
            counter--;//insert the last new line element
            while(k!=-1){
                pri_fix.append((char)k);
                k= fin.read();
            }
            vars_text.delete(vars_text.length()-3, vars_text.length());
            fin.close();
            System.out.println(vars_text);
            System.out.println("-----------\n"+pri_fix);
            System.out.println("var sayısı"+(counter));
            Var[] vars=new Var[counter];
            for(i=0;i<counter;++i)vars[i]=new Var();
            i=0;
            j=0;
            StringBuilder temp_stribg_bulder=new StringBuilder();
            String temp_string;
            while(i<vars_text.length()){
                //System.out.println("i:"+i+"  j:"+j);
                while(i<vars_text.length()&&vars_text.charAt(i)!='='){
                    //System.out.println("i:"+i+"  j:"+j+"size:"+vars.length);

                    vars[j].setC(vars_text.charAt(i));
                    ++i;
                }
                    ++i;
                while(i<vars_text.length()&&vars_text.charAt(i)!='\n'){
                     temp_stribg_bulder.append(vars_text.charAt(i));
                    ++i;
                }
                     temp_string=temp_stribg_bulder.toString();
                    temp_stribg_bulder.delete(0,temp_stribg_bulder.length());
                    //System.out.println("****"+temp_string);
                    //System.out.println("---"+new Double(temp_string)+"----");
                    vars[j].setValue(new Double(temp_string));
                    ++j;
            }
            /**
             * deneme blogu*/
            for(i=0;i<vars.length;++i){
                System.out.println("karakter:"+vars[i].getC()+"  degeri:"+vars[i].getValue());
            }

            counter=0;
            i=0;
            System.out.println(pri_fix);


            /**
             * i enter the values to prifix fix expresion
             * importand
             * */
            /*
            for(i=0;i<pri_fix.length();++i){
                if(Var.isHere(pri_fix.charAt(i),vars)){
                    //System.out.println("--------------------------"+Var.whatValue(pri_fix.charAt(i),vars));
                    temp_string=String.valueOf(Var.whatValue(pri_fix.charAt(i),vars));
                    //System.out.println("--------------------------"+temp_string);
                    //System.out.println("--------------------------"+Var.whatValue(pri_fix.charAt(i),vars));
                    pri_fix.insert(i,Var.whatValue(pri_fix.charAt(i),vars));
                    pri_fix.delete(i+temp_string.length(),i+temp_string.length()+1);
                    i+=temp_string.length();
                }
            }*/
            System.out.println(pri_fix);

            for(i=0;i<pri_fix.length();++i){
                if(pri_fix.charAt(i)=='s'||pri_fix.charAt(i)=='c'||pri_fix.charAt(i)=='a'){

                    pri_fix.delete(i+1,i+3);
                }
            }
            System.out.println(pri_fix);


            String infix=new String(pri_fix);

            String post_fix="";
            Postfix_eval pe=new Postfix_eval();
            post_fix=pe.convert(infix);
            System.out.println("post fix hali:"+post_fix);
            StringBuilder pf=new StringBuilder(post_fix);
            i=0;
            while(i+1<pf.length()){
                if(Character.isLetter(pf.charAt(i))){
                    pf.insert(i+1,' ');
                    i=i+2;
                }else if(Character.isDigit(pf.charAt(i))&&Postfix_eval.isOp(pf.charAt(i+1))){
                    pf.insert(i+1,' ');
                    i=i+2;
                }else if(Postfix_eval.isOp(pf.charAt(i))){
                    pf.insert(i+1,' ');
                    i=i+2;
                }else{
                    ++i;
                }

            }


            System.out.println(pf);

            for(i=0;i<pf.length();++i){
                if(Var.isHere(pf.charAt(i),vars)){
                    //System.out.println("--------------------------"+Var.whatValue(pri_fix.charAt(i),vars));
                    temp_string=String.valueOf(Var.whatValue(pf.charAt(i),vars));
                    //System.out.println("--------------------------"+temp_string);
                    //System.out.println("--------------------------"+Var.whatValue(pri_fix.charAt(i),vars));
                    pf.insert(i,Var.whatValue(pf.charAt(i),vars));
                    pf.delete(i+temp_string.length(),i+temp_string.length()+1);
                    i+=temp_string.length();
                }
            }

            //System.out.println(pf);
            String temp_post_fix=new String(pf);
            System.out.println(Postfix_eval.result(temp_post_fix));








        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
