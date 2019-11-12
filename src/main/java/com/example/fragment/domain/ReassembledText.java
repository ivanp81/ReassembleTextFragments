package com.example.fragment.domain;

import com.example.fragment.util.FragmentOverlapMatcher;

public class ReassembledText {

    private StringBuilder reassembledTextBuilder;

    public ReassembledText(String text) {
        this.reassembledTextBuilder = new StringBuilder(text);
    }

    public void mergeFragment(String fragment) {

        int overlapLength = FragmentOverlapMatcher.overlapLength(reassembledTextBuilder.toString(), fragment);

        if(FragmentOverlapMatcher.containsFragment(reassembledTextBuilder.toString(), fragment)) {
            reassembledTextBuilder.replace(reassembledTextBuilder.toString().lastIndexOf(fragment), reassembledTextBuilder.toString().lastIndexOf(fragment) + overlapLength, fragment);
        }
        if(FragmentOverlapMatcher.isOverlapAtStart(reassembledTextBuilder.toString(), fragment)) {
            reassembledTextBuilder.delete(0, overlapLength);
            reassembledTextBuilder.insert(0, fragment);
        }
        if(FragmentOverlapMatcher.isOverlapAtEnd(reassembledTextBuilder.toString(), fragment)) {
            reassembledTextBuilder.append(fragment.substring(overlapLength));
        }
    }

    public String toString() {
        return this.reassembledTextBuilder.toString();
    }
}
