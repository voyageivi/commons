package com.afmobi.common.util;

import java.util.*;

/**
 * ClassName:ProbabilityUtil
 * Date:     2017年8月9日 下午6:31:54
 * @author   vincent
 * @version
 * @see
 */
public class ProbabilityUtil {
    public static <T> T random(ProbabilityConfig<T> probabilityConfig) {
        Random rd=new Random();
        Map<T,Integer> tmpMap=probabilityConfig.getProbMap();
        int rInt=rd.nextInt(probabilityConfig.getMaxX());
        for(T key: tmpMap.keySet()){
            Integer val=tmpMap.get(key);
            if(rInt<val){
                return key;
            }
        }
        return null;
    }
    public static <T> ProbabilityConfig<T> config(Set<Probability<T>> probs){
        return new ProbabilityConfig<T>(probs);
    }
    public static <T> ProbabilityConfig<T> config(Probability<T>... probs){
        Set<Probability<T>> probsSet=new HashSet<Probability<T>>();
        for(Probability<T> prob: probs){
            probsSet.add(prob);
        }
        return new ProbabilityConfig<T>(probsSet);
    }

    public static class ProbabilityConfig<T>{
        Set<Probability<T>> probs=new HashSet<Probability<T>>();
        private LinkedHashMap<T,Integer> probMap =new LinkedHashMap<T, Integer>();
        int maxX=0;
        ProbabilityConfig(Set<Probability<T>> probs){
            for(Probability<T> prob: probs){
                this.probs.add(prob);
            }
            this.refresh();
        }
        public void refresh(){
            int x=0;
            probMap.clear();
            for(Probability<T> prob: this.probs){
                x=x+prob.prob;
                probMap.put(prob.key, x);
            }
            this.maxX=x;
        }
        public String toString(){
            int max=getMaxX();
            if(max==0) return "";
            StringBuilder sb=new StringBuilder();
            for(Probability<T> prob: this.probs){
                sb.append(prob.key).append(" : ")
                        .append(MathUtil.round( prob.prob*100.0/max,2))
                        .append("%\n");
            }
            return sb.toString();
        }

        public LinkedHashMap<T, Integer> getProbMap() {
            return probMap;
        }

        public int getMaxX() {
            return maxX;
        }
    }
    public static class Probability<T>{
        T key;
        Integer prob;
        public Probability(T key, Integer prob){
            super();
            this.key = key;
            this.prob = prob;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((key == null) ? 0 : key.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Probability other = (Probability) obj;
            if (key == null) {
                if (other.key != null) return false;
            } else if (!key.equals(other.key)) return false;
            return true;
        }

    }
}
