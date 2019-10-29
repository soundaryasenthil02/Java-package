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
public class Coordinator implements Runnable {
	
	private String name;
	private Commute commute; 
	private static long time = System.currentTimeMillis();
	
	public Coordinator (int id, Commute commute)
	{
		setName("Coordinator-" + id);
		this.commute = commute;
		new Thread(this).start();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void msg(String m)
	{
		System.out.println( getName() + ": " + m);
	}
	
	//sleeps a random amount of time within provided range
	private void simulatedWait(int range, int minTime)
	{
		int sleepTime = ((int)(Math.random()*range + minTime));
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			msg("Died  :(");
		}
	}
	
        @Override
	public void run()
	{
		while(commute.getnumStudents() > 0)
		{
			if(commute.getWaitingCoordStudents() > 0)
			{
				msg("Picking up a student");
				simulatedWait(1000, 500);
				commute.pickUpStudents();
			}
			simulatedWait(1000, 500);
		}
		msg("No more students. Finished job.");
	}

}