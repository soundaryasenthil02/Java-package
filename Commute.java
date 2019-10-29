/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegetransportapplication;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soundarya
 */
public class Commute {
	private int numStudents;
	public int busCapacity;
	public int numCoordinators;
	
	public int busGroup = 0;
	private int waitingBusStudents = 0;
	private int waitingCoordStudents = 0;
	
	public Object coord = new Object();
	public Object aGroup = new Object();
	
	public Commute(int numStudents, int busCapacity, int numCoordinators)
	{
		this.numStudents = numStudents;
		this.busCapacity = busCapacity;
		this.numCoordinators= numCoordinators;
	}
	
	public synchronized int getnumStudents() {
		return numStudents;
	}

	public synchronized void decrementnumStudents() {
		numStudents--;
	}
	
	//checks if a group is ready for boarding bus
	public synchronized boolean groupReady()
	{
		if(busGroup >= busCapacity || (waitingBusStudents == 0 && busGroup > 0))
			return true;
		else return false;
	}
	
	
	public void findBus() //for bussed students
	{
		waitingBusStudents++;
		while(true) {
			if(!groupReady())
				synchronized(aGroup)
				{
					waitingBusStudents--;
					busGroup++;
					try { 
						aGroup.wait(); return; }
					catch (InterruptedException e) { 
						System.out.println("Something bad happened.");
					}
				}
		}
	}
	
	public void findCoordinator() //for car students
	{
		waitingCoordStudents++;
		synchronized(coord)
		{
			
			try { 
				coord.wait(); 
				waitingCoordStudents--;
				return; 
			}
			catch (InterruptedException e) { 
				System.out.println("Something bad happened.");
			}
			
		}
		
	}
	
	
	public synchronized void busPickUp() //for bus
	{
			if(groupReady())
				synchronized(aGroup)
				{
					//notify the current group
					aGroup.notifyAll();
					busGroup = 0;
				}
	}
	
	public synchronized void pickUpStudents() //for coordinator
	{
			synchronized(coord)
			{
				coord.notify();
			}
	}

	public synchronized int getWaitingCoordStudents() {
		return waitingCoordStudents;
	}

}
