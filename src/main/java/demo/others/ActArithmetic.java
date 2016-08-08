package demo.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 活动算法编写
 * 使用方法：
 * 
 * 获取算法实例
 * ActArithmetic actArtc = ActArithmetic.getInstance();
 * 
 * 初始化奖品。一般只有对活动初始化时候需要操作
 * actArtc.initGift(giftList);
 * 
 * 抽奖并返回奖品id
 * actArtc.getGiftId()
 * 
 * 如果使用actArtc.getGiftId()返回的奖品id小于等于0，则再调用一次100%比例奖品
 * actArtc.getPerGift()
 * 
 * 
 * @author michael
 * 
 */
public class ActArithmetic {
	private List<ActGift> giftList;
	private List<Integer> giftPerIds;
	private int totalPer=100;
	private static ActArithmetic actArc = new ActArithmetic();
	
	private ActArithmetic(){
	}
	
	public static ActArithmetic getInstance(){
		return actArc;
	}
	
	/**
	 * 初始化商品数据，第一次构造的时候需要执行
	 */
	private void initGift(List<ActGift> giftList){
		this.giftList = giftList;
		this.giftPerIds = new ArrayList<Integer>();
		// 初始化排序
		Collections.sort(this.giftList, new Comparator<ActGift>() {
			@Override
			public int compare(ActGift gift1, ActGift gift2) {
				return gift2.getPercent() - gift1.getPercent();
			}
		});
		// 初始化100%比例的商品
		for(ActGift gift : this.giftList){
			int percent = gift.getPercent();
			if(percent == 100){
				this.giftPerIds.add(gift.getId());
			}
		}
	}
	
	/**
	 * 获取随机商品ID
	 * 
	 * @return 返回商品ID
	 */
	public int getGiftId() {
		Random random = new Random();
		int minPer = 0;
		int rdm = random.nextInt(totalPer)%(totalPer - minPer + 1) + minPer;
		// 比例计算获取礼品id
		int giftId = giftRandom(rdm);
		// 如果获取的商品id小于等于0时，去查询有没有比例为100%的商品,并返回id
		if(giftId <= 0){
			return getPerGift();
		}else{
			return giftId;
		}
	}
	
	/**
	 * 获取100%比例商品ID。如果是多个100%，则随机获取一个100%的id
	 * 
	 * @return 返回商品ID
	 */
	public int getPerGift() {
		int minPer = 1;
		int maxPer = giftPerIds.size();
		Random random = new Random();
		if(maxPer > 0){
			int rdm = random.nextInt(maxPer)%(maxPer - minPer + 1) + minPer;
			return giftPerIds.get(rdm - 1);
		}
		return 0;
	}

	/**
	 * 根据随机值获取礼品
	 * 
	 * @param rdm
	 * @return
	 */
	private int giftRandom(int rdm) {
		double start = 0;
		double end = 0;
		for(ActGift gift : giftList){
			start = end;
			int percent = gift.getPercent();
			end += percent;
			if (rdm >= start && rdm <= end && percent != 100) {
				return gift.getId();
			}else{
				continue;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		List<ActGift> giftList = new ArrayList<ActGift>();
		giftList.add(new ActGift(1, "奖品1", 1, 1, 6));
		giftList.add(new ActGift(2, "奖品2", 1, 1, 8));
		giftList.add(new ActGift(3, "奖品3", 1, 1, 12));
		giftList.add(new ActGift(4, "奖品4", 1, 1, 14));
		giftList.add(new ActGift(5, "奖品5", 1, 1, 18));
		giftList.add(new ActGift(5, "奖品3", 1, 1, 4));
		
		ActArithmetic actArtc = ActArithmetic.getInstance();
		actArtc.initGift(giftList);
		for(int i=0;i<50;i++){
			System.out.println(actArtc.getGiftId());
		}
	}
}
