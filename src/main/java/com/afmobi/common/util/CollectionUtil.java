package com.afmobi.common.util;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:   CollectionUtil
 * Date:        2018-08-20 15:19
 *
 * @author Vincent
 */
public class CollectionUtil {
    public static boolean hasContent(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean hasContent(Map map) {
        return map != null && !map.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static <T> boolean contain(Collection<T> list, Predicate<T> predicate) {
        if (isEmpty(list)) return false;
        for (T o : list) {
            if (predicate.apply(o)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean contain(Collection<T> list, T obj) {
        if (obj == null) return false;
        return contain(list, Predicates.equalTo(obj));
    }


    public static <K, V> V match(Map<K, V> rtn, Predicate<K> p) {
        if (isEmpty(rtn)) return null;
        for (Map.Entry<K, V> entry : rtn.entrySet()) {
            if (p.apply(entry.getKey())) return entry.getValue();
        }
        return null;
    }

    public static <T> List<T> distinct(List<T> arr, Function<T, String> keyFunc) {
        if (isEmpty(arr)) return Lists.newArrayList();
        Set<String> keys = Sets.newHashSet();
        List<T> rtn = Lists.newArrayList();
        for (T t : arr) {
            String key = keyFunc.apply(t);
            if (keys.contains(key)) continue;
            rtn.add(t);
            keys.add(key);
        }
        return rtn;
    }
}
