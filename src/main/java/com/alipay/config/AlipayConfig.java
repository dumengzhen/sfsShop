package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088612663452304";
	
	// 收款支付宝账号
	public static String seller_email = "18437980765";
	// 商户的私钥
	public static String key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDU/AFDImd/Ma7uYfYxSGBA5dZ9AMy/zsR+o68Dm/XaPhqBHGo/xlfRM7rjsZARZXwohIpCOLL0ij1wuyLs/3RRz8t/pDBMACjb7L7Q5/mqAuzOU2wqyLz73v+LqZloYqXFbutMIgTZY0DYS5itHo0pTaM1u8feEAgJq0UsTP0Z5YWMblS71+tOnGI4RlyaROwuI5VMPmYsaOE2JbI0U5Z0EvVCl41re4Nxg5qaiih9pulqR4WM3CCy4oaSOE87GuGHc8lvDYt17vHlok5mK5aWNbM5OKATuhwHQ77xSuj+umORkbAisl97aWZF8mXRiKYgI95lrfVXgvD0bLezHBh5AgMBAAECggEBAK1ToFtYJk32ytuo0UfuFJb79H+qJPZ7eKFu58DSLVO8cqlbzIO2EEVqCc++8vWVV2NJ6ZJWvhwQXEvfn16rzae+qWdo4P0YrCe+FNPB1QYsdza54S84ScPYCLNKBFRU43828znz/WpEQcNEUi2gzVQtoILcHJ11AnWL8jFJPjjRerlRyCgdxDqGlcyKv3QTEclrefEPvLdFD2k7PRbuT3C1MwY3fYjH1eeHEfTwNsLr5hxEiKhJqDCyNErZIrEFrkjd7I2mbSvaLq20YWV0sugWw2cMpq/MA4YzNrkAuem9fCbq82zoYCbcUm9RXOpPrCyjxiZy/11DwDOFNYKakmECgYEA642/CtgdDQa2spDc0oHpTPOj1IjDL8yeApVvuwb6OVp25f1gZfnheiPejQ6uHtSvKHbw7RdjhPzVIuFH6ocIixpcKmXBG42sDFH0r60QQ7JqwrPeCJOOFYUGO6BIgU3rOgm1w7+Gdpd4d4DFtGLBhhIiywhNB1zzapCKKqDqROUCgYEA53i+qRoG+Xdf0uit4YlYkeRVhD5Nv5mCDSDRbeNxRnLz3vxcB0X0Pj122eYgWheLrtM+JlnLDLqU4Jv+riHTRQw4CICtkJV8EjUOhBMYdha7NTCTu0b7bKtuCTIBIiqE9xw12ARiHXtxtXhi2EtrLNwEk2gp08Kd5gcV9BaZwAUCgYEAyyM0q99wPjmZ+SigpxHN5sT+dl1zJpepdMT21C3SQP/ZJcJ7DbaPUsv4M2GDm6cDXzwjzfOrqZZ5IFlzsbe+EGgtL4sNG/vzcbSD9bSkIB2PoFWJl4/YqopLs8Qogwp1X1ncXPGgvkkmZLiyxzubdUnSo5GHDGCGs1HvNZAMOFkCgYEAmttwCufrxJg1ln+uXNYrWCd/guK/1zBXDntnQXJJhU1AlG0XEJKfbchnLC5GdJ+OBt8ylCu8qX5mPcJ/Z3YfxvD+x8l21OT9RZ0TYg74bYCVrGccXs2FRdWG30YB9h6mKEBKUYPVNE4y66pnzrbeM/vaX9fvK8nnI06YRF2ebRUCgYBapt2gF2Wi3L4c54EaMrB4y6HLgDwq+omPT5fBquczav9UbubjM1+syxgcqU0z/gAz1pNJ3fvQnXYoNUY/FH0WjRqABaKwAiUvY0+bPNqOdboEQAl1BOiJs2+heBjew0T1AoLAayrtxoXnpERmHflmzlsxKkxYjFNQJVx9w4khkg==";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";

}
