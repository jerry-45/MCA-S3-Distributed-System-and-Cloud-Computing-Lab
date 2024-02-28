/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

import java.rmi.*;

public interface LibraryInterface extends Remote {
    public String[] getBookInfo() throws RemoteException;
}
