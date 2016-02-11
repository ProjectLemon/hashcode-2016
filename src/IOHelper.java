import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class IOHelper {

    public static void parseFile(Path file, SimulationParameters parameters) {
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            readParameterSection(reader, parameters);
            readProductInfo(reader, file, parameters);
            readWarehouseInfo(reader, file, parameters);
            readCustomerOrders(reader, parameters);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private static void readParameterSection(BufferedReader reader,
                                             SimulationParameters parameters)
                                                throws IOException {
        String line = null;
        line = reader.readLine();
        parameters.setNrOfRows(Integer.parseInt(line));
        line = reader.readLine();
        parameters.setNrOfCols(Integer.parseInt(line));
        line = reader.readLine();
        parameters.setNrOfDrones(Integer.parseInt(line));
        line = reader.readLine();
        parameters.setTotalSimulationTime(Integer.parseInt(line));
        line = reader.readLine();
        parameters.setMaxLoadDrones(Integer.parseInt(line));
    }

    private static void readProductInfo(BufferedReader reader,
                                        Path file,
                                        SimulationParameters parameters)
                                        throws IOException {
        String line = null;
        line = reader.readLine();
        parameters.setNrOfProductTypes(Integer.parseInt(line));
        HashMap<Integer, Integer> orders = new HashMap<>();
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < Integer.parseInt(line); ++i) {
            orders.put(i, Integer.parseInt(scanner.next()));
        }
        parameters.setProductWeight(orders);
    }

    private static void readWarehouseInfo(BufferedReader reader,
                                          Path file,
                                          SimulationParameters parameters)
                                            throws IOException {
        int nrOfWarehouses = Integer.parseInt(reader.readLine());
        parameters.setNrOfWarehouses(nrOfWarehouses);
        HashMap<Position, Warehouse> warehouseHashMap = new HashMap<>();
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < nrOfWarehouses; ++i) {
            int rows = Integer.parseInt(scanner.next());
            int cols = Integer.parseInt(scanner.next());
            Position p = new Position(cols, rows);
            HashMap<Integer, Integer> prodCount = new HashMap<>();
            for (int j = 0; j < parameters.getNrOfProductTypes(); ++j) {
                prodCount.put(j, Integer.parseInt(scanner.next()) );
            }
            warehouseHashMap.put(p, new Warehouse(p, prodCount));
        }
        parameters.setWarehouses(warehouseHashMap);
    }

    private static void readCustomerOrders(BufferedReader reader,
                                           SimulationParameters parameters)
                                            throws IOException {
        
    }
}
