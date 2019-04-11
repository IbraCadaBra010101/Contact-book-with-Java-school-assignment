package org.addressbook.main;

public class SimpleMain {
    public static void main(String[] arg) {
        try{

            SimpleApplication newcontactbook = new SimpleApplication();
            newcontactbook.start();
        }catch (Exception e){System.err.println("Exception e error! Read the log file for further information!");}
    }
}
