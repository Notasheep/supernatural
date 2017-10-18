package logik;

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
			System.out.println(f1.name + ": " + f1.live);
			System.out.println(f2.name + ": " + f2.live);
		} catch (InterruptedException slpintex) {
			System.out.println(slpintex.getMessage());
		}
		}
		System.out.println("The Hunt is Over");
	}
}
