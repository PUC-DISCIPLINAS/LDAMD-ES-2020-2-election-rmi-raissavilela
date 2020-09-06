package client;

import interfaces.Election;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class ElectionClient extends Thread {
	public static void main(String[] args) {
		String servidor = "rmi://localhost:3003/";
		String nome = "ElectionService";
		try {
			Election c = (Election) Naming.lookup(servidor + nome);
			Client client = new Client("Karol");
			System.out.println("Objeto remoto \'"+ nome + "\' encontrado no servidor.");
			c.candidates();
			c.vote("Henrique", client.getHash());
			
			Client client2 = new Client("Rodrigo");
			c.vote("Roberto", client2.getHash());
			c.result();
			

		} catch (MalformedURLException e) {
			System.out.println("URL \'" + servidor + nome + "\' mal formatada.");
		} catch (RemoteException e) {
			System.out.println("Erro na invocação remota.");
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Objeto remoto \'" + nome + "\' não está disponível.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
