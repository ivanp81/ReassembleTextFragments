package com.example.fragment.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReassembledTextTest {

    @Test
    public void testMergeFragment() {

        String text = "O draconia";
        String fragment = "an devil";
        String expectedOutput = "O draconian devil";

        ReassembledText reassembledText = new ReassembledText(text);
        reassembledText.mergeFragment(fragment);

        assertThat(reassembledText.toString(), is(expectedOutput));
    }
}