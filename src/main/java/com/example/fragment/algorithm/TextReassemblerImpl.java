package com.example.fragment.algorithm;

import com.example.fragment.domain.ReassembledText;
import com.example.fragment.util.FragmentOverlapMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextReassemblerImpl implements TextReassembler {

    public String reassemble(String fragmentProblem) {

        List<String> fragments = new ArrayList(Arrays.asList(fragmentProblem.split(";")));
        fragments.sort((String o1, String o2)-> o2.length() - o1.length());

        ReassembledText reassembledText = new ReassembledText(fragments.remove(0));

        for (int i = fragments.size() - 1; i >= 0; i--) {

            String fragmentToMerge = findMaxOverlapFragment(reassembledText.toString(), fragments);
            reassembledText.mergeFragment(fragmentToMerge);
            fragments.remove(fragmentToMerge);
        }

        return reassembledText.toString();
    }

    private String findMaxOverlapFragment(String text, List<String> fragments) {

        int fragmentIndex = 0;
        int maxOverlap = 0;

        for (int i = fragments.size() - 1; i >= 0; i--) {

            int currentOverlap = FragmentOverlapMatcher.overlapLength(text, fragments.get(i));

            if (currentOverlap > maxOverlap) {

                fragmentIndex = i;
                maxOverlap = currentOverlap;
            }
        }

        return fragments.get(fragmentIndex);
    }
}
