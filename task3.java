//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
//Студент [фамилия] получил [оценка] по предмету [предмет].

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class task3 {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    File file = new File("student.json");
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String jsonString = br.readLine();
      String[] rows = jsonString.split("},");
      String[][] matrix = new String[rows.length][];
      int r = 0;
      for (String row : rows) {
        row = row.replace("{", "");
        row = row.replace("}", "");
        row = row.replace("[", "");
        row = row.replace("]", "");
        row = row.replace(":", ",");
        row = row.replace(" ", "");
        row = row.replace("\"", "");
        matrix[r++] = row.split(",");
      }
      for (int i = 0; i < matrix.length; i++) {
        sb.append("Студент ");
        sb.append(matrix[i][1]);
        sb.append(" получил ");
        sb.append(matrix[i][3]);
        sb.append(" по предмету ");
        sb.append(matrix[i][5]);
        if (i != matrix.length - 1) {
          sb.append("\n");
        }
      }
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    String resultString = new String(sb);
    System.out.println(resultString);
  }
}