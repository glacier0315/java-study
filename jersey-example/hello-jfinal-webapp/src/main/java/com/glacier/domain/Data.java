package com.glacier.domain;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * xml报文根节点
 *
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017-05-24 11:23</pre>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data<T> implements Serializable {
    private static final long serialVersionUID = -3999268410131567805L;

    private Integer zt;//

    private String bz;

    private Integer count;

    @XmlElementWrapper
    @XmlAnyElement(lax = true)
    private List<T> records;

    public Data() {
    }

    public Data(Integer zt, String bz) {
        this.zt = zt;
        this.bz = bz;
    }

    public Data(T record) {
        List<T> records = new ArrayList<>();
        records.add(record);
        this.count = records.size();
        this.records = records;
    }

    public Data(List<T> records) {
        this.count = records.size();
        this.records = records;
    }

    public Data(Integer count, List<T> records) {
        this.count = count;
        this.records = records;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getRecords() {
        if (records == null) {
            records = Collections.emptyList();
        }
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Data{" +
                "zt=" + zt +
                ", bz='" + bz + '\'' +
                ", count=" + count +
                ", records=" + records +
                '}';
    }
}
