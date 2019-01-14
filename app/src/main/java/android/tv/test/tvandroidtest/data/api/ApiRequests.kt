package android.tv.test.tvandroidtest.data.api

import android.tv.test.tvandroidtest.data.api.entity.TvProgram
import io.reactivex.Completable
import io.reactivex.Single
import org.reactivestreams.Subscription
import retrofit2.http.*


object ApiRequests {


    interface TvProgramApi {

        @GET("channels/{channelId}/tvprogram")
        fun getTvProgram(@Path("channelId") channelId: String
        ): Single<TvProgram>
    }

}