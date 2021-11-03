package co.tiim.testkarpenkoalex.presentatation.comments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.presentatation.video_content.adapter.CommentsAdapter
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity() {

    private val mediaAdapter = CommentsAdapter()
    private val listComments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        recyComments.layoutManager = LinearLayoutManager(this)
        recyComments.adapter = mediaAdapter

        btSend.setOnClickListener {
            listComments.add(edComment.text.toString())
            mediaAdapter.submitList(listComments.toMutableList())
        }
    }

    companion object {

        fun launch(context: Context) =
            context.startActivity(
                Intent(context, CommentActivity::class.java)
            )
    }
}