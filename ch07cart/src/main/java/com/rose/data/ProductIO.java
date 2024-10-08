package com.rose.data;

import com.rose.business.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 *Store product information in a file
 * @author Rose
 */
public class ProductIO {

    /**
     * Get product information
     * @param code The product identifier
     * @param filepath The path of the file where you will search for the information
     * @return @see {@link Product}
     */
    public static Product getProduct(String code, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(
                    new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String productCode = t.nextToken();
                if (code.equalsIgnoreCase(productCode)) {
                    String description = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Gets all the products that are in the data file
     * @param filepath The path of the file where you will search for the information
     * @return @see {@link Product}
     */
    public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);
                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
}
