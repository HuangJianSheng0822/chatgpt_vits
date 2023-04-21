package com.huang.chatgpt_vits.util;

import java.util.UUID;

public class UUIDUtil {
    public static String fileNameByUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
