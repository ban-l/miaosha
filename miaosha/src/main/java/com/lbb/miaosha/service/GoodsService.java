package com.lbb.miaosha.service;

import java.util.List;

import com.lbb.miaosha.dao.GoodsDao;
import com.lbb.miaosha.domain.MiaoshaGoods;
import com.lbb.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
	
	@Autowired
    GoodsDao goodsDao;
	
	public List<GoodsVo> listGoodsVo(){
		return goodsDao.listGoodsVo();
	}

	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsDao.getGoodsVoByGoodsId(goodsId);
	}

	public boolean reduceStock(GoodsVo goods) {
		MiaoshaGoods g = new MiaoshaGoods();
		g.setGoodsId(goods.getId());
		int ret = goodsDao.reduceStock(g);
		return ret > 0;
	}

	public void resetStock(List<GoodsVo> goodsList) {
		for(GoodsVo goods : goodsList ) {
			MiaoshaGoods g = new MiaoshaGoods();
			g.setGoodsId(goods.getId());
			g.setStockCount(goods.getStockCount());
			goodsDao.resetStock(g);
		}
	}
	
	
	
}
