package PasswordGenerator;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class PasswordGeneratorMain {
    private static final String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowercase = "abcdefghijklmopqrstuvwxyz";
    private static final String digits = "0123456789";
    private static final String special_characters = "<>,.?-=+$@#!%^&*_|";
    private static final String all_characters = uppercase + lowercase + digits + special_characters;

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;

        // Запрашиваем у пользователя длину пароля, пока не введет корректное значение
        while (true) {
            System.out.print("Введите длину пароля (от 8 до 12 символов): ");
            length = scanner.nextInt();

            if (length >= 8 && length <= 12) {
                break;
            } else {
                System.out.println("Длина пароля должна быть от 8 до 12 символов. Повторите ввод.");
            }
        }

        String password = generatePassword(length);
        System.out.println("Сгенерированный пароль: " + password);

        scanner.close();
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);

        //Making sure that password contains at least one character from each category
        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special_characters.charAt(random.nextInt(special_characters.length())));

        //Fill in the rest characters with symbols from all categories
        for (int i = 4; i < length; i++) {
            password.append(all_characters.charAt(random.nextInt(all_characters.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
