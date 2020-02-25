# JYKits
Java工具集，狐兔个人修改版。

# Changelog

-------------------------------------------------------------------------------------------------------------

## 2.1.4

### 新特性

* 【poi  】     增加单元格位置引用（例如A11等方式获取单元格）
* 【core 】     修改ThreadUtil.newSingleExecutor默认队列大小
* 【core 】     修改ExecutorBuilder默认队列大小
* 【core 】     FileTypeUtil增加mp4的magic
* 【core 】     废弃isMactchRegex，改为isMatchRegex（方法错别字）
* 【core 】     Snowflake的起始时间可以被指定
* 【core 】     增加PropsUtil及getFirstFound方法
* 【core 】     XmlUtil支持可选是否输出omit xml declaration
* 【core 】     车牌号校验兼容新能源车牌
* 【core 】     在NetUtil中新增ping功能
* 【core 】     DateUtil.offset不支持ERA，增加异常提示
* 【http 】     改进HttpUtil访问HTTPS接口性能问题，SSL证书使用单例

### Bug修复
* 【core 】     修复ChineseDate的bug
* 【core 】     CharsetUtil在不支持GBK的系统中运行报错问题
* 【core 】     RandomUtil的randomEleSet方法顺序不随机的问题
* 【core 】     修复StopWatch的toString判断问题
* 【core 】     修复CombinationAnnotationElement数组判断问题
-------------------------------------------------------------------------------------------------------------

## 2.1.3

### 新特性
* 【core】     ClassUtil.isSimpleValueType增加TemporalAccessor支持
* 【core】     增加Convert.toPrimitiveByteArray方法，Convert支持对象序列化和反序列化
* 【core】     DateUtil增加isExpired(Date startDate, Date endDate, Date checkDate)
* 【core】     增加Alias注解
* 【core】     修正NumberChineseFormatter和NumberWordFormatter（类名拼写错误）
* 【core】     StrUtil增加contains方法
* 【core】     增加农历ChineseDate

### Bug修复
* 【core】     修复NumberUtil.mul中null的结果错误问题
-------------------------------------------------------------------------------------------------------------

## 2.1.2

### 新特性
* 【core】     新增WatchServer
* 【core】     ReflectUtil.getFieldValue支持static
* 【core】     改进Bean判断和注入逻辑：支持public字段注入
* 【http】     Get请求支持body，移除body（JSON）方法
* 【core】     ReflectUtil修正getFieldValue逻辑，防止歧义


### Bug修复
* 【core】     修复XmlUtil.xmlToMap中List节点的问题
* 【core】     修复ZipUtil中对于/结尾路径处理的问题
* 【core】     修复DateConvert对int不支持导致的问题

