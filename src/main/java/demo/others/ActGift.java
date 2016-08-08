package act;

/**
 * 活动奖品
 * 
 * @author michael
 *
 */
public class ActGift {
	private int id;
	/** 商品名称 */
	private String name;
	/** 奖品个数 */
	private int num;
	/** 每天抽中个数 */
	private int daynum;
	/** 抽中比例 */
	private int percent;
	
	public ActGift() {
	}
	public ActGift(int id, String name, int num, int daynum, int percent) {
		this.id = id;
		this.name = name;
		this.num = num;
		this.daynum = daynum;
		this.percent = percent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDaynum() {
		return daynum;
	}
	public void setDaynum(int daynum) {
		this.daynum = daynum;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
}
