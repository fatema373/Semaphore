package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Device extends Thread{

    String Name,Type;
    Router router;

    public Device (String Name , String Type , Router r )
    {
        this.Name = Name;
        this.Type = Type;
        this.router=r;
    }



    public void Login ()
    {
        int i = router.Find(this);
        if (i==-1);
        else {

            Network.logger.info("Connection " + (i+1) + ": " + Name + " Login\n");
        }
    }

    public void perform ()
    {
        int i = router.Find(this);
        if (i==-1);
        else
            Network.logger.info("Connection "+(i+1)+": "+Name+"  performs online activity\n");
    }

    public void Logout() throws InterruptedException {
        int i = router.Find(this);
        if (i==-1);
        else {
            Network.logger.info("Connection " + (i+1) + ": " + Name + "  Logout\n");
            router.release(this);
        }
    }
    @Override
    public void run()
    {
        this.Login();
        this.perform();
        try {
            this.Logout();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


