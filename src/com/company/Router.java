package com.company;

import java.util.ArrayList;
public class Router {

    int size = Network.N;
    ArrayList<Device>Connections=new ArrayList<>(Network.N);

    Semaphore num_connections = new Semaphore(Network.N);
    Semaphore num_devices = new Semaphore(0);

    public void Multy_Thread()
    {
        for(Device a:Connections) {
            a.start();
        }
    }

    public int  Find (Device d)
    {
        for (int i = 0 ; i < Connections.size() ; i++)
        {
            if (Connections.get(i).equals(d))
            {
                return i;
            }
        }
        return -1;
    }

    public void occupied(Device value) throws InterruptedException {

        num_connections.Wait();
        //add devices
        Connections.add(value);
        Network.logger.info("Connection "+(this.Find(value)+1)+": "+value.Name+"  Occupied\n");
        value.start();
        num_devices.Signal();

    }

    public void release(Device value) throws InterruptedException {
        num_devices.Wait();
        Connections.remove(value);
        num_connections.Signal();
    }
}





//entry section
    //occupied
    //login
    //performs online activity
    //logout
//exit section

    //remainder




