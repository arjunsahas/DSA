package com.arjun.problems.jurgensville;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arjuns on 20/5/17.
 */
public class Jurgensville {

    public static void main(String[] args) {
        String fileName = args[0];
        List<String> orderItems = new ArrayList<>();
        for (int i = 1; i < args.length; i++)
            orderItems.add(args[i]);
        BufferedReader bufferedReader = null;
        List<MenuRecord> menuRecords = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                String restaurantId = split[0];
                String price = split[1];
                String[] dest = new String[split.length - 2];
                System.arraycopy(split, 2, dest, 0, split.length - 2);
                menuRecords.add(new MenuRecord(restaurantId, price, convert(dest)));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }

        List<MenuRecord> resultSet = new ArrayList<>();
        for (String orderItem : orderItems) {
            for (MenuRecord menuRecord : menuRecords) {
                if (menuRecord.getItems().contains(orderItem)) {
                    resultSet.add(menuRecord);
                }
            }
        }

        Iterator<MenuRecord> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            MenuRecord next = iterator.next();

        }

        System.out.println(resultSet);
    }

    private static List<String> convert(final String[] split) {
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        return Arrays.asList(split);
    }

    private static class MenuRecord {
        private final String restaurantId;
        private final String price;
        private final List<String> items;

        public MenuRecord(final String restaurantId, final String price, final List<String> items) {
            this.restaurantId = restaurantId;
            this.price = price;
            this.items = items;
        }

        public List<String> getItems() {
            return items;
        }

        public String getPrice() {
            return price;
        }

        public String getRestaurantId() {
            return restaurantId;
        }

        @Override
        public String toString() {
            return "Restaurant Id: " + restaurantId + ", Price: " + price + ", Items: " + items;
        }
    }
}
