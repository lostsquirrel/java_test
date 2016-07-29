package demo.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestList {

	private static final Logger log = LoggerFactory.getLogger(TestList.class);
	
	@Test
	public void reassginListItem() throws Exception {
		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < 10; i++) {
			list.add(new Item("Item:"+i));
		}
		log.debug(list.toString());
		for (Item item: list) {
			item = new Item("Item xx");
			item.setFoo(item.getFoo() + "xx");
		}
		log.debug(list.toString());
	}
}

class Item {
	
	private String foo;
	
	Item(String foo){
		this.foo = foo;
	}
	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}
	@Override
	public String toString() {
		return this.foo;
	}
}