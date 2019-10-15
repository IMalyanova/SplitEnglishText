import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitEnglishText {
    public static void main(String[] args) {

        String text = "email@mail.org Это слово? At twelve o'clock! 12th of December. There are these words: a house, I, the people, an cat, 23 home." +
                " A regular expression, specified as a string, must first be compiled into an instance of this class.";

        Pattern pattern = Pattern.compile("([A-Z][a-z]+)|([a-z]+)|([A-Z]+)|([A-Z]'[a-z]+)|([a-z]'[a-z]+)|([a-z]'[A-Z][a-z]+)|([A-Z]'[A-Z]+)|([A-Z]'[A-Z][a-z]+)");
        String textSplit[] = text.split("[\\s\\\\/\\)\\(\\]\\[\"-]+");

        for (String value: textSplit){
//            System.out.println("text: " + value);
            value = value.replaceAll("[,.:!?;]+","");
            Matcher matcher = pattern.matcher(value);
            if (matcher.matches()){
                System.out.printf("%s\n",matcher.group());
            }
        }
    }
}
