package com.example.algorithms_1_1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerListImplTest {

    private IntegerListImpl integerListImpl;


    @BeforeEach

    public void setUp() {
        this.integerListImpl = new IntegerListImpl(10);
    }

    @Test

    public void addTest(){
        integerListImpl.add(10);
        assert integerListImpl.contains(10);
    }

    @Test
    public void addWithIndexTest(){
        integerListImpl.add(0,10);
        Assertions.assertThat(integerListImpl.indexOf(10)).isEqualTo(0);
    }

}


