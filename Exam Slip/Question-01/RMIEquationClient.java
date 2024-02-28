import java.rmi.Naming;

public class RMIEquationClient {
    public static void main(String[] args) {
        try {
            RMIEquationInterface solver = (RMIEquationInterface) Naming.lookup("rmi://localhost/equationSolver");
            double a = 1;
            double b = 5;
            double c = 6;
            double[] roots = solver.solveQuadratic(a, b, c);

            for (double root : roots) {
                System.out.println("Root: " + root);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}