package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.simple.spi.entity.DemoEntity;
import org.simple.spi.service.DemoService;
import org.springframework.stereotype.Service;

@Service("webService")
public class DemoServiceImpl implements DemoService {

	@Override
	public String getName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DemoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		return list;
	}

}
