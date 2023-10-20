package com.mercadolibre.integrador2_deportistas_langer.beans;

import com.mercadolibre.integrador2_deportistas_langer.dtos.SampleDTO;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

/**
 * Sample Bean class.
 */
@Component
public class RandomSampleBean {

  /**
   * @return new instance of SampleDTO.
   */
  public SampleDTO random() {
    return new SampleDTO(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
  }
}
