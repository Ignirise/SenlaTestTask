package Hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    private static final String[] words = {"музыка", "марио", "йена", "программист", "слово", "игра", "сортировка"};
    private static final int max_lives = 8;

    public static void main(String[] args) {
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        int lives = max_lives;
        char[] guessedWord = new char[wordToGuess.length()];

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        boolean wordGuessed = false;

        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("Попробуйте угадать слово по буквам.");

        while (lives > 0 && !wordGuessed) {
            System.out.println("\nЗагаданное слово: " + new String(guessedWord));
            System.out.println("Осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);

            boolean letterFound = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter && guessedWord[i] == '_') {
                    guessedWord[i] = guessedLetter;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                lives--;
                System.out.println("Буквы '" + guessedLetter + "' нет в слове.");
            } else {
                System.out.println("Буква '" + guessedLetter + "' есть в слове.");
            }

            wordGuessed = new String(guessedWord).equals(wordToGuess);
        }

        if (wordGuessed) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("\nВы проиграли! Загаданное слово было: " + wordToGuess);
        }

        scanner.close();
    }
}