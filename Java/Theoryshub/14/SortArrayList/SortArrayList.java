import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortArrayList {
    public static void main(String[] args) {
        File file;
        BufferedReader br = null;
        try {
            //read the words
            file = new File(args[0]);
            br = new BufferedReader(new FileReader(file));
            ArrayList<String> words = new ArrayList<String>();
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] wordsInThisLine = strLine.split(" ");
                words.addAll(Arrays.asList(wordsInThisLine));
            }
            //sort the words
            words.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return s.compareTo(t1);
                }
            });
            //print the words
            for (int i = 0; i < words.size(); i++)
                System.out.println(words.get(i));

            //for (String word : words) System.out.println(word);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
