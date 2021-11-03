package co.tiim.testkarpenkoalex.presentatation.video_content

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.tiim.testkarpenkoalex.MainApplication
import co.tiim.testkarpenkoalex.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer.Builder
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.cache.CacheDataSource
import kotlinx.android.synthetic.main.activity_player.*


/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */

class PlayerActivity : AppCompatActivity() {

    private lateinit var player: SimpleExoPlayer
    private val videoUrl get() = requireNotNull(intent.getStringExtra(VIDEO_URL))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        initializePlayer()
    }


    @SuppressLint("RestrictedApi")
    private fun initializePlayer() {
        player = Builder(this).build()
        epVideoView.player = player

        val videoUri = Uri.parse(videoUrl)
        val mediaItem = MediaItem.fromUri(videoUri)
        val httpDataSourceFactory = DefaultHttpDataSource.Factory().setAllowCrossProtocolRedirects(true)
        val defaultDataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            this, httpDataSourceFactory
        )
        val cacheDataSourceFactory = CacheDataSource.Factory()
            .setCache(MainApplication.instance.simpleCache)
            .setUpstreamDataSourceFactory(defaultDataSourceFactory)
            .setFlags(CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR)

        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(cacheDataSourceFactory)
            .createMediaSource(mediaItem)
        player.setMediaSource(mediaSource, true)
        player.prepare()
    }

    override fun onStart() {
        super.onStart()
        player.play()
    }


    override fun onStop() {
        super.onStop()
        player.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    companion object {
        private const val VIDEO_URL = "video_url"

        fun launch(context: Context, videoUrl: String) {
            context.startActivity(
                Intent(context, PlayerActivity::class.java)
                    .putExtra(VIDEO_URL, videoUrl)
            )
        }
    }


}