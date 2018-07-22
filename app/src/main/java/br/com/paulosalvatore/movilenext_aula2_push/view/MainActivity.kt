package br.com.paulosalvatore.movilenext_aula2_push.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.paulosalvatore.movilenext_aula2_push.R
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val url = "http://www.cuelogic.com/blog/wp-content/uploads/2017/08/Kotlin-for-Android-development.png"

		/*Glide.with(this)
				.load(url)
				.into(imageView)*/

		Picasso.get()
				.load(url)
				.into(imageView)
	}
}
