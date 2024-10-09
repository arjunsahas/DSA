package com.arjun.problems.jurgensville;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/** Created by arjuns on 20/5/17. */
public class Jurgensville_V3 {

  public static void main(String[] args) {
    if (args.length <= 1) {
      System.err.println(
          "No inputs provided. Please provide an input .csv file followed by required restaurant items");
      return;
    }
    String fileName = args[0];
    List<String> orderItems = new ArrayList<>();
    for (int i = 1; i < args.length; i++) orderItems.add(args[i]);
    BufferedReader bufferedReader = null;
    Map<String, List<MenuRecord>> menuMap = new HashMap<>();
    try {
      bufferedReader = new BufferedReader(new FileReader(fileName));
      String line = "";
      while ((line = bufferedReader.readLine()) != null) {
        buildRestaurantMap(menuMap, line);
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to read", e);
    }

    Map<String, Result> resultSet = new HashMap();
    for (String restaurantId : menuMap.keySet()) {
      List<MenuRecord> menuRecords = menuMap.get(restaurantId);
      List<String> allItems = getAllItems(menuRecords);
      boolean found = true;
      // check if all items found in restaurant
      for (String orderItem : orderItems) {
        if (allItems.contains(orderItem)) {
          found = found && true;
        } else {
          found = false;
        }
      }
      if (found) {
        buildResults(orderItems, resultSet, menuRecords);
      }
    }

    if (resultSet.size() > 0) {
      List<Result> list = new ArrayList<>(resultSet.values());
      Collections.sort(list, new ResultComparator());
      System.out.println(list.get(0));
    } else {
      System.out.println("Nil");
    }
  }

  private static Map<String, List<MenuRecord>> buildRestaurantMap(
      Map<String, List<MenuRecord>> menuMap, String line) {
    String[] menuLine = line.split(",");
    String restaurantId = menuLine[0].trim();
    String price = menuLine[1].trim();
    String[] dest = new String[menuLine.length - 2];
    System.arraycopy(menuLine, 2, dest, 0, menuLine.length - 2);
    List<String> convert = convert(dest);
    List<MenuRecord> menuRecords = menuMap.get(restaurantId);
    if (menuRecords != null) {
      menuRecords.add(new MenuRecord(restaurantId, new BigDecimal(price), convert));
    } else {
      menuRecords = new ArrayList<>();
      menuRecords.add(new MenuRecord(restaurantId, new BigDecimal(price), convert));
      menuMap.put(restaurantId, menuRecords);
    }
    return menuMap;
  }

  private static void buildResults(
      List<String> orderItems, Map<String, Result> resultSet, List<MenuRecord> menuRecords) {
    for (MenuRecord menuRecord : menuRecords) {
      for (String orderItem : orderItems) {
        if (menuRecord.getItems().contains(orderItem)) {
          String restaurantId = menuRecord.getRestaurantId();
          Result result1 = resultSet.get(restaurantId);
          if (result1 != null) {
            if (!isDuplicates(menuRecord.getItems(), result1.getItems())) {
              Result result =
                  new Result(
                      restaurantId,
                      menuRecord.getPrice().add(result1.getPrice()),
                      menuRecord.getItems());
              resultSet.put(restaurantId, result);
            }
          } else {
            Result result = new Result(restaurantId, menuRecord.getPrice(), menuRecord.getItems());
            resultSet.put(restaurantId, result);
          }
        }
      }
    }
  }

  private static boolean isDuplicates(List<String> items, List<String> items1) {
    Object[] objects = items.toArray();
    Object[] objects1 = items1.toArray();
    return Arrays.equals(objects, objects1);
  }

  private static List<String> getAllItems(List<MenuRecord> menuRecords) {
    List<String> strings = new ArrayList<>();
    for (MenuRecord menuRecord : menuRecords) {
      strings.addAll(menuRecord.getItems());
    }
    return strings;
  }

  private static List<String> convert(final String[] split) {
    for (int i = 0; i < split.length; i++) {
      split[i] = split[i].trim();
    }
    return Arrays.asList(split);
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

  private static class Result {
    private final String id;
    private final BigDecimal price;
    private final List<String> items;

    public Result(final String id, final BigDecimal price, final List<String> items) {
      this.id = id;
      this.price = price;
      this.items = items;
    }

    public String getId() {
      return id;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public List<String> getItems() {
      return items;
    }

    @Override
    public String toString() {
      return "" + id + " " + price;
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
