package com.example.lab_6

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lab_6.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = Retrofit.api.getEvents(id = "52772")
                val meals = response.meals

                if (meals.isNotEmpty()) {
                    val meal = meals[0]
                    withContext(Dispatchers.Main) {
                        binding.strMeal.text = meal.strMeal
                        binding.strArea.text = meal.strArea
                        binding.strInstructions.text = meal.strInstructions

                        Glide.with(this@MainActivity)
                            .load(meal.strMealThumb)
                            .into(binding.strMealThumb)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@MainActivity, "Список событий пуст", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Ошибка загрузки данных: ${e.message}", Toast.LENGTH_SHORT).show()
                }
                Log.e("API_ERROR", e.message.orEmpty())
            }
        }

        val back: ImageButton = binding.backButton
        val fullScr: ImageButton = binding.fullScreen
        val play: ImageButton = binding.playButton
        val share: ImageButton = binding.shareButton
        val like: ImageButton = binding.likeButton
        val review: ImageButton = binding.openReviews

        back.setOnClickListener {
            Log.i("Tap", "Кнопка должна возвращать на главный экран")
        }

        fullScr.setOnClickListener {
            Log.i("Tap", "Кнопка должна открыть видео в полноэкранном режиме")
        }

        play.setOnClickListener {
            Log.i("Tap", "Кнопка должна возобновить видеоплеер")
        }

        share.setOnClickListener {
            Log.i("Tap", "Кнопка должна вызывать меню, чтобы поделиться ссылкой")
        }

        like.setOnClickListener {
            Log.i("Tap", "Кнопка должна увеличивать/уменьшать количество лайков")
        }

        review.setOnClickListener {
            Log.i("Tap", "Кнопка должна открывать все комментарии")
        }
    }
}
