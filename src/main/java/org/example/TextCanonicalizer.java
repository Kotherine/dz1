package org.example;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class TextCanonicalizer {
    public static String canonicalize(String text) {
        // Удаляем лишние пробелы
        text = text.trim().replaceAll("\\s+", " ");
        // Приведение к нижнему регистру
        text = text.toLowerCase();
        // Удаление пунктуации
        text = text.replaceAll("[^a-zа-я0-9\\s]", "");
        // Нормализация текста
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(text).replaceAll("");
        return text;
    }
}