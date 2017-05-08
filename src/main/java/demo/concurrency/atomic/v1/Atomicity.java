package demo.concurrency.atomic.v1;

/**
 * javap -c demo.concurrency.atomic.Atomicity
 * 查看结果
 * 证明其线程不安全
 * @author lisong
 *
 */
public class Atomicity {

	int i;
	
	void f1() {
		i++;
	}
	
	void f2() {
		i += 3;
	}
}
