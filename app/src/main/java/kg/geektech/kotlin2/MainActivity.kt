package kg.geektech.kotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.URLUtil.*
import android.widget.Toast
import kg.geektech.extensions.load
import kg.geektech.kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val images = mutableListOf<String>().apply {
        add("https://www.imgonline.com.ua/examples/bee-on-daisy.jpg")
        add("https://st2.depositphotos.com/1064024/10769/i/600/depositphotos_107694484-stock-photo-little-boy.jpg")
        add("https://www.ixbt.com/img/n1/news/2021/10/2/22459ff25f8eff76bddf34124cc2c85b16f4cd4a_large.jpg")
        add("https://avatarko.ru/img/kartinka/33/multfilm_lyagushka_32117.jpg")
        add("https://mirpozitiva.ru/wp-content/uploads/2019/11/1472042500_03.jpg")
        add("https://tableforchange.com/wp-content/uploads/2020/06/%D0%9E%D0%B1%D0%BE%D0%B8-%D0%B4%D0%BB%D1%8F-%D0%B4%D0%B5%D0%B2%D0%BE%D1%87%D0%B5%D0%BA-%D0%BD%D0%B0-%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD-12-%D0%BB%D0%B5%D1%82-%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D1%8B%D0%B5-%D0%BA%D0%B0%D1%80%D1%82%D0%B8%D0%BD%D0%BA%D0%B8-16.jpg")
        add("https://st2.depositphotos.com/3364363/5972/i/600/depositphotos_59728757-stock-photo-waiting-for-a-new-day.jpg")
        add("https://static10.tgstat.ru/channels/_0/26/2647150c2f9771a41145032b86b6c8a4.jpg")
        add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2yeV0nBNNcM90so1GkoNpKRGP2DbpNjdqZw&usqp=CAU")
        add("https://klike.net/uploads/posts/2019-05/1556945364_1.jpg")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val url = binding.etUrl.text.toString()

            if(isHttpsUrl(url)|| isHttpUrl(url)&& isValidUrl(url)){
                images.add(url)
                binding.etUrl.text.clear()
                Log.d("ololo", "onCreate: "+images.size)
            }else{
                Toast.makeText(this,"Неправильный Url",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRandom.setOnClickListener {
            val randomImage = images.random()
            binding.ivAvatar.load(randomImage)
        }
    }
}