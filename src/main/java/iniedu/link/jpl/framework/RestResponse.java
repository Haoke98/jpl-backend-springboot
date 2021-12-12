package iniedu.link.jpl.framework;

import iniedu.link.jpl.Configs.BaseConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 操作消息提醒
 */
@ApiModel(description = "请求返回体基本结构")
@Getter
@Setter
@Component
public class RestResponse<T> {
    @ApiModelProperty(name = "状态码")
    private int code;
    @ApiModelProperty(name = "提示消息")
    private String msg;
    @ApiModelProperty(name = "接口版本")
    private String version = BaseConfig.API.VERSION;
    @ApiModelProperty(name = "接口编码")
    private String encoding = BaseConfig.API.ENCODING;
    @ApiModelProperty(name = "数据对象", notes = "有可能是Object,也有可能是List<Object>")
    private T data;

    public RestResponse() {
    }

    public RestResponse(Integer code) {
        this.code = code;
        Field[] fields = SC.class.getDeclaredFields();
        for (Field field :
                fields) {
            try {
                int x = field.getInt(new SC());
                if (x == code) {
                    boolean fieldHasAnnotation = field.isAnnotationPresent(ServiceCode.class);
                    if (fieldHasAnnotation) {
                        ServiceCode resCode = field.getAnnotation(ServiceCode.class);
                        this.msg = resCode.msg();
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public RestResponse(int code, String msg) {
        this(code);
        this.msg = msg;
    }

    public RestResponse(int code, T data) {
        this(code);
        if (data != null) {
            this.data = data;
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public RestResponse(int code, String msg, T data) {
        this(code, msg);
        if (data != null) {
            this.data = data;
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static RestResponse success() {
        return new RestResponse(SC.OK);
    }


    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public RestResponse<T> success(T data) {
        return new RestResponse<>(SC.OK, data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static RestResponse success(String msg) {
        return new RestResponse(SC.OK, msg);
    }


    /**
     * 返回成功消息
     *
     * @param msg    返回内容
     * @param result 数据对象
     * @return 成功消息
     */
    public RestResponse<T> success(String msg, T result) {
        return new RestResponse<>(SC.OK, msg, result);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static RestResponse error() {
        return new RestResponse(SC.FAIL);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static RestResponse error(String msg) {
        return new RestResponse(SC.FAIL, msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @return 警告消息
     */
    public static RestResponse error(Integer code) {
        return new RestResponse(code);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static RestResponse error(int code, String msg) {
        RestResponse response = new RestResponse(code);
        response.setMsg(response.getMsg() + ":" + msg);
        return response;
    }

    public RestResponse<T> error(int status, String msg, T result) {
        this.code = status;
        this.msg = msg;
        this.data = result;
        return this;
    }

    public RestResponse<T> error(int status, T result) {
        RestResponse<T> restResponse = new RestResponse<>(status);
        restResponse.data = result;
        return restResponse;
    }
}
