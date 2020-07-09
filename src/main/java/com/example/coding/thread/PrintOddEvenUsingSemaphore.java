package com.example.coding.thread;

import java.util.concurrent.Semaphore;

public class PrintOddEvenUsingSemaphore {

	public static void main(String[] args) throws InterruptedException {
		Printer print = new Printer(1, 10);
		Thread t1 = new Thread(new EvenThread(print));
		Thread t2 = new Thread(new OddThread(print));
		
		t1.start(); t2.start();
		t1.join(); t2.join();
		System.out.println("Finish");
	}

}
class EvenThread implements Runnable{
	Printer p;
	EvenThread(Printer p1){p = p1;}
	@Override
	public void run(){
		p.printEven();
	}
}
class OddThread implements Runnable{
	Printer p;
	OddThread(Printer p1){p = p1;}
	@Override
	public void run(){
		p.printOdd();
	}
}
class Printer{
	int num, limit;
	Semaphore even = new Semaphore(0);
	Semaphore odd = new Semaphore(1);
	
	Printer(int n, int l){num = n; limit= l;}
	public void printEven(){
		while(num <= limit){
		try {
			even.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num++);
		odd.release();
		}
		if(num >= limit)
			odd.release();
	}
	public void printOdd(){
		while(num < limit){
		try {
			odd.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num++);
		even.release();
		}
		if(num >= limit)
			even.release();
	}
}