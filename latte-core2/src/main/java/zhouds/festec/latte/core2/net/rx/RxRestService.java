package zhouds.festec.latte.core2.net.rx;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 创建者 zds
 * 创建时间 2020/1/9 0009  14:42
 *
 * @描述
 **/
public interface RxRestService {
    /**
     * Get 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, Object> parmas);

    /**
     * Post 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @FormUrlEncoded
    @POST
    Observable<String> post(@Url String url, @FieldMap Map<String, Object> parmas);

    /**
     * Post 请求 -- 原始数据
     *
     * @param url
     * @return
     */

    @POST
    Observable<String> postRaw(@Url String url, @Body RequestBody body);

    /**
     * Put 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @FormUrlEncoded
    @PUT
    Observable<String> put(@Url String url, @FieldMap Map<String, Object> parmas);

    /**
     * Put 请求 -- 原始数据
     *
     * @param url
     * @return
     */

    @PUT
    Observable<String> putRaw(@Url String url, @Body RequestBody body);

    /**
     * Delete 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @DELETE
    Observable<String> delete(@Url String url, @QueryMap Map<String, Object> parmas);

    /**
     * download 下载
     *
     * @param url
     * @param parmas
     * @return
     */
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> parmas);

    /**
     * Upload 上传
     *
     * @param url
     * @param file
     * @return
     */
    @Multipart
    @POST
    Observable<String> upload(@Url String url, @Part MultipartBody.Part file);
}
