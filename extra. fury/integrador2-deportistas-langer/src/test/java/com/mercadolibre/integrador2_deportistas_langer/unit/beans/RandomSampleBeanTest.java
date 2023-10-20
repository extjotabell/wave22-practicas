package com.mercadolibre.integrador2_deportistas_langer.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.integrador2_deportistas_langer.beans.RandomSampleBean;
import com.mercadolibre.integrador2_deportistas_langer.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
