package com.company;

import java.security.PublicKey;

public class SoldOutException extends Exception{
    private String ErrorMessage;
    SoldOutException(String errormessage)
    {
        ErrorMessage=errormessage;
    }
    public void PrintMessage()
    {
        System.out.print(ErrorMessage);
    }
    public static void main(String[] args)
    {
    }
}
