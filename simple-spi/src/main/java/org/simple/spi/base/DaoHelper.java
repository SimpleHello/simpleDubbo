package org.simple.spi.base;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;


public class DaoHelper extends SqlSessionDaoSupport {
	
	private  SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	

	public  Object insert(String nameSpace,String sqlID,IEntity entity) throws Exception{
		try{
			return (Object)sqlSessionTemplate.insert(getStatement(nameSpace, sqlID), entity);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  Object insert(String nameSpace,IEntity entity) throws Exception{
		try{
			return insert(nameSpace, "insert", entity);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  Object update(String nameSpace,String sqlID,IEntity entity) throws Exception{
		try{
			return (Object)sqlSessionTemplate.update(getStatement(nameSpace, sqlID), entity);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  Object update(String nameSpace, IEntity entity)throws Exception{
		try{
			return update(nameSpace, "update", entity);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public  int delete(String nameSpace,String sqlID,IEntity entity) throws Exception{
		try{
			return sqlSessionTemplate.delete(getStatement(nameSpace, sqlID), entity);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  int delete(String nameSpace, IEntity entity) throws Exception{
		try{
			return delete(nameSpace, "delete", entity);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  <T extends IEntity> T getOne(String nameSpace,String sqlID,IEntity paramObject) throws Exception{
		try{
			return sqlSessionTemplate.selectOne(getStatement(nameSpace, sqlID), paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  <T extends IEntity> T getOne(String nameSpace, IEntity paramObject) throws Exception{
		try{
			return getOne(nameSpace, "getone", paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  <T extends IEntity> List<T> query(String nameSpace, String sqlID, IEntity paramObject) throws Exception{
		try{
			return sqlSessionTemplate.selectList(getStatement(nameSpace, sqlID), paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  <T extends IEntity> List<T> query(String nameSpace, IEntity paramObject) throws Exception{
		try{
			return query(nameSpace,"query", paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  <T extends IEntity> List<T> page(String nameSpace, String sqlID, IEntity paramObject) throws Exception{
		try{
			return sqlSessionTemplate.selectList(getStatement(nameSpace, sqlID), paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  <T extends IEntity> List<T> page(String nameSpace, IEntity paramObject) throws Exception{
		try{
			return page(nameSpace,"page", paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  int count(String nameSpace, String sqlID, IEntity paramObject) throws Exception{
		try{
			return Integer.valueOf(String.valueOf(sqlSessionTemplate.selectOne(getStatement(nameSpace, sqlID), paramObject)));
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public  int count(String nameSpace, IEntity paramObject) throws Exception{
		try{
			return count(nameSpace, "count", paramObject);
		}
		catch(Exception ex){
			throw  ex;
		}
	}
	
	public  Object queryObject(String nameSpace, String sqlID, IEntity paramObject) throws Exception{
		try{
			return sqlSessionTemplate.selectOne(getStatement(nameSpace, sqlID), paramObject);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	private  String getStatement(String nameSpace,String sqlID){
		return nameSpace+"."+sqlID;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

}
