package org.springlearning.springlearning.domain;

public interface Commmnand {
   default String aggregateId() {
       return "";
   }
}
