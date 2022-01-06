package com.bingo.xls.util;

import java.util.ArrayList;
import java.util.List;

public class DataEntityList {

    private List<DataEntity> fdBuys = new ArrayList<>();        //   购买次数记录

    private long fdBuyTotalNum;                                 //   购买总数量

    private double fdBuyTotalMoney;                             //   购买总金额

    private List<DataEntity> fdSells = new ArrayList<>();       //   卖出次数记录

    private long fdSellTotalNum;                                //   卖出总数量

    private double fdSellTotalMoney;                            //   卖出金额总数

    private double fdNewPrice;                                  //   最新成本

    private long fdHaveNum;                                     //   持有可卖储量

    private double fdMoney;                                     //   金额

    private double fdProfit;                                    //   预计收益

    public void initData() {
        for (DataEntity fdBuy : this.fdBuys) {
            this.fdBuyTotalNum += fdBuy.getFdNum();
            this.fdBuyTotalMoney += fdBuy.getFdNum() * fdBuy.getFdPrice();
        }

        for (DataEntity fdSell : this.fdSells) {
            this.fdSellTotalNum += fdSell.getFdNum();
            this.fdSellTotalMoney += fdSell.getFdNum() * fdSell.getFdPrice();
        }

        this.fdHaveNum = this.fdBuyTotalNum - this.fdSellTotalNum;

        this.fdMoney = this.fdNewPrice * this.fdHaveNum;

        this.fdProfit = (this.fdSellTotalMoney - this.fdBuyTotalMoney - this.fdMoney) / this.fdSellTotalNum;
    }

    public List<DataEntity> getFdBuys() {
        return fdBuys;
    }

    public long getFdBuyTotalNum() {
        return fdBuyTotalNum;
    }

    public double getFdBuyTotalMoney() {
        return fdBuyTotalMoney;
    }

    public List<DataEntity> getFdSells() {
        return fdSells;
    }

    public long getFdSellTotalNum() {
        return fdSellTotalNum;
    }

    public double getFdSellTotalMoney() {
        return fdSellTotalMoney;
    }

    public double getFdNewPrice() {
        return fdNewPrice;
    }

    public long getFdHaveNum() {
        return fdHaveNum;
    }

    public double getFdMoney() {
        return fdMoney;
    }

    public double getFdProfit() {
        return fdProfit;
    }

    public void setFdNewPrice(double fdNewPrice) {
        this.fdNewPrice = fdNewPrice;
    }
}
