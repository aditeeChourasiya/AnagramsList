import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

public class Anagram
{
    public static void main(String[] args) throws IOException {
        // list of words
        List<String> words = Files.readAllLines(new File("C:/Users/bhand/Java Projects/AnagramsList/src/main/resources/words-utf8.txt").toPath(), StandardCharsets.UTF_8 );

        // remove blank lines
        words.removeAll(List.of(""));

        if(words.size()!= 0){
            Set<Set<String>> anagrams = AnagramFinder.groupAnagrams(words);
            System.out.println("List of anagrams : ");
            anagrams.forEach(anagram -> System.out.println(anagram));
        }else {
            System.out.println("File is empty");
        }
    }
}