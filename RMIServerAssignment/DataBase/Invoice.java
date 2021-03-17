package DataBase;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Invoice extends Remote{
	public void startInvoiceApp(int i,int invNo)throws RemoteException;
}