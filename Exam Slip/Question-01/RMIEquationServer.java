import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIEquationServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Registry for RMI
            RMIEquationInterface solver = new RMIEquationImpl();
            Naming.rebind("equationSolver", solver);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}