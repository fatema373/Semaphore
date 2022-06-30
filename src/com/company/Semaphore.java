package com.company;

public class Semaphore {
    protected int value  ;


    protected Semaphore()
    {
        value = 0 ;
    }

    protected Semaphore(int initial)
    {
        this.value = initial ;
    }

    public synchronized void Wait() throws InterruptedException {
        value-- ;
        if (value < 0)
        {
            wait();
        }
    }

    public synchronized void Signal()
    {
        value++ ;
        if (value <= 0) {
            notify();
        }
    }
}
