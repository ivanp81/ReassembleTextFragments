package com.example.fragment.util;

public class FragmentOverlapMatcher {

    public static int overlapLength(String text, String fragment) {

        int overlapAtStartSize = overlapLengthAtStart(text, fragment);
        int overlapAtEndSize = overlapLengthAtEnd(text, fragment);
        int innerOverlap = innerOverlapLength(text, fragment);

        return Math.max(innerOverlap, Math.max(overlapAtStartSize, overlapAtEndSize));
    }

    public static boolean isOverlapAtStart(String text, String fragment) {

        int overlapAtStartSize = overlapLengthAtStart(text, fragment);
        int overlapAtEndSize = overlapLengthAtEnd(text, fragment);
        int innerOverlap = innerOverlapLength(text, fragment);

        return overlapAtStartSize > 0 && overlapAtStartSize > overlapAtEndSize && overlapAtStartSize > innerOverlap ? true : false;
    }

    public static boolean isOverlapAtEnd(String text, String fragment) {

        int overlapAtStartSize = overlapLengthAtStart(text, fragment);
        int overlapAtEndSize = overlapLengthAtEnd(text, fragment);
        int innerOverlap = innerOverlapLength(text, fragment);

        return overlapAtEndSize > 0 && overlapAtEndSize > overlapAtStartSize && overlapAtEndSize > innerOverlap ? true : false;
    }

    public static boolean containsFragment(String text, String fragment) {

        int overlapAtStartSize = overlapLengthAtStart(text, fragment);
        int overlapAtEndSize = overlapLengthAtEnd(text, fragment);
        int innerOverlap = innerOverlapLength(text, fragment);

        return innerOverlap > 0 && innerOverlap > overlapAtStartSize && innerOverlap > overlapAtEndSize ? true : false;
    }

    private static int overlapLengthAtStart(String text, String fragment) {

        int overlapLength = text.length() - 1;

        while (!fragment.regionMatches(false, fragment.length() - overlapLength, text, 0, overlapLength)) {
            overlapLength--;
        }

        return overlapLength;
    }

    private static int overlapLengthAtEnd(String text, String fragment) {

        int overlapLength = fragment.length() - 1;

        while (!text.regionMatches(false, text.length() - overlapLength, fragment, 0, overlapLength)) {
            overlapLength--;
        }

        return overlapLength;
    }

    private static int innerOverlapLength(String text, String fragment) {
        return text.contains(fragment) ? fragment.length() : 0;
    }
}

