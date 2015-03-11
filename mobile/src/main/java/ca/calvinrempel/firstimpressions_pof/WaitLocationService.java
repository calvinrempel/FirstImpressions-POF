package ca.calvinrempel.firstimpressions_pof;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import org.json.JSONArray;

/**
 * Created by Chris on 2015-03-10.
 */
public class WaitLocationService extends IntentService {

    /** An enum for the possible states of the waiting service */
    private enum WaitState {
        NEARBY, ARRIVAL, TALKING
    }

    private WaitState state;

    /**
     * @author Chris Klassen
     */
    public WaitLocationService()
    {
        super("WaitLocationService");
    }

    /**
     * @author Chris Klassen
     * @param workIntent an intent containing the wait times for the service
     */
    protected void onHandleIntent(Intent workIntent) {
        // Retrieve start up data
        int nearbyTime = workIntent.getExtras().getInt("nearbyTime");
        int arrivalTime = workIntent.getExtras().getInt("arrivalTime");
        int talkingTime = workIntent.getExtras().getInt("talkingTime");
        int myId = workIntent.getExtras().getInt("myId");
        final int otherId = workIntent.getExtras().getInt("otherId");

        state = WaitState.ARRIVAL;

        // Loop infinitely until the date ends
        while(true)
        {
            switch(state)
            {
                // CASE IGNORED - NO TIME!
                case NEARBY:
                {
                    // Sleep for the allotted period of time
                    SystemClock.sleep(nearbyTime * 1000);

                    // Check to see if the individual is nearby
                    break;
                }

                case ARRIVAL:
                {
                    // Sleep for the allotted period of time
                    SystemClock.sleep(arrivalTime * 1000);

                    // Check to see if the individual has arrived
                    Mongo.getMeetings(new MongoReceiver() {
                        @Override
                        public void process(JSONArray result) {
                            try
                            {
                                Meeting meeting = new Meeting(result.getJSONObject(0));
                                if (meeting.hasArrived(otherId))
                                {
                                    state = WaitState.TALKING;
                                    sendNotification("Your Date has Arrived!", "Cool...");
                                }
                            }
                            catch (Exception e)
                            {
                            }
                        }
                    }, myId);
                    break;
                }

                case TALKING:
                {
                    // Sleep for the allotted period of time
                    SystemClock.sleep(talkingTime * 1000);

                    // Create a Talking Point card
                    break;
                }
            }
        }
    }

    public void sendNotification(String title, String description)
    {
        //add notification features
        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintShowBackgroundOnly(true);

        Notification notification =
                new NotificationCompat.Builder(this)
                        .setVibrate(new long[] {100, 250, 100, 250, 100, 25})
                        .setLights(Color.BLUE, 500, 500)
                        .setSmallIcon(R.drawable.fish)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                getResources(), R.drawable.fishes))
                        .setColor(getResources().getColor(R.color.wallet_holo_blue_light))
                        .setContentTitle(title)
                        .setContentText(description)
                        .extend(wearableExtender)
                        .build();

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        //fire off a notification
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }

}
