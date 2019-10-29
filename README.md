# Java-package
This package depicts a scenario where students arrive at college to attend an event. The event is held at the Asssembly Hall. The students can come to the college via bus or car. If the student uses the bus, the student has to wait in the bus stop till the bus arrives, wait in the bus until bus capacity is full and then reach the college, from where student goes to the Hall. If the student travels by car, he/she reaches the college and is paired up one of the three coordinators available, who help the students to reached the Assembly hall. 

The package is built with three thread classes namely - student, bus and coordinator. 
Other specifications include :
  1. The students who travel via bus and car are chosen at random by random fuction. If value is less than 0.5, the person travels by bus else by car.
  2. There are two buses that commute back and forth. The student in signalled to indicate that the bus has arrived at the bus stop. It is put under wait and notified when the bus capacity is filled.
  3. The students who arrive by car are paired up with coordinators. Each coordinator can handle only one student at a time. Once one coordinator knows that no student is left to be handled, it sends a message to all the coordinators.
