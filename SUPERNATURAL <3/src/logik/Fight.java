package logik;

import character.Character;

public class Fight extends Thread{
	Character f1; 
	Character f2;
	public Fight(Character a, Character b) {
		f1 = a;
		f2 = b;
		start();
	}
	
	public void run() {
		while(!f1.isDead() && !f2.isDead()){
			try{
			Integer i = (int)(Math.random()*10);
			Integer k = (int)(Math.random()*10);
			f1.looseLive(i);
			f2.looseLive(k);
			sleep(1000);
			System.out.println(f1.getName() + ": " + f1.getLive());
			System.out.println(f2.getName() + ": " + f2.getLive());
		} catch (InterruptedException slpintex) {
			System.out.println(slpintex.getMessage());
		}
		}
		System.out.println("The Hunt is Over");
	}
}
