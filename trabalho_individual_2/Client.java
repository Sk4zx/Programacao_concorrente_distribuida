package trabalho_individual_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String IP = "10.130.129.103";
    private static final int Port = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(IP, Port)) {
            System.out.println("Conectado ao servidor: " + IP + " na porta: " + Port);


            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String mensagem = "MjAyMQ==";
            out.println(mensagem);


            String resposta = in.readLine();
            System.out.println(resposta);


            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
