/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Money
 * Author:   我们
 * Date:     2021/2/12 20:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package AnnotationDemo;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/12
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@Ignore
@Deprecated
@MyAnnotation(num = "11")
public class Money implements Serializable {

    @MyAnnotation(num = "11")
    public String toString() {
        return "money";
    }
}
