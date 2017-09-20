import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.URL;

/* *
 * This is the code for Lab 3.
 * */

public class MyCode {
/*
 * This is the main method for Lab 3.
 * @param args doesn't do anything
 *  yes
 */
    public static void main(final String[] args) {
        //System.out.print(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int wordCounter = 0; //counts total number of words
        int princeCounter = 0; //counts instances of the word prince
        ArrayList<String> words = new ArrayList<>(); //keeps track of all the words

        for (String current : urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ")) {

            if (current.toLowerCase().contains("prince")) {

                princeCounter++;
            }
        }

        for (String current : urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ")) {

            current.trim();
            if (!current.equals("")) {

                wordCounter++;
                if (!words.contains(current)) {

                    words.add(current);
                }
            }
        }
        System.out.println("There are " + wordCounter + " words");
        System.out.println("with " + princeCounter + " instances of prince occuring");
        System.out.println("There are " + words.size() + " unique words");

    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }



}
