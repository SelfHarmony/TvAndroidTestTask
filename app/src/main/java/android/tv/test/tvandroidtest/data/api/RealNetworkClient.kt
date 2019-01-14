package android.tv.test.tvandroidtest.data.api

import android.tv.test.tvandroidtest.core.BASE_URL
import android.tv.test.tvandroidtest.core.CONNECT_TIMEOUT
import android.tv.test.tvandroidtest.core.READ_TIMEOUT
import android.tv.test.tvandroidtest.core.WRITE_TIMEOUT
import android.tv.test.tvandroidtest.data.api.entity.TvProgram
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.channels.Channel
import java.util.concurrent.TimeUnit

class RealNetworkClient() : NetworkClient {


    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val BEARER = "Bearer"
        private const val BASIC = "Basic"
    }

    private var retrofit: Retrofit
    private val loggingInterceptor = HttpLoggingInterceptor()


    init {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(httpClient)
                .build()

    }

    private val tvProgramApi by lazy { retrofit.create(ApiRequests.TvProgramApi::class.java) }


    override fun getChannels(): Single<List<Channel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTvProgram(channelId: String): Single<TvProgram> {
        return tvProgramApi.getTvProgram(channelId)
    }
}