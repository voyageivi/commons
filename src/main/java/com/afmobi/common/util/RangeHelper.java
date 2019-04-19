package com.afmobi.common.util;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

/**
 * ClassName:   RangeUtil
 * Date:        2019-04-19 20:08
 *
 * @author Vincent
 */
@RequiredArgsConstructor
public class RangeHelper<T> {
    protected List<Range<T>> ranges;
    @NonNull
    protected Comparator<T> comparator;


    public void init(T... num) {
        if (num.length < 3) {
            throw new IllegalArgumentException("数值小于3");
        }
        ranges = new ArrayList<Range<T>>();
        List<T> nums = Lists.newArrayList(num);
        Collections.sort(nums, comparator);
        Set<T> sets = Sets.newLinkedHashSet(nums);
        Iterator<T> iterator = sets.iterator();
        T oldObj = iterator.next();

        while (iterator.hasNext()) {
            T newObj = iterator.next();
            ranges.add(new Range<T>(oldObj, newObj));
            oldObj = newObj;
        }
    }

    public void init(Range<T>... nums) {
        List<Range<T>> ranges = Lists.newArrayList(nums);

        Iterator<Range<T>> it = ranges.iterator();
        while (it.hasNext()) {
            Range<T> range = it.next();
            if (comparator.compare(range.from, range.to) > 0) {
                ranges.remove(range);
            }
        }
        Collections.sort(ranges, new Comparator<Range<T>>() {
            public int compare(Range<T> o1, Range<T> o2) {
                return comparator.compare(o1.getFrom(), o2.getFrom());
            }
        });
        Set<Range<T>> sets = Sets.newLinkedHashSet(ranges);
        Iterator<Range<T>> iterator = sets.iterator();
        Range<T> oldObj = iterator.next();
        this.ranges = new ArrayList<Range<T>>();
        this.ranges.add(oldObj);
        while (iterator.hasNext()) {
            Range<T> newObj = iterator.next();
            // O...N...N...O
            // O...........O
            if (comparator.compare(oldObj.to, newObj.to) >= 0) {
                continue;
            }
            // O...N...O...N
            // O......ON...N
            if (comparator.compare(oldObj.to, newObj.from) > 0) {
                newObj = new Range<T>(oldObj.to, newObj.to);
            }
            this.ranges.add(newObj);
            oldObj = newObj;
        }
    }

    public Range<T> findRange(T t) {
        for (Range<T> range : ranges) {
            if (comparator.compare(t, range.getFrom()) >= 0
                    && comparator.compare(t, range.getTo()) < 0) {
                return range;
            }
        }
        return null;
    }

    @Data
    @AllArgsConstructor
    public static class Range<T> {
        T from;
        T to;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ranges", ranges)
                .toString();
    }
}
