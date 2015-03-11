package ca.calvinrempel.firstimpressions_pof;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Chris on 2015-03-11.
 */
public class TalkingPoints {

    public static String getRandomTalkingPoint(Profile p)
    {
        String message = "Your date likes the ";

        // Retrieve the likes
        HashMap<String,TreeSet<String>> likes = p.getLikes();

        // Pick a random category
        int category = (int)(Math.random() * likes.size());
        TreeSet<String> categoryOptions = likes.get(Profile.LIKES[category]);

        // Add the category to the message
        switch(category)
        {
            case 0:
            {
                // Movies
                message += "movie ";
                break;
            }
            case 1:
            {
                // TV
                message += "tv show ";
                break;
            }
            case 2:
            {
                // Music
                message += "song ";
                break;
            }
            case 3:
            {
                // Books
                message += "book ";
                break;
            }
            case 4:
            {
                // Food
                message += "food ";
                break;
            }
        }

        // Pick a random object from that category
        int object = (int)(Math.random() * categoryOptions.size());
        Iterator<String> treeSetData = categoryOptions.iterator();
        for (int i = 0; i < object; i++)
        {
            treeSetData.next();
        }

        message += treeSetData.toString() + ".";

        return message;
    }
}
