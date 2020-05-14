package com.arjun.problems.jurgensville;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by arjuns on 20/5/17.
 */
public class Jurgensville_V1 {

    private static MenuComparator menuComparator = new MenuComparator();

    public static void main(String[] args) {
        String fileName = args[0];
        List<String> orderItems = new ArrayList<>();
        for (int i = 1; i < args.length; i++)
            orderItems.add(args[i]);
        BufferedReader bufferedReader = null;
        Map<String, List<MenuRecord>> menuMap = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                String restaurantId = split[0];
                String price = split[1];
                String[] dest = new String[split.length - 2];
                System.arraycopy(split, 2, dest, 0, split.length - 2);
                List<String> convert = convert(dest);
                for (String menu : convert) {
                    List<MenuRecord> menuRecords = menuMap.get(menu);
                    if (menuRecords != null) {
                        menuRecords.add(new MenuRecord(restaurantId, price, convert));
                        Collections.sort(menuRecords, menuComparator);
                    } else {
                        menuRecords = new ArrayList<>();
                        menuRecords.add(new MenuRecord(restaurantId, price, convert));
                        menuMap.put(menu, menuRecords);
                        Collections.sort(menuRecords, menuComparator);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }

        List<MenuRecord> resultSet = new ArrayList<>();
        for (String orderItem : orderItems) {
            List<MenuRecord> menuRecords = menuMap.get(orderItem);
            if (menuRecords != null) {
                MenuRecord menuRecord = menuRecords.get(0);
                resultSet.add(menuRecord);
            }
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

    private static class MenuComparator implements Comparator<MenuRecord> {
        @Override
        public int compare(final MenuRecord o1, final MenuRecord o2) {
            BigDecimal o1_float = new BigDecimal(o1.getPrice().trim());
            BigDecimal o2_float = new BigDecimal(o2.getPrice().trim());
            if (o1_float.equals(o2_float)) {
                return 0;
            } else if (o1_float.compareTo(o2_float) < 0) {
                return -1;
            } else return 1;
        }
    }
}
