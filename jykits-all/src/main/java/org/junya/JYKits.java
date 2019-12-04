package org.junya;

import org.junya.core.collection.CollUtil;
import org.junya.core.util.ArrayUtil;
import org.junya.core.util.CharUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @author 13964
 * @date 2019/12/3 23:07
 * @since 1.0.0
 */
public class JYKits {
    /**
     * 字符串是否为空白 空白的定义如下： <br>
     * 1、为null <br>
     * 2、为不可见字符（如空格）<br>
     * 3、""<br>
     *
     * @param str 被检测的字符串
     * @return 是否为空
     */
    public static boolean isBlank(CharSequence str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            // 只要有一个非空字符即为非空字符串
            if (false == CharUtil.isBlankChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /**
     * 字符串是否为非空白 空白的定义如下： <br>
     * 1、不为null <br>
     * 2、不为不可见字符（如空格）<br>
     * 3、不为""<br>
     *
     * @param str 被检测的字符串
     * @return 是否为非空
     */
    public static boolean isNotBlank(CharSequence str) {
        return false == isBlank(str);
    }
    /**
     * * <p>判断对象是否为空</p>
     *      * <p>引用指向的地址为空</p>
     *      * <p>指向的值不存在</p>
     *      * <p>字符串的长度为0</p>
     *      * <p>集合的长度为0</p>
     *      * <p>数组长度为0</p>
     *      * <p>自定义类型只能判断是否为null</p>
     *      *
     *      * @param t
     *      * 		要判断的对象
     *      * @return 是否为空
     *
     * @Author ZHANGCHAO
     * @Date 2019/12/2
     **/
    public static boolean isEmpty(Object object) {
        if (null == object) {
            return true;
        } else if (object.getClass().isPrimitive() || object instanceof Boolean || object instanceof Number) {
            return false;
        } else if (object instanceof Optional) {
            return !((Optional) object).isPresent();
        } else if (object instanceof String) {
            return ((String) object).trim().length() == 0;
        } else if (object instanceof Collection) {
            return CollUtil.isEmpty((Collection) object);
        } else if (object instanceof Map) {
            return CollUtil.isEmpty((Map) object);
        } else if (object.getClass().isArray()) {
            return ArrayUtil.isEmpty((Object[]) object);
        } else {
            return false;
        }
    }

    /**
     * <p>判断对象是否不为空</p>
     * <p>引用指向的地址不为空</p>
     * <p>指向的值存在</p>
     * <p>字符串的长度大于0</p>
     * <p>集合的长度大于0</p>
     * <p>数组长度大于0</p>
     * <p>自定义类型只能判断是否为null</p>
     *
     * @param object
     * 		要判断的对象
     * @return 是否不为空或长度大于0
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }


}
