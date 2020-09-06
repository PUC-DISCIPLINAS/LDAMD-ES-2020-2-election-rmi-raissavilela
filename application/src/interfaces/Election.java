package interfaces;

import java.rmi.*;

public interface Election extends Remote{
	void candidates() throws RemoteException;
	void result() throws RemoteException;
	Boolean vote(String candidate, String hash) throws RemoteException;
}
