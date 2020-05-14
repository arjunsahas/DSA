package com.arjun.problems.jurgensville;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by arjuns on 20/5/17.
 */
public class Jurgensville_V2 {


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
                String restaurantId = split[0].trim();
                String price = split[1].trim();
                String[] dest = new String[split.length - 2];
                System.arraycopy(split, 2, dest, 0, split.length - 2);
                List<String> convert = convert(dest);
                List<MenuRecord> menuRecords = menuMap.get(restaurantId);
                if (menuRecords != null) {
                    menuRecords.add(new MenuRecord(restaurantId, new BigDecimal(price), convert));
                } else {
                    menuRecords = new ArrayList<>();
                    menuRecords.add(new MenuRecord(restaurantId, new BigDecimal(price), convert));
                    menuMap.put(restaurantId, menuRecords);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }

        Map<String, Result> resultSet = new HashMap();
        for (String restaurantId : menuMap.keySet()) {
            List<MenuRecord> menuRecords = menuMap.get(restaurantId);
            for (String orderItem : orderItems) {
                for (MenuRecord menuRecord : menuRecords) {
                    if (menuRecord.getItems().contains(orderItem)) {
                        String restaurantId1 = menuRecord.getRestaurantId();
                        Result result1 = resultSet.get(restaurantId1);
                        if (result1 != null) {
                            Result result = new Result(restaurantId1, menuRecord.getPrice().add(result1.getPrice()));
                            resultSet.put(restaurantId1, result);
                        } else {
                            Result result = new Result(restaurantId1, menuRecord.getPrice());
                            resultSet.put(restaurantId1, result);
                        }

                    }
                }
            }
        }

        List<Result> list = new ArrayList<>(resultSet.values());
        Collections.sort(list, new ResultComparator());

        System.out.println(list.get(0));
    }

    private static List<String> convert(final String[] split) {
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        return Arrays.asList(split);
    }


    private static class Result {
        private final String id;
        private final BigDecimal price;

        public Result(final String id, final BigDecimal price) {
            this.id = id;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public BigDecimal getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "" + id + ", " + price;
        }
    }

    private static class MenuRecord {
        private final String restaurantId;
        private final BigDecimal price;
        private final List<String> items;

        public MenuRecord(final String restaurantId, final BigDecimal price, final List<String> items) {
            this.restaurantId = restaurantId;
            this.price = price;
            this.items = items;
        }

        public List<String> getItems() {
            return items;
        }

        public BigDecimal getPrice() {
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

    private static class ResultComparator implements Comparator<Result> {
        @Override
        public int compare(final Result o1, final Result o2) {
            if (o1.getPrice().equals(o2.getPrice())) {
                return 0;
            } else if (o1.getPrice().compareTo(o2.getPrice()) < 0) {
                return -1;
            } else return 1;
        }
    }

}
