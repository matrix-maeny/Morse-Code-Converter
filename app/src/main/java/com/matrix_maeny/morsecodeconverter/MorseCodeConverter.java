package com.matrix_maeny.morsecodeconverter;

import java.util.Dictionary;
import java.util.Hashtable;

public class MorseCodeConverter {

    Dictionary<String, String> morseCodesDictionary = new Hashtable<>();
    final String[][] morseCodes = {
            {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."}, {"F", "..-."},
            {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
            {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."},
            {"S", "..."}, {"T", "-"}, {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
            {"Y", "-.--"}, {"Z", "--.."}, {" ", "/"},

            {"0", "-----"}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"}, {"5", "....."},
            {"6", "-...."}, {"7", "--..."}, {"8", "---.."}, {"9", "----."}
    };

    public MorseCodeConverter() {
        addToDictionary();
    }

    private void addToDictionary() {
        for (String[] x : morseCodes) {
            morseCodesDictionary.put(x[0], x[1]);
        }
    }


    public String getMorseCodeFromMessage(String msgInText) {

        msgInText = msgInText.toUpperCase();

        StringBuilder mCode = new StringBuilder();

        for (int i = 0; i < msgInText.length(); i++) {
            String x = msgInText.charAt(i) + "";
            if (morseCodesDictionary.get(x) != null)
                mCode.append(morseCodesDictionary.get(x)).append("   ");
            else
                return "Error....!";
//            mCode.append(x);
        }


        return mCode.toString();

    }
}
