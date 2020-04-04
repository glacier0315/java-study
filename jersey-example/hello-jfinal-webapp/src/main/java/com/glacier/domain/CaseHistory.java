package com.glacier.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史减刑假释信息
 *
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017-06-15 17:28</pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseHistory implements Serializable {
    private static final long serialVersionUID = -7518439190482987879L;
    private String id;          // id
    private String xm;          //  罪犯姓名
    private String sfzh;        //  证件号码	身份证号
    /*裁定信息*/
    private String cdzh;        //  裁定字号	（xxxx）渝x法xxxx
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cdrq;          //  裁定日期	yyyy-mm-dd
    private String cdjg;        //  裁定机关	编码值
    private String jxfd;        //  减刑幅度	6位码(例020202,2年2月2日)
    private String xz;          //  变动后刑种	编码值
    private String bdhxq;       //  变动后刑期	6位码(例020202,2年2月2日)或者9995(无期)、9996(死缓)、9997(死刑)
    private String bdhbdzzql;   //  变动后剥夺政治权利
    private Integer qzcj;       //  变动后驱逐出境
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bdhxqqr;       //  变动后刑期起日	yyyy-mm-dd
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bdhxqzr;       //  变动后刑期止日	yyyy-mm-dd
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zxrq;          // 执行日期			yyyy-mm-dd
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kyqr;          //  考验起日	yyyy-mm-dd
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kyzr;          //  考验止日	yyyy-mm-dd
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cpsj;          //  裁判时间
    private Double jmfjse;      //  减免罚金数额
    private String bjrxqqj;     //  不计入刑期期间
    private String cdly;        //  裁定理由
    private Integer sfyz;       // 是否有章
    private String wjlj;        //  文件路劲	可访问的裁定书电子文件路劲
    private String ywjlj;       //  文件原路劲	可访问的裁定书电子文件路劲
    private String wjmd5;       //  文件摘要	文件摘要md5
    /*结案信息*/
    private String jalb;        //  结案类别	与减刑类别编码映射,减刑、假释、。。。
    private String jafs;        //  结案方式
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jarq;          //  结案日期

    public CaseHistory() {
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

    public String getCdzh() {
        return cdzh;
    }

    public void setCdzh(String cdzh) {
        this.cdzh = cdzh;
    }

    public Date getCdrq() {
        return cdrq;
    }

    public void setCdrq(Date cdrq) {
        this.cdrq = cdrq;
    }

    public String getCdjg() {
        return cdjg;
    }

    public void setCdjg(String cdjg) {
        this.cdjg = cdjg;
    }

    public String getJxfd() {
        return jxfd;
    }

    public void setJxfd(String jxfd) {
        this.jxfd = jxfd;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getBdhxq() {
        return bdhxq;
    }

    public void setBdhxq(String bdhxq) {
        this.bdhxq = bdhxq;
    }

    public String getBdhbdzzql() {
        return bdhbdzzql;
    }

    public void setBdhbdzzql(String bdhbdzzql) {
        this.bdhbdzzql = bdhbdzzql;
    }

    public Integer getQzcj() {
        return qzcj;
    }

    public void setQzcj(Integer qzcj) {
        this.qzcj = qzcj;
    }

    public Date getBdhxqqr() {
        return bdhxqqr;
    }

    public void setBdhxqqr(Date bdhxqqr) {
        this.bdhxqqr = bdhxqqr;
    }

    public Date getBdhxqzr() {
        return bdhxqzr;
    }

    public void setBdhxqzr(Date bdhxqzr) {
        this.bdhxqzr = bdhxqzr;
    }

    public Date getZxrq() {
        return zxrq;
    }

    public void setZxrq(Date zxrq) {
        this.zxrq = zxrq;
    }

    public Date getKyqr() {
        return kyqr;
    }

    public void setKyqr(Date kyqr) {
        this.kyqr = kyqr;
    }

    public Date getKyzr() {
        return kyzr;
    }

    public void setKyzr(Date kyzr) {
        this.kyzr = kyzr;
    }

    public Date getCpsj() {
        return cpsj;
    }

    public void setCpsj(Date cpsj) {
        this.cpsj = cpsj;
    }

    public Double getJmfjse() {
        return jmfjse;
    }

    public void setJmfjse(Double jmfjse) {
        this.jmfjse = jmfjse;
    }

    public String getBjrxqqj() {
        return bjrxqqj;
    }

    public void setBjrxqqj(String bjrxqqj) {
        this.bjrxqqj = bjrxqqj;
    }

    public String getCdly() {
        return cdly;
    }

    public void setCdly(String cdly) {
        this.cdly = cdly;
    }

    public String getWjlj() {
        return wjlj;
    }

    public void setWjlj(String wjlj) {
        this.wjlj = wjlj;
    }

    public String getWjmd5() {
        return wjmd5;
    }

    public void setWjmd5(String wjmd5) {
        this.wjmd5 = wjmd5;
    }

    public String getJalb() {
        return jalb;
    }

    public void setJalb(String jalb) {
        this.jalb = jalb;
    }

    public String getJafs() {
        return jafs;
    }

    public void setJafs(String jafs) {
        this.jafs = jafs;
    }

    public Date getJarq() {
        return jarq;
    }

    public void setJarq(Date jarq) {
        this.jarq = jarq;
    }

    public Integer getSfyz() {
        return sfyz;
    }

    public void setSfyz(Integer sfyz) {
        this.sfyz = sfyz;
    }

    public String getYwjlj() {
        return ywjlj;
    }

    public void setYwjlj(String ywjlj) {
        this.ywjlj = ywjlj;
    }

    @Override
    public String toString() {
        return "CaseHistory{" +
                "id='" + id + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", cdzh='" + cdzh + '\'' +
                ", cdrq=" + cdrq +
                ", cdjg='" + cdjg + '\'' +
                ", jxfd='" + jxfd + '\'' +
                ", xz='" + xz + '\'' +
                ", bdhxq='" + bdhxq + '\'' +
                ", bdhbdzzql='" + bdhbdzzql + '\'' +
                ", qzcj=" + qzcj +
                ", bdhxqqr=" + bdhxqqr +
                ", bdhxqzr=" + bdhxqzr +
                ", zxrq=" + zxrq +
                ", kyqr=" + kyqr +
                ", kyzr=" + kyzr +
                ", cpsj=" + cpsj +
                ", jmfjse=" + jmfjse +
                ", bjrxqqj='" + bjrxqqj + '\'' +
                ", cdly='" + cdly + '\'' +
                ", sfyz=" + sfyz +
                ", wjlj='" + wjlj + '\'' +
                ", ywjlj='" + ywjlj + '\'' +
                ", wjmd5='" + wjmd5 + '\'' +
                ", jalb='" + jalb + '\'' +
                ", jafs='" + jafs + '\'' +
                ", jarq=" + jarq +
                '}';
    }
}
