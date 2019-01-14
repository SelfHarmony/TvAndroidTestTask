package android.tv.test.tvandroidtest.data.api

import android.tv.test.tvandroidtest.data.api.entity.TvProgram
import io.reactivex.Single
import java.nio.channels.Channel

interface NetworkClient {
    fun getChannels(): Single<List<Channel>>

    fun getTvProgram(channelId: String): Single<TvProgram>
}