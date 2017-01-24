package com.arjun.threads.TreeMap;

import java.util.Map;

public class Run {
	public static void main(String[] args) {
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("Arjun", "Arjun");
		treeMap.put("Bharat", "Bharat");
		treeMap.put("Divya", "Divya");

		for (String string : treeMap.keySet()) {
			System.out.println(string);
		}
	}
}
