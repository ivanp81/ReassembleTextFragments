package com.example.fragment.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FragmentOverlapMatcherTest {

    @Test
    public void testOverlapLength() {

        String text = "O draconia";
        String fragment = "nian";

        int overlapLength = FragmentOverlapMatcher.overlapLength(text, fragment);

        assertThat(overlapLength, is(3));
    }

    @Test
    public void testIsOverlapAtStart() {

        String text = "lame saints";
        String fragment = "Oh lam";

        boolean isOverlapAtStart = FragmentOverlapMatcher.isOverlapAtStart(text, fragment);

        assertThat(isOverlapAtStart, is(true));
    }

    @Test
    public void testIsOverlapAtEnd() {

        String text = "O draconia";
        String fragment = "nian";

        boolean isOverlapAtEnd = FragmentOverlapMatcher.isOverlapAtEnd(text, fragment);

        assertThat(isOverlapAtEnd, is(true));
    }

    @Test
    public void testContainsFragment() {

        String text = "O draconia";
        String fragment = "con";

        boolean containsFragment = FragmentOverlapMatcher.containsFragment(text, fragment);

        assertThat(containsFragment, is(true));
    }
}