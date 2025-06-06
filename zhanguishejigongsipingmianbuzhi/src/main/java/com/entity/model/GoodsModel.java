package com.entity.model;

import com.entity.GoodsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 展柜设计
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GoodsModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 展柜名称
     */
    private String goodsName;


    /**
     * 展柜类型
     */
    private Integer goodsTypes;


    /**
     * 展柜图片
     */
    private String goodsPhoto;


    /**
     * 品牌
     */
    private String goodsPinpai;


    /**
     * 价格
     */
    private Double goodsNewMoney;


    /**
     * 材质
     */
    private String goodsCaizhi;


    /**
     * 附加功能
     */
    private String goodsFujia;


    /**
     * 产地
     */
    private String goodsCandi;


    /**
     * 详情
     */
    private String goodsContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：展柜名称
	 */
    public String getGoodsName() {
        return goodsName;
    }


    /**
	 * 设置：展柜名称
	 */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 获取：展柜类型
	 */
    public Integer getGoodsTypes() {
        return goodsTypes;
    }


    /**
	 * 设置：展柜类型
	 */
    public void setGoodsTypes(Integer goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
    /**
	 * 获取：展柜图片
	 */
    public String getGoodsPhoto() {
        return goodsPhoto;
    }


    /**
	 * 设置：展柜图片
	 */
    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
    /**
	 * 获取：品牌
	 */
    public String getGoodsPinpai() {
        return goodsPinpai;
    }


    /**
	 * 设置：品牌
	 */
    public void setGoodsPinpai(String goodsPinpai) {
        this.goodsPinpai = goodsPinpai;
    }
    /**
	 * 获取：价格
	 */
    public Double getGoodsNewMoney() {
        return goodsNewMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setGoodsNewMoney(Double goodsNewMoney) {
        this.goodsNewMoney = goodsNewMoney;
    }
    /**
	 * 获取：材质
	 */
    public String getGoodsCaizhi() {
        return goodsCaizhi;
    }


    /**
	 * 设置：材质
	 */
    public void setGoodsCaizhi(String goodsCaizhi) {
        this.goodsCaizhi = goodsCaizhi;
    }
    /**
	 * 获取：附加功能
	 */
    public String getGoodsFujia() {
        return goodsFujia;
    }


    /**
	 * 设置：附加功能
	 */
    public void setGoodsFujia(String goodsFujia) {
        this.goodsFujia = goodsFujia;
    }
    /**
	 * 获取：产地
	 */
    public String getGoodsCandi() {
        return goodsCandi;
    }


    /**
	 * 设置：产地
	 */
    public void setGoodsCandi(String goodsCandi) {
        this.goodsCandi = goodsCandi;
    }
    /**
	 * 获取：详情
	 */
    public String getGoodsContent() {
        return goodsContent;
    }


    /**
	 * 设置：详情
	 */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
