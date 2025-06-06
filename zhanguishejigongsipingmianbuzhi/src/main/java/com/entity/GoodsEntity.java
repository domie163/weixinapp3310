package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 展柜设计
 *
 * @author 
 * @email
 */
@TableName("goods")
public class GoodsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GoodsEntity() {

	}

	public GoodsEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 展柜名称
     */
    @TableField(value = "goods_name")

    private String goodsName;


    /**
     * 展柜类型
     */
    @TableField(value = "goods_types")

    private Integer goodsTypes;


    /**
     * 展柜图片
     */
    @TableField(value = "goods_photo")

    private String goodsPhoto;


    /**
     * 品牌
     */
    @TableField(value = "goods_pinpai")

    private String goodsPinpai;


    /**
     * 价格
     */
    @TableField(value = "goods_new_money")

    private Double goodsNewMoney;


    /**
     * 材质
     */
    @TableField(value = "goods_caizhi")

    private String goodsCaizhi;


    /**
     * 附加功能
     */
    @TableField(value = "goods_fujia")

    private String goodsFujia;


    /**
     * 产地
     */
    @TableField(value = "goods_candi")

    private String goodsCandi;


    /**
     * 详情
     */
    @TableField(value = "goods_content")

    private String goodsContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：展柜名称
	 */
    public String getGoodsName() {
        return goodsName;
    }


    /**
	 * 获取：展柜名称
	 */

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
	 * 设置：展柜类型
	 */
    public Integer getGoodsTypes() {
        return goodsTypes;
    }


    /**
	 * 获取：展柜类型
	 */

    public void setGoodsTypes(Integer goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
    /**
	 * 设置：展柜图片
	 */
    public String getGoodsPhoto() {
        return goodsPhoto;
    }


    /**
	 * 获取：展柜图片
	 */

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
    /**
	 * 设置：品牌
	 */
    public String getGoodsPinpai() {
        return goodsPinpai;
    }


    /**
	 * 获取：品牌
	 */

    public void setGoodsPinpai(String goodsPinpai) {
        this.goodsPinpai = goodsPinpai;
    }
    /**
	 * 设置：价格
	 */
    public Double getGoodsNewMoney() {
        return goodsNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setGoodsNewMoney(Double goodsNewMoney) {
        this.goodsNewMoney = goodsNewMoney;
    }
    /**
	 * 设置：材质
	 */
    public String getGoodsCaizhi() {
        return goodsCaizhi;
    }


    /**
	 * 获取：材质
	 */

    public void setGoodsCaizhi(String goodsCaizhi) {
        this.goodsCaizhi = goodsCaizhi;
    }
    /**
	 * 设置：附加功能
	 */
    public String getGoodsFujia() {
        return goodsFujia;
    }


    /**
	 * 获取：附加功能
	 */

    public void setGoodsFujia(String goodsFujia) {
        this.goodsFujia = goodsFujia;
    }
    /**
	 * 设置：产地
	 */
    public String getGoodsCandi() {
        return goodsCandi;
    }


    /**
	 * 获取：产地
	 */

    public void setGoodsCandi(String goodsCandi) {
        this.goodsCandi = goodsCandi;
    }
    /**
	 * 设置：详情
	 */
    public String getGoodsContent() {
        return goodsContent;
    }


    /**
	 * 获取：详情
	 */

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "id=" + id +
            ", goodsName=" + goodsName +
            ", goodsTypes=" + goodsTypes +
            ", goodsPhoto=" + goodsPhoto +
            ", goodsPinpai=" + goodsPinpai +
            ", goodsNewMoney=" + goodsNewMoney +
            ", goodsCaizhi=" + goodsCaizhi +
            ", goodsFujia=" + goodsFujia +
            ", goodsCandi=" + goodsCandi +
            ", goodsContent=" + goodsContent +
            ", createTime=" + createTime +
        "}";
    }
}
