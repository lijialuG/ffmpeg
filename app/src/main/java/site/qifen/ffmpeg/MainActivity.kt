package site.qifen.ffmpeg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val holder: SurfaceHolder = findViewById<SurfaceView>(R.id.surface).holder

        play.setOnClickListener {
            if (!TextUtils.isEmpty(url.text.trim())) {
                thread {
                    playVideo(url.text.toString(), holder.surface)
                }
            }
        }
    }

    external fun playVideo(uri: String, surface: Surface)

    companion object {
        init {
            System.loadLibrary("video")
        }
    }
}
