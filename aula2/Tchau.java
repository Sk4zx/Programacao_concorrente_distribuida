package aula2;

public class Tchau extends Thread{
	public void run() {
		System.out.println(this.getName() + "	Tchau!");
	}
}
