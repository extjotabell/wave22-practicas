package com.meli.be_java_hisp_w22_g01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class MainTest {

    @Test
    public void Main(){
        BeJavaHispW22G01Application.main(new String[] {});
        assertTrue(true);
    }
}
