package server;

import interfaces.Election;

import java.util.HashMap;
import java.util.Map;

public class ElectionServant extends java.rmi.server.UnicastRemoteObject
		implements Election {

	private static final long serialVersionUID = 1L;
	Map<String, Integer> Candidates = new HashMap<String, Integer>();
	Map<String, Boolean> codeClient = new HashMap<String, Boolean>();

	public ElectionServant() throws java.rmi.RemoteException {
		super();
	}

	public void candidates() throws java.rmi.RemoteException {
		Candidates.put("Henrique", 0);
		Candidates.put("Roberto", 0);
		Candidates.put("Ludmila", 0);
		for (Map.Entry<String, Integer> name : Candidates.entrySet()) {
			System.out.println(name.getKey());
			System.out.println(name);
		}
	}
	
	@Override
	public synchronized Boolean vote(String candidate, String hash)
			throws java.rmi.RemoteException {
		if (!codeClient.containsKey(hash)) {
			if (Candidates.containsKey(candidate)) {
				Integer oldValue = Candidates.get(candidate);
				codeClient.put(candidate, true);
				Candidates.put(candidate, oldValue + 1);
			} else
				System.err.println("Candidato não existe");
		} else {
			System.out.println("O usuário pode realizar o voto somente uma vez");
			return false;
		}
		return true;
	}

	@Override
	public synchronized void result() throws java.rmi.RemoteException {
		System.out.println(Candidates);
	}
}