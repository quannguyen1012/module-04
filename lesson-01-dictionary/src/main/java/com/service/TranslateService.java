package com.service;

import java.util.ArrayList;

public class TranslateService implements ITranslate{
    private static final ArrayList<String> words;
    private static final ArrayList<String> wordsEng;
    static {
        words = new ArrayList<>();
        words.add("XANH");
        words.add("DO");
    }
    static {
        wordsEng = new ArrayList<>();
        wordsEng.add("GREEN");
        wordsEng.add("RED");
    }
    @Override
    public Integer findIdName(String name) {
        Integer result = null;
        for (String word:words) {
            if(word.equals(name)){
                result = words.indexOf(name);
            }
        }
        return result;
    }
    @Override
    public String findNameByIdx(Integer idx) {
        String result = wordsEng.get(idx);
        return result;
    }


}
