package com.example.lab_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val back: ImageButton = findViewById(R.id.back_button)
        val full_scr: ImageButton = findViewById(R.id.full_screen)
        val play: ImageButton = findViewById(R.id.play_button)
        val share: ImageButton = findViewById(R.id.share_button)
        val like: ImageButton = findViewById(R.id.like_button)
        val review: ImageButton = findViewById(R.id.open_reviews)

        back.setOnClickListener{
            Log.i("Tap", "Кнопка должна возвращать на главный экран")
        }

        full_scr.setOnClickListener{
            Log.i("Tap", "Кнопка должна открыть видео в полноэкранном режиме")
        }

        play.setOnClickListener{
            Log.i("Tap", "Кнопка должна возобновить видеоплеер")
        }

        share.setOnClickListener{
            Log.i("Tap", "Кнопка должна вызывать меню, чтобы поделиться ссылкой")
        }

        like.setOnClickListener{
            Log.i("Tap", "Кнопка должна увеличивать/уменьшать количество лайков")
        }

        review.setOnClickListener{
            Log.i("Tap", "Кнопка должна открывать все комментарии")
        }
    }
}