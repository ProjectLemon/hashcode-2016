import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class IOHelper {
    private static SimulationParameters parameters;

    public static void parseFile(Path file, SimulationParameters parameters) {
        IOHelper.parameters = parameters;
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            readParameterSection(reader, file, parameters);
            readProductInfo(reader, file, parameters);
            readWarehouseInfo(reader, file, parameters);
            readCustomerOrders(reader, file, parameters);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    public static void writeSubmissionFile(String filename, String... lines) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "US-ASCII"))) {
            for (String line: lines) {
                writer.write(line);
            }
        } catch (IOException e) {}
    }

    private static void readParameterSection(BufferedReader reader,
                                             Path file,
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
                                           Path file,
                                           SimulationParameters parameters)
                                            throws IOException {
        int nrOfOrders = Integer.parseInt(reader.readLine());
        parameters.setNrOfCustomerOrders(nrOfOrders);
        List<Order> orders = new LinkedList<>();
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < nrOfOrders; ++i) {
            int row = Integer.parseInt(scanner.next());
            int col = Integer.parseInt(scanner.next());
            int nrOfItemsInOrder = Integer.parseInt(scanner.next());
            List<Integer> types = new ArrayList<>();
            for (int j = 0; j < nrOfItemsInOrder; ++j) {
                types.add(Integer.parseInt(scanner.next()));
            }
            int weight = calculateWeight(types, parameters);
            orders.add(new Order(new Position(col, row), nrOfItemsInOrder, types, weight));
        }
        parameters.setOrders(orders);
    }

    private static int calculateWeight(List<Integer> productTypes, SimulationParameters param) {
        int weight = 0;
        for (Integer item : productTypes) {
            weight += param.getProductWeight().get(item);
        }
        return weight;
    }
}
