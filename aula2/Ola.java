package aula2;

public class Ola extends Thread {
	public void run() {
		System.out.println(this.getName() + "	Ola!");
	}
}
