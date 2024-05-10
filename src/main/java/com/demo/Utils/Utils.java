package com.demo.Utils;

import com.demo.customAnnotation.FilterableField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    /**
     * 注解查询
     * @param entity 前端json对象
     * @return
     */
    public static Map<String, Object> buildQuery(Object entity) {
        Map<String, Object> queryMap = new HashMap<>();
        // 因为拿的是Object,又不能强转成OrderIn,所以无法通过get方法获取对应的属性,因此通过反射结合注解来拿到我们想要的属性
        Class<?> clazz = entity.getClass();
        // 获取对象字段数组
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 检查字段是否标记了FilterableField注解
            if (field.isAnnotationPresent(FilterableField.class)) {
                // 获取字段上的FilterableField注解实例
                FilterableField filterableField = field.getAnnotation(FilterableField.class);
                // 获取注解中的filterField属性值
                String fieldName = filterableField.filterField();
                field.setAccessible(true);
                try {
                    // 拿注解上的属性名称和实体类的属性名对比
                    if (fieldName.equals(field.getName())) {
                        queryMap.put(fieldName, field.get(entity));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
//                try {
//                    Object value;
//                    if (params.containsKey(fieldName)) {
//                        value = params.get(fieldName);
//                    } else {
//                        value = field.get(entity);
//                    }
//                    if (value != null) {
//                        queryMap.put(fieldName, value);
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 分组
//            if (field.isAnnotationPresent(GroupableField.class)) {
//                // 获取这个
//                GroupableField groupableField = field.getAnnotation(GroupableField.class);
//                String groupName = groupableField.groupField();
//                field.setAccessible(true);
//                try {
//                    Object value;
//                    if (params.containsKey(groupName)) {
//                        value = params.get(groupName);
//                    } else {
//                        value = field.get(entity);
//                    }
//                    if (value != null) {
//                        queryMap.put(groupName, value);
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 排序
//            if (field.isAnnotationPresent(SortableField.class)) {
//                // 获取这个
//                SortableField sortableField = field.getAnnotation(SortableField.class);
//                String sortName = sortableField.sortField();
//                field.setAccessible(true);
//                try {
//                    Object value;
//                    if (params.containsKey(sortName)) {
//                        value = params.get(sortName);
//                    } else {
//                        value = field.get(entity);
//                    }
//                    if (value != null) {
//                        queryMap.put(sortName, value);
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return queryMap;
    }



}
