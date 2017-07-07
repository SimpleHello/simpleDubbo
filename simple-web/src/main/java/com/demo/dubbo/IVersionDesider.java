package com.demo.dubbo;

import com.alibaba.dubbo.config.ReferenceConfig;

public interface IVersionDesider {
	public String desideVersion(ReferenceConfig referenceConfig);
}
