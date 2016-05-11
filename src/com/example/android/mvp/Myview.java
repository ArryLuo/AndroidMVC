package com.example.android.mvp;

import java.util.List;

/**
 * Android的mvc模式： 业务逻辑层，视图层，控制层
 * 由于layout布局提供的是默认的ui，所以视图层由activity控制，
 * 而activity本身承担着控制层，这样导致activity个体很庞大.
 * 而mvp是，数据交给p管理，view与p之间进行互相交互数据.
 * 而activity只需控制view就可以解决代码臃肿问题
 * 
 * @author Luozubang
 * 
 */
public interface Myview {
	// mvp是activity控制view
	public void listData(List<String> list);
}
