package com.example.fragment.algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextReassemblerTest {

    @Test
    public void testReassemble_whenInput1() {

        String input = "O draconia;conian devil! Oh la;h lame sa;saint!;draconi;";
        String expectedOutput = "O draconian devil! Oh lame saint!";

        String reassembledText = new TextReassemblerImpl().reassemble(input);

        assertThat(reassembledText, is(expectedOutput));
    }

    @Test
    public void testReassemble_whenInput2() {

        String input = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al";
        String expectedOutput = "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.";

        String reassembledText = new TextReassemblerImpl().reassemble(input);

        assertThat(reassembledText, is(expectedOutput));
    }
}