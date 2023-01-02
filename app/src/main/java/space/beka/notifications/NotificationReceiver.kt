package space.beka.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat

class NotificationReceiver : BroadcastReceiver() {
    var mediaPlayer: MediaPlayer? = null
    override fun onReceive(context: Context, intent: Intent) {
        if (mediaPlayer==null) {
            val alert: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
            mediaPlayer = MediaPlayer.create(context, alert)
            mediaPlayer?.start()
            Toast.makeText(context, "Image Click", Toast.LENGTH_SHORT).show()
        }else{
            if (mediaPlayer?.isPlaying!!){
                mediaPlayer?.pause()
            }
            else{
                mediaPlayer?.start()
            }
        }
    }
}
object MyMedia{
    var mediaPlayer :MediaPlayer?= null
}