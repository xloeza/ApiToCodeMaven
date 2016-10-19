package com.nearsoft;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {
        ApiClient client = new ApiClient();

        JavaInfo info = null;
        try {
            info = client.GetJavaInfo("lVJ7JgO9wJOaViUAHiuZWwmb61ebXq8RD2pxgL46");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(info.explanation);
        System.in.read();
    }
}
