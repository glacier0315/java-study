package com.glacier.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 文书请求 查询判决信息和裁定信息
 *
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017-06-16 15:03</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "data")
public class DocRequest implements Serializable {
    private static final long serialVersionUID = 5594543832723046825L;
    private String no;
    private String xm;
    private String sfzh;

    public DocRequest() {
    }

    public DocRequest(String no, String xm, String sfzh) {
        this.no = no;
        this.xm = xm;
        this.sfzh = sfzh;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    @Override
    public String toString() {
        return "DocRequest{" +
                "no='" + no + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                '}';
    }
}
