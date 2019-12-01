package com.company;

import java.util.Calendar;
import java.util.Scanner;

public class Bubble extends Ingredient{
    Bubble(String Name,int year,int month,int day,int Shelflifeint)
    {
        super("Bubble",year,month,day,7);
    }
    public String toString()
    {
        return "该奶茶所需配料为 "+super.name+" ,生产日期为 "+mdate.get(Calendar.YEAR)+"."+mdate.get(Calendar.MONTH)+"."+mdate.get(Calendar.DATE)+" ,保质期为 "+shelflife+"天";
    }

    public static void main(String[] args)
    {
    }
}
