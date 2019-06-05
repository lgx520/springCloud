package common.util;

/**
 * 参数校验类
 * @author Neil
 *
 */
public class CheckUtil {

	public static void isNotNull(Object obj) throws NullPointerException{
		if (obj == null) {
			throw new NullPointerException("参数不能为空");
		}
	}
}
