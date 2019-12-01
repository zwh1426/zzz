package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a,b,c;
        a=in.nextInt();
        b=in.nextInt();
        c=in.nextInt();
        Ingredient myingredient1;
        Ingredient myingredient2;
        myingredient1=new Bubble("Bubble",a,b,c,7);
        myingredient2=new Coconut("Coconut",a,b,c,5);
        int x,y,z;
        x=in.nextInt();
        y=in.nextInt();
        z=in.nextInt();
        Bubble bubble=new Bubble("Bubble",x,y,z,7);
        System.out.print(bubble.toString());
        int o,p,q;
        o=in.nextInt();
        p=in.nextInt();
        q=in.nextInt();
        Coconut coconut=new Coconut("Coconut",o,p,q,5);
        System.out.print(coconut.toString());
        MilkTea milkTea1=new MilkTea("Bubble",myingredient1);
        System.out.print(milkTea1.toString());
        MilkTea milkTea2=new MilkTea("Coconut",myingredient2);
        System.out.print(milkTea2.toString());

        TeaShop WestTwo=new TeaShop();
        WestTwo.AddIngredient(bubble);
        WestTwo.AddIngredient(coconut);

        WestTwo.SoldMilktea("珍珠奶茶1","Bubble");
        WestTwo.SoldMilktea("椰果奶茶1","Coconut");
    }
}
