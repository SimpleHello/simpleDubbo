package com.demo.dubbo;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;

import com.alibaba.dubbo.config.ReferenceConfig;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

/**
 * ReferenceFactoryBean
 * 
 * @author william.liangf
 * @export
 */
public class ReferenceBean<T> extends com.alibaba.dubbo.config.spring.ReferenceBean<T> implements Cloneable {

	private static final long serialVersionUID = 213195494150089726L;

	private transient T proxy;// 代理

	private transient IVersionDesider versionDesider;// 版本决定器
	private transient ApplicationContext applicationContext;
	private transient ReferenceBean self_ = this;
	private transient ConcurrentHashMap<String, ReferenceConfig> versionMap = new ConcurrentHashMap<String, ReferenceConfig>();
	private transient final String DEFAULT_VERSION = "DEFAULT_VERSION";

	@SuppressWarnings({ "all" })
	public void setApplicationContext(ApplicationContext applicationContext) {
		super.setApplicationContext(applicationContext);
		this.applicationContext = applicationContext;
	}

	@SuppressWarnings({ "all" })
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		try {
			versionDesider = applicationContext.getBean(IVersionDesider.class);// 从上下文中查找IVersionDesider实现，该实现代表用户自定义版本规则
		} catch (Exception ex) {
			versionDesider = null;
		}
		proxy = getVersionDecideProxy();// 创建代理对象
	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings({ "all" })
	private T getVersionDecideProxy() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 创建代理工厂
		ProxyFactory proxyFactory = new ProxyFactory();
		Class[] interfaces = { Class.forName(this.getInterface()) };
		proxyFactory.setInterfaces(interfaces);
		// 创建代理类型的Class
		Class<ProxyObject> proxyClass = proxyFactory.createClass();
		T proxy = (T) proxyClass.newInstance();
		((ProxyObject) proxy).setHandler(new MethodHandler() {
			@Override
			public T invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
				T target = null;
				String version = DEFAULT_VERSION;
				if (versionDesider != null) {
					version = versionDesider.desideVersion(self_);
				}
				if (version == null)
					version = DEFAULT_VERSION;
				ReferenceConfig config = null;
				synchronized (self_) {
					config = versionMap.get(version);
					if (config == null) {
						config = (ReferenceConfig) self_.clone();
						config.setVersion(version);
						config.setCheck(false);//
						versionMap.put(version, config);
					}
				}
				target = (T) config.get();
				T retObj = (T) thisMethod.invoke(target, args);
				return retObj;

			}
		});
		return proxy;
	}

	public Object getObject() throws Exception {
		return proxy;
	}

}