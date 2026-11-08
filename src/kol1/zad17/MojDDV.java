package kol1.zad17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MojDDV {

    private List<Bill> bills = new ArrayList<>();

    public MojDDV() {
        bills = new ArrayList<>();
    }

    public void add(Bill bill){
        bills.add(bill);
    }

    public void readRecords(InputStream in) throws IOException, AmountNotAllowedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        try {
            String line;
            while ((line = br.readLine()) != null){
                try {
                    String[] parts = line.trim().split("\\s+");

                    int id = Integer.parseInt(parts[0]);

                    List<Article> articles = new ArrayList<>();

                    for (int i = 1; i < parts.length; i += 2) {
                        int price = Integer.parseInt(parts[i]);
                        Tax_Type type = Tax_Type.valueOf(parts[i + 1]);

                        articles.add(new Article(price, type));
                    }

                    Bill bill = new Bill(id, articles);

                    if (bill.getTotalPrice() > 30000)
                        throw new AmountNotAllowedException(String.format("Receipt with amount %d is not allowed to be scanned", bill.getTotalPrice()));

                    add(bill);
                }catch (AmountNotAllowedException e){
                    System.out.println(e.getMessage());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void printTaxReturns(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);

        bills.forEach(b -> pw.println(b.toString()));

        pw.flush();
    }

    public void printStatistics(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);

        double min = bills.stream().mapToDouble(Bill::getTotalReturn).min().orElse(0.0);
        double max = bills.stream().mapToDouble(Bill::getTotalReturn).max().orElse(0.0);
        double sum = bills.stream().mapToDouble(Bill::getTotalReturn).sum();
        int count = bills.size();
        double avg = bills.stream().mapToDouble(Bill::getTotalReturn).average().orElse(0.0);

        pw.println(String.format("min:\t%-5.3f",min));
        pw.println(String.format("max:\t%-5.3f",max));
        pw.println(String.format("sum:\t%-5.3f",sum));
        pw.println(String.format("count:\t%-5d",count));
        pw.println(String.format("avg:\t%-5.3f",avg));

        pw.flush();
    }
}
