package com.dinner3000.demo.respbody.helper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DataFilter {
    public static Map<String, Object> filter(Object o){
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field field : fields){
            Object val = null;
            try {
                field.setAccessible(true);
                val = field.get(o);
/*                    Method method = o.getClass().getMethod(String.format("get%s%s",
                            field.getName().substring(0, 1).toUpperCase(), field.getName().substring(1)));
                    val = method.invoke(o);*/
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (val instanceof Float || val instanceof Double|| val instanceof BigDecimal){
                val = val.toString();
            }
            map.put(field.getName(), val);
        }
        return map;
    }
}
