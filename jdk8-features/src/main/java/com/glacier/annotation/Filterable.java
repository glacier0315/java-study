package com.glacier.annotation;

/**
 * date 2021-05-03 14:14
 *
 * @author glacier
 * @version 1.0
 */
@Filter(value = "filter1", value2 = "111")
@Filter(value = "filter2", value2 = "222")
//@Filters({@Filter(  value="filter1",value2="111" ),@Filter(  value="filter2", value2="222")}).注意：JDK8之前：1.没有@Repeatable2.采用本行“注解容器”写法
public interface Filterable {
}
