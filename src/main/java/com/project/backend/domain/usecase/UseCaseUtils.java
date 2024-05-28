package com.project.backend.domain.usecase;

public class UseCaseUtils {

    public static String normalizarTexto(String str){
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}
