package ca.calvinrempel.firstimpressions_pof;

import org.json.JSONObject;

/**
 * Created by Nav on 3/11/2015.
 */
public class Data {

    private static String chris = "{ \"_id\" : 1 , \"name\" : \"Chris Klassen\" , \"gender\" : \"male\" , \"birthdate\" : \"1995-03-10\" , \"phone\" : \"7788750073\" , \"picture\" : \"https://scontent.xx.fbcdn.net/hphotos-xfp1/l/t31.0-8/s2048x2048/1500774_10202172711332212_1557535925_o.jpg\" , \"likes\" : { \"movies\" : [ \"Faceoff\" , \"Con-air\" , \"The Wicker Man\"] , \"tv\" : [ \"Firefly\" , \"Family Guy\"] , \"music\" : [ \"Katy Perry\" , \"Taylor Swift\"] , \"books\" : [ \"The Kite Runner\" , \"The Road\"] , \"food\" : [ \"Pizza\" , \"Sandwiches\"]}}";
    private static String rhea = "{ \"_id\" : 2 , \"name\" : \"Rhea Lauzon\" , \"gender\" : \"female\" , \"birthdate\" : \"1995-03-10\" , \"phone\" : \"6047258441\" , \"picture\" : \"https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash2/t31.0-8/1048714_125431494332800_859932500_o.jpg\" , \"likes\" : { \"movies\" : [ \"Faceoff\" , \"Pulp Fiction\"] , \"tv\" : [ \"Firefly\" , \"The Simpsons\"] , \"music\" : [ \"Katy Perry\" , \"MC Hammer\"] , \"books\" : [ \"The Kite Runner\" , \"The Hitch Hiker's Guide to the Galaxy\"] , \"food\" : [ \"Pizza\" , \"Sushi\"]}}";
    private static String tryst = "{ \"_id\" : { \"$oid\" : \"54ff443ae4b031fd7e4128a4\"} , \"location\" : [ 49.28476756 , -123.11258472] , \"time\" : \"2015-3-10-13-30\" , \"users\" : [ { \"id\" : 1 , \"nearby\" : false , \"arrived\" : true} , { \"id\" : 2 , \"nearby\" : false , \"arrived\" : false}]}";

    public static Profile getChris()
    {
        Profile result = null;
        try {
            result = new Profile( new JSONObject(chris) );
        }catch (Exception e){}
        finally {
            return result;
        }
    }

    public static Profile getRhea()
    {
        Profile result = null;
        try {
            result = new Profile( new JSONObject(rhea) );
        }catch (Exception e){}
        finally {
            return result;
        }
    }

    public static Meeting getMeeting()
    {
        Meeting result= null;
        try {
            result = new Meeting( new JSONObject(tryst) );
        }catch (Exception e){}
        finally {
            return result;
        }
    }
}
