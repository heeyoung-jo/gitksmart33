package kr.or.ksmart.ksmart_mybatis.vo;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private String goodsCate;
	private String goodsPrice;
	private String goodsMade;
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsCate() {
		return goodsCate;
	}
	public void setGoodsCate(String goodsCate) {
		this.goodsCate = goodsCate;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsMade() {
		return goodsMade;
	}
	public void setGoodsMade(String goodsMade) {
		this.goodsMade = goodsMade;
	}
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsCate=" + goodsCate
				+ ", goodsPrice=" + goodsPrice + ", goodsMade=" + goodsMade + "]";
	}
	
	
}
