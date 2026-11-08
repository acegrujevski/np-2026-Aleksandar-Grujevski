package kol1.zad16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MojDDV {
    private List<Bill> bills;

    public MojDDV() {
        this.bills = new ArrayList<>();
    }

    public void add(Bill bill){
        bills.add(bill);
    }

    public void readRecords(InputStream in) throws AmountNotAllowedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        try {


            while ((line = br.readLine()) != null) {
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

                    if (bill.getTotal() > 30000)
                        throw new AmountNotAllowedException(String.format("Receipt with amount %d is not allowed to be scanned", bill.getTotal()));

                    add(bill);
                } catch (AmountNotAllowedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void printTaxReturns(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);

        for (Bill bill : bills)
            pw.println(bill);

        pw.flush();
    }
}
