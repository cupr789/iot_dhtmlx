package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionDAO conDAO;
	
	@Override
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci) {
		
		return conDAO.selectConnectionInfo(ci);
	}

	@Override
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map insertConnectionInfo(Map map,ConnectionInfoVO ci) {
		int result = conDAO.insertConnectionInfo(ci);
		if(result>=1) {
			map.put("msg", "입력성공");
		}else {
			map.put("msg", "입력실패");
		}
		
		return map;
	}

	@Override
	public List<Map<String, Object>> getDatabaseList() {
		List<Map<String,Object>> dbList = conDAO.selectDatabase();
		int idx =0;
		for(Map<String,Object> mDb: dbList) {
			mDb.put("id", ++idx);
			mDb.put("text", mDb.get("Database"));
			mDb.put("items", new Object[] {});
		}
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(String dbName) {
		return conDAO.selectTableList(dbName);
	}

	@Override
	public List<ColumnVO> getColumnList(String tbName) {
		System.out.println(conDAO.selectColumnList(tbName));
		return conDAO.selectColumnList(tbName);
	}


}
