/**
 * <p>Company: http://www.ctnrs.com</p>
 * <p>Copyright: Copyright (c) 2019</p>
 */
package com.morefans.basic.core.base;

import com.morefans.basic.core.constant.HttpStatusConstants;
import com.morefans.basic.core.util.ResponseResult;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * ResponseResultManager
 * @author tanxw
 */
@Data
@Component
public class ResponseResultManager {


    /**
     * 返回错误，可以传状态码和msg
     * @param status
     * @param msg
     * @param <T>
     * @return
     */
	public static<T> ResponseResult<T> setResultError(Integer status, String msg) {
	    return setResult(status, msg, null);
	}

    /**
     * 返回错误，可以传msg
     * @param msg  错误信息
     * @return
     */
	public static<T> ResponseResult<T> setResultError(String msg) {
		return setResult(HttpStatusConstants.HTTP_RES_CODE_500, msg, null);
	}

    /**
     *
     * @param status  错误装填吗
     * @param msg  错误信息
     * @param result 错误对象
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> setResultError(Integer status, String msg, T result) {
        return setResult(status, msg, result);
    }

    /**
     * 返回成功，可以传result
     * @param result
     * @param <T>
     * @return
     */
	public static<T>ResponseResult<T> setResultSuccess(T result) {
		return setResult(HttpStatusConstants.HTTP_RES_CODE_200, HttpStatusConstants.HTTP_RES_CODE_200_MSG, result);
	}

    /**
     * 返回成功，没有result结果
     * @param <T>
     * @return
     */
	public static<T> ResponseResult<T> setResultSuccess() {
		return setResult(HttpStatusConstants.HTTP_RES_CODE_200, HttpStatusConstants.HTTP_RES_CODE_200_MSG, null);
	}

    /**
     * // 返回成功，有消息沒有data值
     * @param msg
     * @param <T>
     * @return
     */
	public static<T> ResponseResult<T> setResultMsgSuccess(String msg) {
		return setResult(HttpStatusConstants.HTTP_RES_CODE_200, msg, null);
	}

    /**
     * 通用封装
     * @param status
     * @param msg
     * @param result
     * @param <T>
     * @return
     */
	public static<T> ResponseResult<T> setResult(Integer status, String msg, T result) {
		return new ResponseResult<T>(status, msg, result);
	}

    /**
     * 调用数据库层判断
     * @param result
     * @return
     */
	public static Boolean toDaoResult(Long result) {
		return result.intValue() > 0 ? true : false;
	}
}
