package lection9.task4;

import java.io.*;
import java.sql.Time;
import java.util.Scanner;

/**
 * Текстовый файл содержит текст. После запуска программы в другой файл
 * должны записаться только те предложения в которых от 3-х до 5-ти слов. Если в
 * предложении присутствует слово-палиндром, то не имеет значения какое кол-во
 * слов в предложении, оно попадает в новый файл.
 * Пишем все в ООП стиле. Создаём класс TextFormater
 * в котором два статических метода:
 * 1. Метод принимает строку и возвращает кол-во слов в строке.
 * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если
 * есть возвращает true, если нет false
 */

public class Task4 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        try (Scanner readText = new Scanner(new BufferedReader(new FileReader("src/lection9/task4/text.txt")));
             BufferedWriter writeText = new BufferedWriter(new FileWriter("src/lection9/task4/result.txt"))) {
            StringBuffer buffer = new StringBuffer();
            while (readText.hasNextLine()) {
                String currentLine = readText.nextLine();                                                   //записать весть текст в одну строку
                buffer.append(currentLine+" ");
                }


            String text = buffer.toString();
            int countOfSentence=0;
            int firsIndex=0;

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                    countOfSentence++;                                                                      //расчет количества предложений
                }
            }
            int arraySize=0;
            String[] arrayOfSentence=new String[countOfSentence];

            for (int i = 0; i < text.length();) {
                if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                    i++;
                    String substring = text.substring(firsIndex, i);                                        //запись предложений в отдельный массив
                    firsIndex=i;
                    arrayOfSentence[arraySize] = substring;
                    arraySize++;
                } else {
                    i++;

                }
            }

            for (String sentence : arrayOfSentence) {
                if ((TextFormater.getCountWordsInLine(sentence)<6 && TextFormater.getCountWordsInLine(sentence)>2) || TextFormater.isPolyndrom(sentence)){
                    writeText.write(sentence.trim()+"\n");
                }
            }

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time: "+(end-start));
    }
}
