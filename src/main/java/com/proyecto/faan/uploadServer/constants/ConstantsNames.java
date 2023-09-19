package com.proyecto.faan.uploadServer.constants;

import java.util.HashMap;
import java.util.Map;

public class ConstantsNames {
    public static final String PATH_ROOT = "uploads";
    public static final String DOCUMENTS = "uploads/documents";
    public static final String IMAGES = "uploads/images";

    public static final Map<String, String> FOLDER_MAPPING = new HashMap<>();
    static {
        FOLDER_MAPPING.put("documents", DOCUMENTS);
        FOLDER_MAPPING.put("images", IMAGES);
    }
}

