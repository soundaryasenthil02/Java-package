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
public class CollegeTransportApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numOfStudents = 100;
	int numOfBuses = 2;
	int numOfCoordinators = 40;
	int busCapacity = 20;
	Commute commute = new Commute (numOfStudents, busOfCapacity, numOfCoordinators);
		
	//creates the students, buses, and coordinators

	for (int i = 0; i < numStudents; i++)
	    new Student(i+1, commute);
	for (int i = 0; i < numBuses; i++)
	    new Bus(i+1, commute);
	for (int i = 0; i < numCoordinators; i++)
	    new Coordinator(i+1, commute);
        
    }
}
