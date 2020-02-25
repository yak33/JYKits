package com.junya.core.util;

import com.junya.core.lang.ObjectId;
import com.junya.core.lang.Singleton;
import com.junya.core.lang.Snowflake;
import com.junya.core.lang.UUID;

import java.util.HashMap;
import java.util.Map;

/**
 * ID生成器工具类，此工具类中主要封装：
 * 
 * <pre>
 * 1. 唯一性ID生成器：UUID、ObjectId（MongoDB）、Snowflake
 * </pre>
 * 
 * <p>
 * ID相关文章见：http://calvin1978.blogcn.com/articles/uuid.html
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class IdUtil {

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };

	final static Map<Character, Integer> digitMap = new HashMap<Character, Integer>();

	static {
		for (int i = 0; i < digits.length; i++) {
			digitMap.put(digits[i], (int) i);
		}
	}

	/**
	 * 支持的最大进制数
	 */
	public static final int MAX_RADIX = digits.length;

	/**
	 * 支持的最小进制数
	 */
	public static final int MIN_RADIX = 2;

	// ------------------------------------------------------------------- UUID
	/**
	 * 获取随机UUID
	 * 
	 * @return 随机UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 简化的UUID，去掉了横线
	 * 
	 * @return 简化的UUID，去掉了横线
	 */
	public static String simpleUUID() {
		return UUID.randomUUID().toString(true);
	}

	/**
	 * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
	 * 
	 * @return 随机UUID
	 * @since 2.0.3
	 */
	public static String fastUUID() {
		return UUID.fastUUID().toString();
	}

	/**
	 * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
	 * 
	 * @return 简化的UUID，去掉了横线
	 * @since 2.0.3
	 */
	public static String fastSimpleUUID() {
		return UUID.fastUUID().toString(true);
	}

	/**
	 * 编写uuid生成工具方法
	 * @param val
	 * @param digits
	 * @return
	 */
	public static String digits(long val, int digits) {
		long hi = 1L << (digits * 4);
		return toString(hi | (val & (hi - 1)), MAX_RADIX)
				.substring(1);
	}

	/**
	 * 以62进制（字母加数字）生成19位UUID，最短的UUID
	 *
	 * @return
	 */
	public static String uuid() {
		java.util.UUID uuid = java.util.UUID.randomUUID();
		StringBuilder sb = new StringBuilder();
		sb.append(digits(uuid.getMostSignificantBits() >> 32, 8));
		sb.append(digits(uuid.getMostSignificantBits() >> 16, 4));
		sb.append(digits(uuid.getMostSignificantBits(), 4));
		sb.append(digits(uuid.getLeastSignificantBits() >> 48, 4));
		sb.append(digits(uuid.getLeastSignificantBits(), 12));
		return sb.toString();
	}

	/**
	 * 将长整型数值转换为指定的进制数（最大支持62进制，字母数字已经用尽）
	 *
	 * @param i
	 * @param radix
	 * @return
	 */
	public static String toString(long i, int radix) {
		if (radix < MIN_RADIX || radix > MAX_RADIX) {
			radix = 10;
		}
		if (radix == 10) {
			return Long.toString(i);
		}

		final int size = 65;
		int charPos = 64;

		char[] buf = new char[size];
		boolean negative = (i < 0);

		if (!negative) {
			i = -i;
		}

		while (i <= -radix) {
			buf[charPos--] = digits[(int) (-(i % radix))];
			i = i / radix;
		}
		buf[charPos] = digits[(int) (-i)];

		if (negative) {
			buf[--charPos] = '-';
		}

		return new String(buf, charPos, (size - charPos));
	}

	/**
	 * 创建MongoDB ID生成策略实现<br>
	 * ObjectId由以下几部分组成：
	 * 
	 * <pre>
	 * 1. Time 时间戳。
	 * 2. Machine 所在主机的唯一标识符，一般是机器主机名的散列值。
	 * 3. PID 进程ID。确保同一机器中不冲突
	 * 4. INC 自增计数器。确保同一秒内产生objectId的唯一性。
	 * </pre>
	 * 
	 * 参考：http://blog.csdn.net/qxc1281/article/details/54021882
	 * 
	 * @return ObjectId
	 */
	public static String objectId() {
		return ObjectId.next();
	}

	/**
	 * 创建Twitter的Snowflake 算法生成器<br>
	 * 分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。
	 * 
	 * <p>
	 * snowflake的结构如下(每部分用-分开):<br>
	 * 
	 * <pre>
	 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
	 * </pre>
	 * 
	 * 第一位为未使用，接下来的41位为毫秒级时间(41位的长度可以使用69年)<br>
	 * 然后是5位datacenterId和5位workerId(10位的长度最多支持部署1024个节点）<br>
	 * 最后12位是毫秒内的计数（12位的计数顺序号支持每个节点每毫秒产生4096个ID序号）
	 * 
	 * <p>
	 * 参考：http://www.cnblogs.com/relucent/p/4955340.html
	 * 
	 * @param workerId 终端ID
	 * @param datacenterId 数据中心ID
	 * @return {@link Snowflake}
	 */
	public static Snowflake createSnowflake(long workerId, long datacenterId) {
		return new Snowflake(workerId, datacenterId);
	}

	/**
	 * 获取单例的Twitter的Snowflake 算法生成器对象<br>
	 * 分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。
	 * 
	 * <p>
	 * snowflake的结构如下(每部分用-分开):<br>
	 * 
	 * <pre>
	 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
	 * </pre>
	 * 
	 * 第一位为未使用，接下来的41位为毫秒级时间(41位的长度可以使用69年)<br>
	 * 然后是5位datacenterId和5位workerId(10位的长度最多支持部署1024个节点）<br>
	 * 最后12位是毫秒内的计数（12位的计数顺序号支持每个节点每毫秒产生4096个ID序号）
	 * 
	 * <p>
	 * 参考：http://www.cnblogs.com/relucent/p/4955340.html
	 * 
	 * @param workerId 终端ID
	 * @param datacenterId 数据中心ID
	 * @return {@link Snowflake}
	 * @since 2.0.3
	 */
	public static Snowflake getSnowflake(long workerId, long datacenterId) {
		return Singleton.get(Snowflake.class, workerId, datacenterId);
	}
}
