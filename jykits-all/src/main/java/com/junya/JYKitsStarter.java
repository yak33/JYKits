package com.junya;

import com.junya.core.collection.CollectionUtil;
import com.junya.core.date.DateUtil;
import com.junya.core.lang.Console;
import com.junya.core.util.ArrayUtil;
import com.junya.core.util.NumberUtil;
import com.junya.http.HtmlUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author zhangchao
 * @date 2019/12/7 15:50
 * @since 2.0.1
 */
public class JYKitsStarter {
    public static void main(String[] args) {

        Date date = DateUtil.offsetHour(new Date(),Integer.parseInt("-"+"6"));
        Console.log(date);

        Date date1 = DateUtil.yesterday();
        Console.log(date1);


        List<Long> list = CollectionUtil.newArrayList();
        list.add(88L);
        list.add(5L);
        list.add((9L));
        Long[] arr = ArrayUtil.toArray(list,Long.class);
        Console.log(arr);
    }

}
