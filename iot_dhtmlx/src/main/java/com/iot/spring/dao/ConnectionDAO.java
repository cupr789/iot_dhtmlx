package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionDAO {
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	int insertConnectionInfo(ConnectionInfoVO ci);
	List<Map<String,Object>> selectDatabase();
	List<TableVO> selectTableList(String dbName);
	List<ColumnVO> selectColumnList(String tbName);
}
