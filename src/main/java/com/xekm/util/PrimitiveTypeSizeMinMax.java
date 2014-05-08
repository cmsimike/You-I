package com.xekm.util;

public class PrimitiveTypeSizeMinMax {

  public static void main(String[] args) {
    // Boolean does not have Boolean.SIZE, Boolean.MIN_VALUE, or Boolean.MAX_VALUE
//    displaySizeMinAndMax(Byte.TYPE, Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);
//    displaySizeMinAndMax(Short.TYPE, Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);
//    displaySizeMinAndMax(Character.TYPE, Character.SIZE, (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
//    displaySizeMinAndMax(Integer.TYPE, Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    displaySizeMinAndMax(Long.TYPE, Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE);
//    displaySizeMinAndMaxF(Float.TYPE, Float.SIZE, Float.MIN_VALUE, Float.MAX_VALUE);
//    displaySizeMinAndMax(Double.TYPE, Double.SIZE, Double.MIN_VALUE, Double.MAX_VALUE);

    System.err.println(Long.MAX_VALUE);
    System.err.printf("%.0f\n", getf(Long.MAX_VALUE));

    System.err.println(Long.MIN_VALUE);
    System.err.printf("%.0f\n", getf(Long.MIN_VALUE));

    /*
    9223372036854775807
    9223372036854776000
    -9223372036854775808
    -9223372036854776000
     */
  }

  private static float getf(long l) {
    return l;
  }

  public static void displaySizeMinAndMax(Class<?> type, int size, Number min, Number max) {
    System.out.printf("type:%-6s size:%-2s min:%-20s max:%s\n", type, size, min, max);
  }

  public static void displaySizeMinAndMaxF(Class<?> type, int size, Number min, Number max) {
    System.out.printf("type:%-6s size:%-2s min:%-20s max:%f\n", type, size, min, max);
  }
}