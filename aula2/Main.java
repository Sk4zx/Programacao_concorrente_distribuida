package Programacao_concorrente_distribuida.aula2;

public class Main {
	public static void main (String[] args) throws InterruptedException {
		System.out.println("Hello, World!");
		
		Ola ola = new Ola();
		Ola ola1 = new Ola();
		Ola ola2 = new Ola();

		Tchau tchau = new Tchau();
		Tchau tchau1 = new Tchau();
		Tchau tchau2 = new Tchau();
		Tchau tchau3 = new Tchau();
		
		ola.start();
		ola1.start();
		ola2.start();
		tchau.start();
		tchau1.start();
		tchau2.start();
		tchau3.start();

        ola.join();
		ola2.join();
		
		tchau.join();
		tchau1.join();
		tchau2.join();
		tchau3.join();
		
		System.out.println("Acabou a main!");
		
	}
}
