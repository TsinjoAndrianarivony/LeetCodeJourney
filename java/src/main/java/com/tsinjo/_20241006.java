package com.tsinjo;

import java.util.Objects;

/**
 * 10/06/2024: 1813. Sentence Similarity III
 * @author Tsinjo Andrianarivony, 2024-10-06 at 3:35 PM
 */
public class _20241006 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int i;
        String[] sentence1Array = sentence1.split(" ");
        String[] sentence2Array = sentence2.split(" ");

        // We will consider that the sentence1 is always the shorter one
        if (sentence2Array.length < sentence1Array.length) {
            String[] temp = sentence2Array;
            sentence2Array = sentence1Array;
            sentence1Array = temp;
        }

        int diffStart = -1;
        // where does the difference starts from the beginning of sentence1
        for (i = 0; i < sentence1Array.length; i++) {
            if (!Objects.equals(sentence1Array[i], sentence2Array[i])) {
                diffStart = i;
                break;
            }
        }

        // if s2 starts with s1, then they are similar as we just add the remaining words from s2
        // to get the same sentences
        if (diffStart < 0) return true;


        // s2 needs to end with the rest of the sentences to be similar with s1.
        int lengthDiff = sentence2Array.length - sentence1Array.length;
        for (i = sentence1Array.length - 1; i >= diffStart; i--) {
            if (!Objects.equals(sentence1Array[i], sentence2Array[i + lengthDiff])) {
                return false;
            }
        }

        return true;
    }
}