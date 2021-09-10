package bup.edu.cn.BeautifulJapanese.Model;

import bup.edu.cn.BeautifulJapanese.framework.RestCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResponseDTO {
    private int code;
    private String msg;
    private Object data;

    public RestResponseDTO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RestResponseDTO success(Object data){
        return new RestResponseDTO(RestCode.OK,"操作成功",data);
    }
}
