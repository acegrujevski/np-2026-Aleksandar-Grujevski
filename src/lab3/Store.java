package lab3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Store {

    private List<Product> products;
    private int invalid;

    public Store() {
        this.products = new ArrayList<>();
        this.invalid = 0;
    }

    public int readProducts(InputStream is) throws IOException {
        int counter = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;

            while ((line = br.readLine()) != null){
                if (line.isBlank()) {
                    continue;
                }
                try{
                products.add(Product.createProduct(line));
                counter++;
                } catch (InvalidProductException e) {
                    invalid++;
                }
            }

        return counter;
    }

    public int getInvalidLines() {
        return invalid;
    }

    public void printSorted(OutputStream os) {
        PrintWriter pw = new PrintWriter(os);

        if (products.isEmpty()){
            pw.println("No products");
            pw.flush();
            return;
        }

        List<Product> sortedProducts = new ArrayList<>(products);

        Collections.sort(sortedProducts);

        sortedProducts.forEach(p -> pw.println(p.toString()));

        pw.flush();

    }

    public void printByCategory(OutputStream os, String category) throws CategoryNotFoundException {

        PrintWriter pw =new PrintWriter(os);

        List<Product> sortedProducts = new ArrayList<>(products);

        sortedProducts = sortedProducts.stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toList());

        if (sortedProducts.isEmpty())
            throw new CategoryNotFoundException(category);

        if (products.isEmpty()){
            pw.println("No products");
            pw.flush();
            return;
        }

        Comparator <Product>comparator = Comparator.comparing(Product::getName,String.CASE_INSENSITIVE_ORDER).thenComparing(Comparator.comparing(Product::getFinalPrice).reversed()).thenComparing(Comparator.comparing(Product::getId));

        Collections.sort(sortedProducts,comparator);

        sortedProducts.forEach(p -> pw.println(p.toString()));

        pw.flush();
    }

    public void printStatistics(OutputStream os) {
        PrintWriter pw = new PrintWriter(os);

        if (products.isEmpty()){
            pw.println("No products");
            pw.flush();
            return;
        }

        int count = products.size();
        int countP = (int) products.stream().filter(p -> p instanceof PhysicalProduct).count();
        int countD = (int) products.stream().filter(p -> p instanceof DigitalProduct).count();

        Product cheapest = Collections.min(products);
        Product mostExpensive = Collections.max(products);
        double avg = products.stream().mapToDouble(Product::getFinalPrice).average().orElse(0.0);

        pw.println(String.format("Total: %d (physical: %d, digital: %d)",count,countP,countD));
        pw.println(String.format("Cheapest: %f",cheapest.getFinalPrice()));
        pw.println(String.format("Most expensive: %f",mostExpensive.getFinalPrice()));
        pw.println(String.format("Average price: %.2f",avg));

        pw.flush();
    }
}
