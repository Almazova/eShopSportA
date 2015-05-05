/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author asus
 */
public class CollectionNames {

    static Map<String, String> map;

    static {
        map = new HashMap<String, String>();
        map.put("clothing", "Элементы одежды");
        map.put("souvenirs", "Сувениры");
        map.put("sound_attributes", "Звуковые атрибуты");
        map.put("books_and_media", "Книги и мультимедиа");
        map.put("flags_and_pennants", "Флаги и вымпелы");
    }

    public static String getNameCategoryByKey(String key) {
        for (Entry<String, String> entry : map.entrySet()) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;

    }

}
