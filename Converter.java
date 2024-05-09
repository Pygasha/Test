import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Converter {
    private Map<String, Integer> romanMap = new LinkedHashMap<>();
    private TreeMap<Integer, String> arabMap = new TreeMap<>();

    public Converter() {
        romanMap.put("I", 1);
        romanMap.put("II", 2);
        romanMap.put("III", 3);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("VI", 6);
        romanMap.put("VII", 7);
        romanMap.put("VIII", 8);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);

        arabMap.put(1000, "M");
        arabMap.put(900, "CM");
        arabMap.put(500, "D");
        arabMap.put(400, "CD");
        arabMap.put(100, "C");
        arabMap.put(90, "XC");
        arabMap.put(50, "L");
        arabMap.put(40, "XL");
        arabMap.put(10, "X");
        arabMap.put(9, "IX");
        arabMap.put(5, "V");
        arabMap.put(4, "IV");
        arabMap.put(1, "I");

    }

    public boolean isRoman(String value) {
        return romanMap.containsKey(String.valueOf(value.charAt(0)));
    }

    public int romanToInt(String value) {
        int lastIndex = value.length() - 1;
        String[] arr = value.split("");
        int arabDigit;
        int result = romanMap.get(arr[lastIndex]);
        for (int i = lastIndex - 1; i >= 0; i--) {
            arabDigit = romanMap.get(arr[i]);
            if (arabDigit < romanMap.get(arr[i + 1])) {
                result -= arabDigit;
            } else {
                result += arabDigit;
            }

        }
        return result;
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabKey;
        do {
            arabKey = arabMap.floorKey(number);
            roman += arabMap.get(arabKey);
            number -= arabKey;
        } while (number != 0);
        return roman;
    }



}

