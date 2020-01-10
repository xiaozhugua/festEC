package zhouds.festec.latte.core2.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
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
public interface RestService {
    /**
     * Get 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> parmas);

    /**
     * Post 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> parmas);

    /**
     * Post 请求 -- 原始数据
     *
     * @param url
     * @return
     */

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    /**
     * Put 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> parmas);

    /**
     * Put 请求 -- 原始数据
     *
     * @param url
     * @return
     */

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);

    /**
     * Delete 请求
     *
     * @param url
     * @param parmas
     * @return
     */
    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> parmas);

    /**
     * download 下载
     *
     * @param url
     * @param parmas
     * @return
     */
    @Streaming
    @GET
    Call<RequestBody> download(@Url String url, @QueryMap Map<String, Object> parmas);

    /**
     * Upload 上传
     *
     * @param url
     * @param file
     * @return
     */
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
