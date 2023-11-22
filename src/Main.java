import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File selected: " + selectedFile.getName());

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    charCount += line.length();
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }

            System.out.println("Number of lines: " + lineCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + charCount);
        } else {
            System.out.println("No file was chosen.");
        }
    }
}