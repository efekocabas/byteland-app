package com.sony.assignment;

import com.sony.assignment.unification.CaseHandler;

/**
 * App for all Bytelanders' happiness!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Byteland Unification App!");

        CaseHandler caseHandler = new CaseHandler();
        caseHandler.handle();
    }
}
