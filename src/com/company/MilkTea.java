package com.company;

import java.util.Scanner;

public class MilkTea {
    private String milkteaname;
    private Ingredient milkteaingredient;
    public MilkTea(String Milkteaname,Ingredient temp)
    {
        Scanner in=new Scanner(System.in);
        int i;
        i=in.nextInt();
        if(temp instanceof Bubble)
        {
            milkteaingredient=(Bubble)temp;
        }
        else
        {
            milkteaingredient=(Coconut)temp;
        }
        milkteaname="奶茶"+String.valueOf(i);
    }

    public String toString()
    {
        return "该奶茶的名字为"+milkteaname+","+milkteaingredient+"\n";
    }

    public static void main(String[] args)
    {
    }
}
