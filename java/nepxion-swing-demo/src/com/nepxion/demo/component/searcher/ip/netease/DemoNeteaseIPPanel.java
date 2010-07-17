package com.nepxion.demo.component.searcher.ip.netease;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.searcher.ip.netease.JNeteaseIPPanel;

public class DemoNeteaseIPPanel
	extends JPanel
{
	public DemoNeteaseIPPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new NeteaseIPPanel());
	}
	
	public class NeteaseIPPanel
		extends JPanel
	{
		public NeteaseIPPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "根据IP地址查询地理位置"));
			
			JNeteaseIPPanel ipPanel = new JNeteaseIPPanel();
			add(ipPanel);
		}
	}
}