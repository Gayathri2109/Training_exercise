package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {

	public String getServer() throws RemoteException;
}
