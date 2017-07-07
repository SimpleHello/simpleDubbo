package com.demo.dubbo;

import com.alibaba.dubbo.config.ReferenceConfig;

public class VersionDesiderImpl implements IVersionDesider{
	
	String version="1.0";
	/**
	 * 客户端访问的远程服务在0.0和1.0之间切换
	 */
	@Override
	public String desideVersion(ReferenceConfig referenceConfig) {
		if (version.equals("0.0")){
			version="1.0";
		}else{
			version="0.0";
		}
		
		System.out.println("当前版本:"+version);
		return version;
	}

}
