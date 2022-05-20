package com.order.management.system.utils;

import org.springframework.lang.Nullable;

public class CollectionUtils {

	private CollectionUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean isEmpty(@Nullable java.util.Collection<?> collection) {
		return org.springframework.util.CollectionUtils.isEmpty(collection);
	}

	public static boolean isEmpty(@Nullable java.util.Map<?, ?> map) {
		return org.springframework.util.CollectionUtils.isEmpty(map);
	}

	public static boolean isEmpty(@Nullable Object obj) {
		return org.springframework.util.ObjectUtils.isEmpty(obj);
	}

	public static boolean isEmpty(@Nullable Object[] array) {
		return org.springframework.util.ObjectUtils.isEmpty(array);
	}

	public static boolean equals(String value1, String value2) {
		return (value1 != null && value2 != null && value1.equals(value2));
	}

	public static boolean equalsIgnoreCase(String value1, String value2) {
		return (value1 != null && value2 != null && value1.equalsIgnoreCase(value2));
	}

	/*
	 * public static <T> T getFromList(Object listObj, int index) { if (listObj
	 * instanceof java.util.List<?> list) { return (T) list.get(index); } return
	 * null; }
	 */

	private static <T> T getFromList(java.util.List<T> list, int index) {
		if (list != null && !list.isEmpty()) {
			return list.get(index);
		}
		return null;
	}

	public static <T> T getFromList(java.util.List<T> list) {
		return getFromList(list, 0);
	}

}