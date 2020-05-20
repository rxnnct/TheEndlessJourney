package ru.rxnnct.application.util;

public class Encoder {
    private static Encoder ourInstance = new Encoder();

    private String KEY_WORD = "ldf253dj4d87uoof";

    public static Encoder getInstance() {
        return ourInstance;
    }

    private Encoder() {
    }

    public byte[] encrypt(String inputString) {
        byte[] inputArray = inputString.getBytes();
        byte[] keyWordArray = KEY_WORD.getBytes();
        byte[] resultArray = new byte[inputArray.length];
        for(int i = 0; i < inputArray.length; i++) {
            resultArray[i] = (byte) (inputArray[i] ^ keyWordArray[i % keyWordArray.length]);
        }
        return resultArray;
    }

    public String decrypt(byte[] inputArray) {
        byte[] resultString  = new byte[inputArray.length];
        byte[] keyWordArray = KEY_WORD.getBytes();
        for(int i = 0; i < inputArray.length; i++) {
            resultString[i] = (byte) (inputArray[i] ^ keyWordArray[i % keyWordArray.length]);
        }
        return new String(resultString);
    }
}
