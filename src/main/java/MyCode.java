import java.util.*;
import java.io.IOException;
import java.net.*;
public class MyCode {

    public static void main(String[] args)
    {
        //System.out.print(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int wordCounter = 0;
        int princeCounter = 0;

        for(String current : urlToString("http://erdani.com/tdpl/hamlet.txt").split(" "))
        {
            if(current.toLowerCase().contains("prince"))
            {
                princeCounter++;
            }
        }
        ArrayList<String> words = new ArrayList<>();
        //String current = "";

//        for(int i = 0; i < urlToString("http://erdani.com/tdpl/hamlet.txt").length(); i++)
//        {
//            if(current.toLowerCase().contains(" "))
//            {
//                wordCounter++;
//            }
//        }
        for(String current : urlToString("http://erdani.com/tdpl/hamlet.txt").split(" "))
        {
            current.trim();
            if(!current.equals(""))
            {
                wordCounter++;
                if(!words.contains(current))
                {
                    words.add(current);
                }
            }
        }
        System.out.println("There are " + wordCounter + " words, with " + princeCounter + " instances of prince occuring");
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
