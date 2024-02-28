/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

import java.rmi.*;

public class LibraryClient {
    public static void main(String[] args) throws Exception{
        try{
            LibraryInterface obj = (LibraryInterface) Naming.lookup("rmi://localhost:3099/library");
            
            String[] str = obj.getBookInfo();
            System.out.println(str);
            int size = str.length;
            for(int i = 0; i < size; i++){
                System.out.println(str[i]);
            }
        }
        catch(Exception e)
        {
        }
    }
}
