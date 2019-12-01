package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class TeaShop implements Shop {
    ArrayList<Bubble> BubbleHouse = new ArrayList<Bubble>();
    ArrayList<Coconut> CoconutHouse = new ArrayList<Coconut>();
    private void Add(Bubble bubble)
    {
        System.out.println("所添加的配料为珍珠");
        BubbleHouse.add(bubble);
    }
    private void Add(Coconut coconut)
    {
        System.out.println("所添加的配料为椰果");
        CoconutHouse.add(coconut);
    }
    public void AddIngredient(Ingredient myingredient)
    {
        if(myingredient instanceof Bubble)
        {
            Add((Bubble)myingredient);
        }
        else
        {
            Add((Coconut)myingredient);
        }
    }
    public boolean Check(String IngredientName)
    {
        boolean flag=true;
        if(IngredientName=="Bubble")
        {
            try{
                OutIngredient(IngredientName);
            }catch (SoldOutException e)
            {
                e.PrintMessage();
                flag=false;
            }catch (Exception e)
            {
                flag=false;
            }finally {
            }
        }
        if(IngredientName=="Coconut")
        {
            try{
                OutIngredient(IngredientName);
            }catch (SoldOutException e)
            {
                e.PrintMessage();
                flag=false;
            }catch (Exception e)
            {
                flag=false;
            }finally {
            }
        }
        return flag;
    }
    public void OutIngredient(String IngredientName)throws Exception
    {
        int i;
        if(IngredientName=="Bubble")
        {
            Bubble temp;
            for(i=0;i<BubbleHouse.size();i++)
            {
                temp=BubbleHouse.get(BubbleHouse.size()-i-1);
                if(temp.CheckShelflife())
                {
                    break;
                }
                else
                {
                    BubbleHouse.remove(BubbleHouse.size()-i-1);
                    i--;
                }
            }
            if(BubbleHouse.size()==0)
            {
                throw new SoldOutException("本店珍珠配料已售罄");
            }
        }
        if(IngredientName=="Coconut")
        {
            Coconut temp;
            for(i=0;i<CoconutHouse.size();i++)
            {
                temp=CoconutHouse.get(CoconutHouse.size()-i-1);
                if(temp.CheckShelflife())
                {
                    break;
                }
                else
                {
                    CoconutHouse.remove(CoconutHouse.size()-i-1);
                    i--;
                }
            }
            if(CoconutHouse.size()==0)
            {
                throw new SoldOutException("本店椰果配料已售罄");
            }
        }
    }
    public void SoldMilktea(String Milkteaname,String Name)
    {
        int k=0;
        if(Name=="Bubble")
        {
            Bubble temp=null;
            if(Check(Name))
            {
                temp=BubbleHouse.get(BubbleHouse.size()-1);
                BubbleHouse.remove(BubbleHouse.size()-1);
                MilkTea milkTea=new MilkTea(Milkteaname,temp);
                System.out.print(milkTea.toString());
            }
        }
        if(Name=="Coconut")
        {
            Coconut temp=null;
            if(Check(Name))
            {
                temp=CoconutHouse.get(CoconutHouse.size()-1);
                CoconutHouse.remove(CoconutHouse.size()-1);
                MilkTea milkTea=new MilkTea(Milkteaname,temp);
                System.out.print(milkTea.toString());
            }
        }
    }
    public static void main(String[]args)
    {
    }
}
