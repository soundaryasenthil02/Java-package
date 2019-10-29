/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegetransportapplication;

/**
 *
 * @author soundarya
 */
public class Bus implements Runnable {
	private String name;
	private Commute commute; 
	
	
	public Bus (int id, Commute commute)
	{
		setName("Bus-" + id);
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
		System.out.println(getName() + ": " + m);
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
	
	public void run()
	{
		while(commute.getnumStudents() > 0) //while there are still students running
		{
			if(commute.groupReady())
			{
				msg("Loading bus");
				try {
					Thread.sleep(simulatedBusTime());
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				commute.busPickUp();
				msg("Returning for more students. " + commute.getnumStudents() + " students left");
				try {
					Thread.sleep((int)(Math.random()*2000 +1000));
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}

		}
		msg("No more students to bus. Finished job. Students left:" + commute.getnumStudents() + " . ");
		return;
	}
}
