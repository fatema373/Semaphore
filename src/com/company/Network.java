package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class BriefFormatter extends Formatter
{
    public BriefFormatter() { super(); }

    @Override
    public String format(final LogRecord record)
    {
        return record.getMessage();
    }
}
public class Network {

    public static ArrayList<Device> runablequeue = new ArrayList<>();
    public static ArrayList<Device> readyqueue = new ArrayList<>();
    public static int N;
    public static int TC;
    public static Logger logger = Logger.getLogger("MyLog");
    public static void main(String[] args) throws IOException, InterruptedException {

        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            String current_path = System.getProperty("user.dir");
            fh = new FileHandler(current_path+'\\'+"Logger.log");

            logger.addHandler(fh);

            BriefFormatter formatter = new BriefFormatter();

            fh.setFormatter(formatter);

            // the following statement is used to log any messages


        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("What is the number of WI-FI Connections?");
        N=new Scanner(System.in).nextInt();
        System.out.println("What is the number of devices Clients want to connect?");
        TC=new Scanner(System.in).nextInt();
        // we will change the list type from String to devices when class device is made
        Router r= new Router();
        for(int i=0;i<TC;i++){
            String the_nameAndType = new Scanner(System.in).nextLine();

            String[] words=the_nameAndType.split("\\s");
            String the_Name=words[0];
            String the_Type=words[1];
            Device d = new Device(the_Name, the_Type , r);
//            r.occupied(d);
            if(i<N){

                runablequeue.add(d);
            }
            else{
                readyqueue.add(d);
            }

        }

        for (Device d : runablequeue) {
            logger.info("(" + d.Name + ") " + "(" + d.Type + ")" + " arrived\n");
        }
        for (Device d : readyqueue) {
            logger.info("(" + d.Name + ") " + "(" + d.Type + ")" + " arrived and waiting\n");
        }
        for (Device a : runablequeue) {
            r.occupied(a);
        }

        for (Device a : readyqueue) {
            r.occupied(a);
        }

    }

}

//class buffer {
//
//    private int size = num_of_acces ;  // the buffer bound
//
//    private int inptr = 0;
//    private int outptr = 0;
//
//
//
//
//
//    public void login(Device d)
//    {
//        System.out.println("Login");
//        d.start();
//    }
//    public Object logout()
//    {
//        Object value;
//        num_devices.Wait();
//        //Release value device
//        value = store[outptr];
//        outptr = (outptr + 1) % size;
//        num_connections.Signal();
//        return value;
//    }
//}
//////////////////////////////////////////////////////////////////
//public class Network {
//
//    public static ArrayList<Device> runablequeue = new ArrayList<>();
//    public static ArrayList<Device> readyqueue = new ArrayList<>();
//    public static int N;
//    public static int TC;
//
//    public static void main(String[] args) throws InterruptedException {
//	// write your code here
//        System.out.println("What is the number of WI-FI Connections?");
//        N=new Scanner(System.in).nextInt();
//        System.out.println("What is the number of devices Clients want to connect?");
//        TC=new Scanner(System.in).nextInt();
//        // we will change the list type from String to devices when class device is made
//        Router r= new Router();
//        for(int i=0;i<TC;i++){
//            String the_nameAndType = new Scanner(System.in).nextLine();
//
//            String[] words=the_nameAndType.split("\\s");
//            String the_Name=words[0];
//            String the_Type=words[1];
//            Device d = new Device(the_Name, the_Type , r);
////            r.occupied(d);
//            if(i<N){
//
//                runablequeue.add(d);
//            }
//            else{
//                readyqueue.add(d);
//            }
//
//        }
//
//        for (Device d : runablequeue)
//        {
//            System.out.println("("+d.Name+") "+"("+d.Type+")"+" arrived");
//       }
//       for (Device a : runablequeue)
//        {
//                r.occupied(a);
//       }
//       for (Device d : readyqueue)
//        {
//                System.out.println("("+d.Name+") "+"("+d.Type+")"+" arrived and waiting");
//       }
//
//       for (Device a : readyqueue)
//        {
//                r.occupied(a);
//       }
//
//    }
//}
