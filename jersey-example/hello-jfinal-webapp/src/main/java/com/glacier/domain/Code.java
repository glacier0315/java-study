package com.glacier.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 0.0.1
 * @author glacier
 * @date 2017/3/21 0021
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Code implements Serializable {
    private static final long serialVersionUID = 4121303504439804708L;
    private String id;      //id
    private String cn;      //名称
    private String abr;     // 中文简拼
    private String bm;      // 编码
    private String pbm;     // 上一级节点编码
    private int scbj;       // 删除标记
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gzrq;      // 最新更新日期

    public Code() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getPbm() {
        return pbm;
    }

    public void setPbm(String pbm) {
        this.pbm = pbm;
    }

    public int getScbj() {
        return scbj;
    }

    public void setScbj(int scbj) {
        this.scbj = scbj;
    }

    public Date getGzrq() {
        return gzrq;
    }

    public void setGzrq(Date gzrq) {
        this.gzrq = gzrq;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id='" + id + '\'' +
                ", cn='" + cn + '\'' +
                ", abr='" + abr + '\'' +
                ", bm='" + bm + '\'' +
                ", pbm='" + pbm + '\'' +
                ", scbj=" + scbj +
                ", gzrq=" + gzrq +
                '}';
    }
}