package com.afmobi.common.pojo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * ClassName:   Tuple
 * Date:        2018-08-20 14:50
 *
 * @author Vincent
 */
public class Tuple<K1, K2> implements Serializable {
    K1 k1;
    K2 k2;

    public Tuple(K1 k1, K2 k2) {
        this.k1 = k1;
        this.k2 = k2;
    }

    public static <K1, K2> Tuple of(K1 k1, K2 k2) {
        return new Tuple(k1, k2);
    }

    public static <K1, K2, K3> T3 of(K1 k1, K2 k2, K3 k3) {
        return new T3(k1, k2, k3);
    }

    public static <K1, K2, K3, K4> T4 of(K1 k1, K2 k2, K3 k3, K4 k4) {
        return new T4(k1, k2, k3, k4);
    }

    public static <K1, K2, K3, K4, K5> T5 of(K1 k1, K2 k2, K3 k3, K4 k4, K5 k5) {
        return new T5(k1, k2, k3, k4, k5);
    }

    public K1 getK1() {
        return k1;
    }

    public K2 getK2() {
        return k2;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static class T3<K1, K2, K3> extends Tuple<K1, K2> {
        K3 k3;

        public T3(K1 k1, K2 k2, K3 k3) {
            super(k1, k2);
            this.k3 = k3;
        }


        public K3 getK3() {
            return k3;
        }
    }

    public static class T4<K1, K2, K3, K4> extends T3<K1, K2, K3> {
        K4 k4;

        public T4(K1 k1, K2 k2, K3 k3, K4 k4) {
            super(k1, k2, k3);
            this.k4 = k4;
        }


        public K4 getK4() {
            return k4;
        }
    }

    public static class T5<K1, K2, K3, K4, K5> extends T4<K1, K2, K3, K4> {
        K5 k5;

        public T5(K1 k1, K2 k2, K3 k3, K4 k4, K5 k5) {
            super(k1, k2, k3, k4);
            this.k5 = k5;
        }


        public K5 getK5() {
            return k5;
        }
    }
}
