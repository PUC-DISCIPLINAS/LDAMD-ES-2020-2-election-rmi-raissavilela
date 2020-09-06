package server;

import interfaces.Election;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ElectionServer {
	public ElectionServer() {
		try {

			Election c = new ElectionServant();
			Registry registry = LocateRegistry.createRegistry(3003);
			registry.bind("ElectionService", c);
			System.out.println(registry.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		new ElectionServer();

		System.out.println("Servidor Election em execução.");
	}
}