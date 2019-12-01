package com.company;

import java.util.Calendar;

public abstract class Ingredient {
    protected String name;
    protected Calendar mdate= Calendar.getInstance();
    protected int shelflife;
    Ingredient(){}
    public Ingredient(String Name,int year,int month,int day,int Shelflife)
    {
        name=Name;
        shelflife=Shelflife;
        mdate.set(year,month-1,day);
    }
    public String getName()
    {
        return name;
    }
    public void setName(String Name)
    {
        name=Name;
    }
    public int getShelflife()
    {
        return shelflife;
    }
    public void setShelflife(int Shelflife)
    {
        shelflife=Shelflife;
    }
    public String toString()
    {
        return "该奶茶所需配料为 "+name+" ,生产日期为 "+mdate.get(Calendar.YEAR)+"."+(mdate.get(Calendar.MONTH)+1)+"."+mdate.get(Calendar.DATE)+" ,保质期为 "+shelflife+"天";
    }
    public boolean CheckShelflife()
    {
        Calendar now=Calendar.getInstance();
        Calendar past=Calendar.getInstance();
        past.set(mdate.get(Calendar.YEAR),mdate.get(Calendar.MONTH),mdate.get(Calendar.DATE));
        past.add(Calendar.DATE,shelflife);
        if(past.before(now)) return false;
        else return true;
    }
    public static void main(String[] args)
    {

    }
}
